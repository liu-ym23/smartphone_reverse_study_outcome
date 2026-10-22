package com.ss.android.lark.newemoji.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.loader.EmojiImageResource;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.y0;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qsb.h;
import rkb.g;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class EmojiMapManager2 extends c0c.c implements rsb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, qsb.a> f433017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, qsb.a> f433018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f433019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExecutorService f433020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, CopyOnWriteArrayList<WeakReference<IGetDataCallback<Boolean>>>> f433021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<String, CopyOnWriteArrayList<WeakReference<IGetDataCallback<Boolean>>>> f433022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f433023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f433024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f433025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public rsb.a.InterfaceC7530a f433026k;

    public static final class a {
    }

    public static final class b implements g<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f433027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f433028b;

        public b(long r100, String r101) {
            this.f433027a = r100;
            this.f433028b = r101;
        }

        @Override // rkb.g
        public final boolean onLoadFailed(Exception r100, Object r110, Target<Object> r111, boolean r112) {
            long r101 = SystemClock.elapsedRealtime() - this.f433027a;
            int r113 = qsb.c.f534734a;
            String r102 = this.f433028b;
            if (r100 == null) goto L5;
            String r103 = r100.getMessage();
        L6:
            String r104 = r103;
            Intrinsics.checkNotNullParameter(r102, "imageKey");
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new h(r102, r104, r101, -1));
            return false;
        L5:
            r103 = null;
            goto L6
        }

        @Override // rkb.g
        public final boolean onResourceReady(Object r100, Object r101, Target<Object> r102, DataSource r110, boolean r111) {
            long r103 = SystemClock.elapsedRealtime() - this.f433027a;
            int r104 = qsb.c.f534734a;
            String r105 = this.f433028b;
            Intrinsics.checkNotNullParameter(r105, "imageKey");
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new h(r105, null, r103, 0));
            return false;
        }
    }

    public static final class c extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ qsb.a f433029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f433030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EmojiMapManager2 f433031c;

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            super.onLoadFailed(r100);
            Log.i("EmojiMapManager2", "loadBitmapFromNet failed, emojiKey: " + this.f433029a.f534723a + ", imageKey: " + this.f433030b);
            EmojiMapManager2 r101 = this.f433031c;
            r101.f433020e.execute(new com.ss.android.lark.newemoji.impl.b(r101, this.f433029a.f534723a, false));
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            StringBuilder r102 = new StringBuilder("loadBitmapFromNet success, emojiKey: ");
            r102.append(this.f433029a.f534723a);
            r102.append(", imageKey: ");
            r102.append(this.f433030b);
            r102.append(", resource valid: ");
            if (r101 == null) goto L5;
            boolean r103 = true;
        L6:
            r102.append(r103);
            Log.i("EmojiMapManager2", r102.toString());
            if (r101 == null) goto L16;
            EmojiMapManager2 r104 = this.f433031c;
            qsb.a r105 = this.f433029a;
            monitor-enter(this);
            r105.f534727e = r101;     // Catch: Throwable -> L13
            Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L13
            monitor-exit(this);
            String r107 = r105.f534723a;
            r104.f433020e.execute(new com.ss.android.lark.newemoji.impl.b(r104, r107, true));
            return;
        L13:
            th = move-exception;
            throw th;
        L16:
            return;
        L5:
            r103 = false;
            goto L6
        }

        public c(qsb.a r100, String r101, EmojiMapManager2 r102) {
            this.f433029a = r100;
            this.f433030b = r101;
            this.f433031c = r102;
        }
    }

    static {
    }

    @Override // rsb.a
    public final int U9() {
        monitor-enter(this);
        int r100 = this.f433024i;     // Catch: Throwable -> L6
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // rsb.a
    public final void f3() {
        Log.i("EmojiMapManager2", "resetMap");
        monitor-enter(this);
        this.f433019d.clear();     // Catch: Throwable -> L8
        this.f433017b.clear();     // Catch: Throwable -> L8
        this.f433018c.clear();     // Catch: Throwable -> L8
        this.f433021f.clear();     // Catch: Throwable -> L8
        this.f433022g.clear();     // Catch: Throwable -> L8
        this.f433024i = this.f433023h;     // Catch: Throwable -> L8
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(this);
        u();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void u() {
        n(this, R.string.Emoji_Smile, "Lark_Emoji_Smile_0", "SMILE", "emoji_smile.png", R.drawable.emoji_smile, false, "微笑", null, 128);
        n(this, R.string.Emoji_Drool, "Lark_Emoji_Drool_0", "DROOL", "emoji_drool.png", R.drawable.emoji_drool, false, "爱慕", null, 128);
        n(this, R.string.Emoji_Scowl, "Lark_Emoji_Scowl_0", "SCOWL", "emoji_scowl.png", R.drawable.emoji_scowl, false, "惊呆", null, 128);
        n(this, R.string.Emoji_Irritated, "Lark_Emoji_haughty_0", "HAUGHTY", "emoji_irritated_v2.png", R.drawable.emoji_irritated, false, "酷拽", null, 128);
        n(this, R.string.Emoji_NosePick, "Lark_Emoji_NosePick_0", "NOSEPICK", "emoji_nosepick.png", R.drawable.emoji_nosepick, false, "抠鼻", null, 128);
        n(this, R.string.Emoji_Sob, "Lark_Emoji_Sob_0", "SOB", "emoji_sob.png", R.drawable.emoji_sob, false, "流泪", null, 128);
        n(this, R.string.Emoji_Angry, "Lark_Emoji_Angry_0", "ANGRY", "emoji_angry.png", R.drawable.emoji_angry, false, "发怒", null, 128);
        n(this, R.string.Emoji_Grin, "Lark_Emoji_Grin_0", "BLUSH", "emoji_grin.png", R.drawable.emoji_grin, false, "呲牙", null, 128);
        n(this, R.string.Emoji_Sleep, "Lark_Emoji_Sleep_0", "SLEEP", "emoji_sleep.png", R.drawable.emoji_sleep, false, "鼾睡", null, 128);
        n(this, R.string.Emoji_Shy, "Lark_Emoji_Shy_0", "SHY", "emoji_shy.png", R.drawable.emoji_shy, false, "害羞", null, 128);
        n(this, R.string.Emoji_Wink, "Lark_Emoji_Wink_0", "WINK", "emoji_wink.png", R.drawable.emoji_wink, false, "可爱", null, 128);
        n(this, R.string.Emoji_Dizzy, "Lark_Emoji_Dizzy_0", "DIZZY", "emoji_dizzy.png", R.drawable.emoji_dizzy, false, "晕", null, 128);
        n(this, R.string.Emoji_Toasted, "Lark_Emoji_Toasted_0", "TOASTED", "emoji_toasted.png", R.drawable.emoji_toasted, false, "衰", null, 128);
        n(this, R.string.Emoji_Silent, "Lark_Emoji_Silent_0", "SILENT", "emoji_silent.png", R.drawable.emoji_silent, false, "闭嘴", null, 128);
        n(this, R.string.Emoji_Smart, "Lark_Emoji_Smart_0", "SMART", "emoji_smart.png", R.drawable.emoji_smart, false, "机智", null, 128);
        n(this, R.string.Emoji_Attention, "Lark_Emoji_Attention_0", "ATTENTION", "emoji_attention.png", R.drawable.emoji_attention, true, "来看我", null, 128);
        n(this, R.string.Emoji_Witty, "Lark_Emoji_Witty_0", "WITTY", "emoji_witty.png", R.drawable.emoji_witty, false, "灵光一闪", null, 128);
        n(this, R.string.Emoji_Yeah, "Lark_Emoji_Yeah_0", "YEAH", "emoji_yeah.png", R.drawable.emoji_yeah, false, "耶", null, 128);
        n(this, R.string.Emoji_Facepalm, "Lark_Emoji_Facepalm_0", "FACEPALM", "emoji_facepalm.png", R.drawable.emoji_facepalm, false, "捂脸", null, 128);
        n(this, R.string.Emoji_Slap, "Lark_Emoji_Slap_0", "SLAP", "emoji_slap.png", R.drawable.emoji_slap, false, "打脸", null, 128);
        n(this, R.string.Emoji_Laugh, "Lark_Emoji_Laugh_0", "LAUGH", "emoji_laugh.png", R.drawable.emoji_laugh, false, "大笑", null, 128);
        n(this, R.string.Emoji_Yawn, "Lark_Emoji_Yawn_0", "YAWN", "emoji_yawn.png", R.drawable.emoji_yawn, false, "哈欠", null, 128);
        n(this, R.string.Emoji_Shocked, "Lark_Emoji_Shocked_0", "SHOCKED", "emoji_shocked.png", R.drawable.emoji_shocked, false, "震惊", null, 128);
        n(this, R.string.Emoji_Love, "Lark_Emoji_Love_0", "LOVE", "emoji_love.png", R.drawable.emoji_love, false, "送心", null, 128);
        n(this, R.string.Emoji_Drowsy, "Lark_Emoji_Drowsy_0", "DROWSY", "emoji_drowsy.png", R.drawable.emoji_drowsy, false, "困", null, 128);
        n(this, R.string.Emoji_What, "Lark_Emoji_What_0", "WHAT", "emoji_what.png", R.drawable.emoji_what, false, "what", null, 128);
        n(this, R.string.Emoji_Cry, "Lark_Emoji_Cry_0", "CRY", "emoji_cry.png", R.drawable.emoji_cry, false, "泣不成声", null, 128);
        n(this, R.string.Emoji_Clap, "Lark_Emoji_Clap_0", "CLAP", "emoji_clap.png", R.drawable.emoji_clap, false, "小鼓掌", null, 128);
        n(this, R.string.Emoji_ShowOff, "Lark_Emoji_ShowOff_0", "SHOWOFF", "emoji_showoff.png", R.drawable.emoji_showoff, false, "酷", null, 128);
        n(this, R.string.Emoji_Chuckle, "Lark_Emoji_Chuckle_0", "CHUCKLE", "emoji_chuckle.png", R.drawable.emoji_chuckle, false, "偷笑", null, 128);
        n(this, R.string.Emoji_Petrified, "Lark_Emoji_Petrified_0", "PETRIFIED", "emoji_petrified.png", R.drawable.emoji_petrified, false, "石化", null, 128);
        n(this, R.string.Emoji_Thinking, "Lark_Emoji_Thinking_0", "THINKING", "emoji_thinking.png", R.drawable.emoji_thinking, false, "思考", null, 128);
        n(this, R.string.Emoji_SpitBlood, "Lark_Emoji_SpitBlood_0", "SPITBLOOD", "emoji_spitblood.png", R.drawable.emoji_spitblood, false, "吐血", null, 128);
        n(this, R.string.Emoji_Whimper, "Lark_Emoji_Whimper_0", "WHIMPER", "emoji_whimper.png", R.drawable.emoji_whimper, false, "可怜", null, 128);
        n(this, R.string.Emoji_Shhh, "Lark_Emoji_Shhh_0", "SHHH", "emoji_shhh.png", R.drawable.emoji_shhh, false, "嘘", null, 128);
        n(this, R.string.Emoji_Smug, "Lark_Emoji_Smug_0", "SMUG", "emoji_smug.png", R.drawable.emoji_smug, false, "撇嘴", null, 128);
        n(this, R.string.Emoji_Errr, "Lark_Emoji_Errr_0", "ERROR", "emoji_errr.png", R.drawable.emoji_errr, false, "黑线", null, 128);
        n(this, R.string.Emoji_Lol, "Lark_Emoji_Lol_0", "LOL", "emoji_lol.png", R.drawable.emoji_lol, false, "笑哭", null, 128);
        n(this, R.string.Emoji_Sick, "Lark_Emoji_Sick_0", "SICK", "emoji_sick.png", R.drawable.emoji_sick, false, "雾霾", null, 128);
        n(this, R.string.Emoji_Smirk, "Lark_Emoji_Smirk_0", "SMIRK", "emoji_smirk.png", R.drawable.emoji_smirk, false, "奸笑", null, 128);
        n(this, R.string.Emoji_Proud, "Lark_Emoji_Proud_0", "PROUD", "emoji_proud.png", R.drawable.emoji_proud, false, "得意", null, 128);
        n(this, R.string.Emoji_Trick, "Lark_Emoji_Trick_0", "TRICK", "emoji_trick.png", R.drawable.emoji_trick, false, "憨笑", null, 128);
        n(this, R.string.Emoji_Crazy, "Lark_Emoji_Crazy_0", "CRAZY", "emoji_crazy.png", R.drawable.emoji_crazy, false, "抓狂", null, 128);
        n(this, R.string.Emoji_Tears, "Lark_Emoji_Tears_0", "TEARS", "emoji_tears.png", R.drawable.emoji_tears, false, "泪奔", null, 128);
        n(this, R.string.Emoji_Kiss, "Lark_Emoji_Kiss_0", "KISS", "emoji_kiss.png", R.drawable.emoji_kiss, false, "吻", null, 128);
        n(this, R.string.Emoji_Terror, "Lark_Emoji_Terror_0", "TERROR", "emoji_terror.png", R.drawable.emoji_terror, false, "恐惧", null, 128);
        n(this, R.string.Emoji_Joyful, "Lark_Emoji_Joyful_0", "JOYFUL", "emoji_joyful.png", R.drawable.emoji_joyful, false, "笑", null, 128);
        n(this, R.string.Emoji_Blubber, "Lark_Emoji_Blubber_0", "BLUBBER", "emoji_blubber.png", R.drawable.emoji_blubber, false, "快哭了", null, 128);
        n(this, R.string.Emoji_Husky, "Lark_Emoji_Husky_0", "HUSKY", "emoji_husky.png", R.drawable.emoji_husky, false, "翻白眼", null, 128);
        n(this, R.string.Emoji_FollowMe, "Lark_Emoji_FollowMe_0", "FOLLOWME", "emoji_followme.png", R.drawable.emoji_followme, true, "互粉", null, 128);
        n(this, R.string.Emoji_Thumbsup, "MediumLightThumbsup", "MediumLightThumbsup", "emoji_mediumlightthumbsup_v2.png", R.drawable.emoji_thumbsup_mediumlight, false, "", null, 128);
        n(this, R.string.Emoji_Thumbsup, "LightThumbsup", "LightThumbsup", "emoji_lightthumbsup_v2.png", R.drawable.emoji_thumbsup_light, false, "", null, 128);
        m(R.string.Emoji_Thumbsup, "Lark_Emoji_Thumbsup_0", "THUMBSUP", "emoji_thumbsup_v2.png", R.drawable.emoji_thumbsup, false, "赞", new String[]{"MediumLightThumbsup", "LightThumbsup", "THUMBSUP", "MediumThumbsup", "MediumDarkThumbsup", "DarkThumbsup"});
        n(this, R.string.Emoji_Thumbsup, "MediumThumbsup", "MediumThumbsup", "emoji_mediumthumbsup_v2.png", R.drawable.emoji_thumbsup_medium, false, "", null, 128);
        n(this, R.string.Emoji_Thumbsup, "MediumDarkThumbsup", "MediumDarkThumbsup", "emoji_mediumdarkthumbsup_v2.png", R.drawable.emoji_thumbsup_mediumdark, false, "", null, 128);
        n(this, R.string.Emoji_Thumbsup, "DarkThumbsup", "DarkThumbsup", "emoji_darkthumbsup_v2.png", R.drawable.emoji_thumbsup_dark, false, "", null, 128);
        n(this, R.string.Emoji_Applaud, "MediumLightApplaud", "MediumLightApplaud", "emoji_mediumlightapplaud_v2.png", R.drawable.emoji_applaud_mediumlight, false, "", null, 128);
        n(this, R.string.Emoji_Applaud, "LightApplaud", "LightApplaud", "emoji_lightapplaud_v2.png", R.drawable.emoji_applaud_light, false, "", null, 128);
        m(R.string.Emoji_Applaud, "Lark_Emoji_Applaud_0", "APPLAUSE", "emoji_applaud_v2.png", R.drawable.emoji_applaud, false, "鼓掌", new String[]{"MediumLightApplaud", "LightApplaud", "APPLAUSE", "MediumApplaud", "MediumDarkApplaud", "DarkApplaud"});
        n(this, R.string.Emoji_Applaud, "MediumApplaud", "MediumApplaud", "emoji_mediumapplaud_v2.png", R.drawable.emoji_applaud_medium, false, "", null, 128);
        n(this, R.string.Emoji_Applaud, "MediumDarkApplaud", "MediumDarkApplaud", "emoji_mediumdarkapplaud_v2.png", R.drawable.emoji_applaud_mediumdark, false, "", null, 128);
        n(this, R.string.Emoji_Applaud, "DarkApplaud", "DarkApplaud", "emoji_darkapplaud_v2.png", R.drawable.emoji_applaud_dark, false, "", null, 128);
        n(this, R.string.Emoji_Thanks, "MediumLightThanks", "MediumLightThanks", "emoji_mediumlightthanks_v2.png", R.drawable.emoji_thanks_mediumlight, false, "", null, 128);
        n(this, R.string.Emoji_Thanks, "LightThanks", "LightThanks", "emoji_lightthanks_v2.png", R.drawable.emoji_thanks_light, false, "", null, 128);
        m(R.string.Emoji_Thanks, "Lark_Emoji_Thanks_0", "THANKS", "emoji_thanks_v2.png", R.drawable.emoji_thanks, false, "谢谢", new String[]{"MediumLightThanks", "LightThanks", "THANKS", "MediumThanks", "MediumDarkThanks", "DarkThanks"});
        n(this, R.string.Emoji_Thanks, "MediumThanks", "MediumThanks", "emoji_mediumthanks_v2.png", R.drawable.emoji_thanks_medium, false, "", null, 128);
        n(this, R.string.Emoji_Thanks, "MediumDarkThanks", "MediumDarkThanks", "emoji_mediumdarkthanks_v2.png", R.drawable.emoji_thanks_mediumdark, false, "", null, 128);
        n(this, R.string.Emoji_Thanks, "DarkThanks", "DarkThanks", "emoji_darkthanks_v2.png", R.drawable.emoji_thanks_dark, false, "", null, 128);
        n(this, R.string.Emoji_Fighting, "MediumLightFightOn", "MediumLightFightOn", "emoji_mediumlightfighton_v2.png", R.drawable.emoji_fighton_mediumlight, false, "", null, 128);
        n(this, R.string.Emoji_Fighting, "LightFightOn", "LightFightOn", "emoji_lightfighton_v2.png", R.drawable.emoji_fighton_light, false, "", null, 128);
        m(R.string.Emoji_Fighting, "Lark_Emoji_Fighting_0", "MUSCLE", "emoji_fighton_v2.png", R.drawable.emoji_fighting, false, "加油", new String[]{"MediumLightFightOn", "LightFightOn", "MUSCLE", "MediumFightOn", "MediumDarkFightOn", "DarkFightOn"});
        n(this, R.string.Emoji_Fighting, "MediumFightOn", "MediumFightOn", "emoji_mediumfighton_v2.png", R.drawable.emoji_fighton_medium, false, "", null, 128);
        n(this, R.string.Emoji_Fighting, "MediumDarkFightOn", "MediumDarkFightOn", "emoji_mediumdarkfighton_v2.png", R.drawable.emoji_fighton_mediumdark, false, "", null, 128);
        n(this, R.string.Emoji_Fighting, "DarkFightOn", "DarkFightOn", "emoji_darkfighton_v2.png", R.drawable.emoji_fighton_dark, false, "", null, 128);
        n(this, R.string.Emoji_Heart, "Lark_Emoji_Heart_0", "HEART", "emoji_heart.png", R.drawable.emoji_heart, false, "爱心", null, 128);
        n(this, R.string.Emoji_Lips_new, "Lark_Emoji_Lips_0", "LIPS", "emoji_lips_v1.png", R.drawable.emoji_lips_v1, false, "kiss", null, 128);
        n(this, R.string.Emoji_Detergent, "Lark_Emoji_Detergent_0", "DETERGENT", "emoji_detergent.png", R.drawable.emoji_detergent, true, "去污粉", null, 128);
        n(this, R.string.Emoji_Awesome, "Lark_Emoji_Awesome_0", "AWESOME", "emoji_awesome.png", R.drawable.emoji_awesome, true, "666", null, 128);
        n(this, R.string.Emoji_Rose, "Lark_Emoji_Rose_0", "ROSE", "emoji_rose.png", R.drawable.emoji_rose, false, "玫瑰", null, 128);
        n(this, R.string.Emoji_Cucumber, "Lark_Emoji_Cucumber_0", "CUCUMBER", "emoji_cucumber_v3.png", R.drawable.emoji_cucumber, false, "胡瓜", null, 128);
        n(this, R.string.Emoji_Beer, "Lark_Emoji_Beer_0", "BEER", "emoji_beer.png", R.drawable.emoji_beer, false, "啤酒", null, 128);
        n(this, R.string.Emoji_Enough, "Lark_Emoji_Enough_0", "ENOUGH", "emoji_enough.png", R.drawable.emoji_enough, false, "我想静静", null, 128);
        n(this, R.string.Emoji_Wronged, "Lark_Emoji_Wronged_0", "WRONGED", "emoji_wronged.png", R.drawable.emoji_wronged, false, "委屈", null, 128);
        n(this, R.string.Emoji_Hearts, "Lark_Emoji_Obsessed_0", "OBSESSED", "emoji_hearts_v2.png", R.drawable.emoji_hearts_v2, false, "舔屏", null, 128);
        n(this, R.string.Emoji_LookDown, "Lark_Emoji_LookDown_0", "LOOKDOWN", "emoji_lookdown.png", R.drawable.emoji_lookdown, false, "鄙视", null, 128);
        n(this, R.string.Emoji_Smooch, "Lark_Emoji_Smooch_0", "SMOOCH", "emoji_smooch.png", R.drawable.emoji_smooch, false, "飞吻", null, 128);
        n(this, R.string.Emoji_Wave, "Lark_Emoji_Wave_0", "WAVE", "emoji_wave.png", R.drawable.emoji_wave, false, "再见", null, 128);
        n(this, R.string.Emoji_DonnotGo, "Lark_Emoji_DonnotGo_0", "DONNOTGO", "emoji_donnotgo.png", R.drawable.emoji_donnotgo, false, "紫薇别走", null, 128);
        n(this, R.string.Emoji_Headset, "Lark_Emoji_Headset_0", "HEADSET", "emoji_headset_v3.png", R.drawable.emoji_headset, false, "听歌", null, 128);
        n(this, R.string.Emoji_Hug, "Lark_Emoji_Hug_0", "HUG", "emoji_hug.png", R.drawable.emoji_hug, false, "求抱抱", null, 128);
        n(this, R.string.Emoji_DullStare, "Lark_Emoji_DullStare_0", "DULLSTARE", "emoji_dullstare.png", R.drawable.emoji_dullstare, false, "周冬雨的凝视", null, 128);
        n(this, R.string.Emoji_InnocentSmile, "Lark_Emoji_InnocentSmile_0", "INNOCENTSMILE", "emoji_innocentsmile.png", R.drawable.emoji_innocentsmile, false, "马思纯的微笑", null, 128);
        n(this, R.string.Emoji_Tongue, "Lark_Emoji_Tongue_0", "TONGUE", "emoji_tongue.png", R.drawable.emoji_tongue, false, "吐舌", null, 128);
        n(this, R.string.Emoji_Dull, "Lark_Emoji_Dull_0", "DULL", "emoji_dull.png", R.drawable.emoji_dull, false, "呆无辜", null, 128);
        n(this, R.string.Emoji_Glance, "Lark_Emoji_Glance_0", "GLANCE", "emoji_glance.png", R.drawable.emoji_glance, false, "看", null, 128);
        n(this, R.string.Emoji_Slight, "Lark_Emoji_Slight_0", "SLIGHT", "emoji_slight.png", R.drawable.emoji_slight, false, "白眼", null, 128);
        n(this, R.string.Emoji_Bear, "Lark_Emoji_Bear_0", "BEAR", "emoji_bear.png", R.drawable.emoji_bear, false, "熊吉", null, 128);
        n(this, R.string.Emoji_Skull, "Lark_Emoji_Skull_0", "SKULL", "emoji_skull.png", R.drawable.emoji_skull, false, "骷髅", null, 128);
        n(this, R.string.Emoji_BlackFace, "Lark_Emoji_BlackFace_0", "BLACKFACE", "emoji_blackface.png", R.drawable.emoji_blackface, false, "黑脸", null, 128);
        n(this, R.string.Emoji_Eating, "Lark_Emoji_Eating_0", "EATING", "emoji_eating.png", R.drawable.emoji_eating, false, "吃瓜群众", null, 128);
        n(this, R.string.Emoji_Sweat, "Lark_Emoji_Sweat_0", "SWEAT", "emoji_sweat.png", R.drawable.emoji_sweat, false, "汗", null, 128);
        n(this, R.string.Emoji_Comfort, "Lark_Emoji_Comfort_0", "COMFORT", "emoji_comfort.png", R.drawable.emoji_comfort, false, "摸头", null, 128);
        n(this, R.string.Emoji_Frown, "Lark_Emoji_Frown_0", "FROWN", "emoji_frown.png", R.drawable.emoji_frown, false, "皱眉", null, 128);
        n(this, R.string.Emoji_Speechless, "Lark_Emoji_Speechless_0", "SPEECHLESS", "emoji_speechless.png", R.drawable.emoji_speechless, false, "擦汗", null, 128);
        n(this, R.string.Emoji_Blush, "Lark_Emoji_Blush_0", "XBLUSH", "emoji_blush.png", R.drawable.emoji_blush, false, "红脸", null, 128);
        n(this, R.string.Emoji_Embarrassed, "Lark_Emoji_Embarrassed_0", "EMBARRASSED", "emoji_embarrassed.png", R.drawable.emoji_embarrassed, false, "尬笑", null, 128);
        n(this, R.string.Emoji_Tease, "Lark_Emoji_Tease_0", "TEASE", "emoji_tease.png", R.drawable.emoji_tease, false, "做鬼脸", null, 128);
        n(this, R.string.Emoji_Praise, "Lark_Emoji_Praise_0", "PRAISE", "emoji_praise.png", R.drawable.emoji_praise, false, "强", null, 128);
        n(this, R.string.Emoji_BigKiss, "Lark_Emoji_BigKiss_0", "BIGKISS", "emoji_bigkiss.png", R.drawable.emoji_bigkiss, false, "如花", null, 128);
        n(this, R.string.Emoji_Puke, "Lark_Emoji_Puke_0", "PUKE", "emoji_puke.png", R.drawable.emoji_puke, false, "吐", null, 128);
        n(this, R.string.Emoji_Wow, "Lark_Emoji_Wow_0", "WOW", "emoji_wow.png", R.drawable.emoji_wow, false, "惊喜", null, 128);
        n(this, R.string.Emoji_Hammer, "Lark_Emoji_Hammer_0", "HAMMER", "emoji_hammer_v1.png", R.drawable.emoji_hammer_v1, false, "敲打", null, 128);
        n(this, R.string.Emoji_Strive, "Lark_Emoji_Strive_0", "STRIVE", "emoji_strive.png", R.drawable.emoji_strive, false, "奋斗", null, 128);
        n(this, R.string.Emoji_RainbowPuke, "Lark_Emoji_RainbowPuke_0", "RAINBOWPUKE", "emoji_rainbowpuke_v2.png", R.drawable.emoji_rainbowpuke, false, "吐彩虹", null, 128);
        n(this, R.string.Emoji_Wail, "Lark_Emoji_Wail_0", "WAIL", "emoji_wail.png", R.drawable.emoji_wail, false, "大哭", null, 128);
        n(this, R.string.Emoji_FingerHeart, "MediumLightFingerHeart", "MediumLightFingerHeart", "emoji_mediumlightfingerheart_v2.png", R.drawable.emoji_fingerheart_mediumlight, false, "", null, 128);
        n(this, R.string.Emoji_FingerHeart, "LightFingerHeart", "LightFingerHeart", "emoji_lightfingerheart_v2.png", R.drawable.emoji_fingerheart_light, false, "", null, 128);
        m(R.string.Emoji_FingerHeart, "Lark_Emoji_FingerHeart_0", "FINGERHEART", "emoji_fingerheart_v2.png", R.drawable.emoji_fingerheart, false, "比心", new String[]{"MediumLightFingerHeart", "LightFingerHeart", "FINGERHEART", "MediumFingerHeart", "MediumDarkFingerHeart", "DarkFingerHeart"});
        n(this, R.string.Emoji_FingerHeart, "MediumFingerHeart", "MediumFingerHeart", "emoji_mediumfingerheart_v2.png", R.drawable.emoji_fingerheart_medium, false, "", null, 128);
        n(this, R.string.Emoji_FingerHeart, "MediumDarkFingerHeart", "MediumDarkFingerHeart", "emoji_mediumdarkfingerheart_v2.png", R.drawable.emoji_fingerheart_mediumdark, false, "", null, 128);
        n(this, R.string.Emoji_FingerHeart, "DarkFingerHeart", "DarkFingerHeart", "emoji_darkfingerheart_v2.png", R.drawable.emoji_fingerheart_dark, false, "", null, 128);
        n(this, R.string.Emoji_FistBump, "MediumLightFistBump", "MediumLightFistBump", "emoji_mediumlightfistbump_v2.png", R.drawable.emoji_fistbump_mediumlight, false, "", null, 128);
        n(this, R.string.Emoji_FistBump, "LightFistBump", "LightFistBump", "emoji_lightfistbump_v2.png", R.drawable.emoji_fistbump_light, false, "", null, 128);
        m(R.string.Emoji_FistBump, "Lark_Emoji_FistBump_0", "FISTBUMP", "emoji_fistbump_v2.png", R.drawable.emoji_fistbump, false, "碰拳", new String[]{"MediumLightFistBump", "LightFistBump", "FISTBUMP", "MediumFistBump", "MediumDarkFistBump", "DarkFistBump"});
        n(this, R.string.Emoji_FistBump, "MediumFistBump", "MediumFistBump", "emoji_mediumfistbump_v2.png", R.drawable.emoji_fistbump_medium, false, "", null, 128);
        n(this, R.string.Emoji_FistBump, "MediumDarkFistBump", "MediumDarkFistBump", "emoji_mediumdarkfistbump_v2.png", R.drawable.emoji_fistbump_mediumdark, false, "", null, 128);
        n(this, R.string.Emoji_FistBump, "DarkFistBump", "DarkFistBump", "emoji_darkfistbump_v2.png", R.drawable.emoji_fistbump_dark, false, "", null, 128);
        n(this, R.string.Emoji_HighFive, "MediumLightHighFive", "MediumLightHighFive", "emoji_mediumlighthighfive_v2.png", R.drawable.emoji_highfive_mediumlight, false, "", null, 128);
        n(this, R.string.Emoji_HighFive, "LightHighFive", "LightHighFive", "emoji_lighthighfive_v2.png", R.drawable.emoji_highfive_light, false, "", null, 128);
        m(R.string.Emoji_HighFive, "Lark_Emoji_HighFive_0", "HIGHFIVE", "emoji_highfive_v2.png", R.drawable.emoji_highfive, false, "击掌", new String[]{"MediumLightHighFive", "LightHighFive", "HIGHFIVE", "MediumHighFive", "MediumDarkHighFive", "DarkHighFive"});
        n(this, R.string.Emoji_HighFive, "MediumHighFive", "MediumHighFive", "emoji_mediumhighfive_v2.png", R.drawable.emoji_highfive_medium, false, "", null, 128);
        n(this, R.string.Emoji_HighFive, "MediumDarkHighFive", "MediumDarkHighFive", "emoji_mediumdarkhighfive_v2.png", R.drawable.emoji_highfive_mediumdark, false, "", null, 128);
        n(this, R.string.Emoji_HighFive, "DarkHighFive", "DarkHighFive", "emoji_darkhighfive_v2.png", R.drawable.emoji_highfive_dark, false, "", null, 128);
        n(this, R.string.Emoji_UpperLeft, "MediumLightClick", "MediumLightClick", "emoji_mediumlightclick_v2.png", R.drawable.emoji_click_mediumlight, false, "", null, 128);
        n(this, R.string.Emoji_UpperLeft, "LightClick", "LightClick", "emoji_lightclick_v2.png", R.drawable.emoji_click_light, false, "", null, 128);
        m(R.string.Emoji_UpperLeft, "Lark_Emoji_UpperLeft_0", "UPPERLEFT", "emoji_click_v2.png", R.drawable.emoji_click_v2, false, "左上", new String[]{"MediumLightClick", "LightClick", "UPPERLEFT", "MediumClick", "MediumDarkClick", "DarkClick"});
        n(this, R.string.Emoji_UpperLeft, "MediumClick", "MediumClick", "emoji_mediumclick_v2.png", R.drawable.emoji_click_medium, false, "", null, 128);
        n(this, R.string.Emoji_UpperLeft, "MediumDarkClick", "MediumDarkClick", "emoji_mediumdarkclick_v2.png", R.drawable.emoji_click_mediumdark, false, "", null, 128);
        n(this, R.string.Emoji_UpperLeft, "DarkClick", "DarkClick", "emoji_darkclick_v2.png", R.drawable.emoji_click_dark, false, "", null, 128);
        n(this, R.string.Emoji_Shake, "MediumLightShake", "MediumLightShake", "emoji_mediumlightshake_v2.png", R.drawable.emoji_shake_mediumlight, false, "", null, 128);
        n(this, R.string.Emoji_Shake, "LightShake", "LightShake", "emoji_lightshake_v2.png", R.drawable.emoji_shake_light, false, "", null, 128);
        m(R.string.Emoji_Shake, "Lark_Emoji_Shake_0", "SHAKE", "emoji_shake_v2.png", R.drawable.emoji_shake, false, "握手", new String[]{"MediumLightShake", "LightShake", "SHAKE", "MediumShake", "MediumDarkShake", "DarkShake"});
        n(this, R.string.Emoji_Shake, "MediumShake", "MediumShake", "emoji_mediumshake_v2.png", R.drawable.emoji_shake_medium, false, "", null, 128);
        n(this, R.string.Emoji_Shake, "MediumDarkShake", "MediumDarkShake", "emoji_mediumdarkshake_v2.png", R.drawable.emoji_shake_mediumdark, false, "", null, 128);
        n(this, R.string.Emoji_Shake, "DarkShake", "DarkShake", "emoji_darkshake_v2.png", R.drawable.emoji_shake_dark, false, "", null, 128);
        n(this, R.string.Emoji_Salute, "MediumLightSalute", "MediumLightSalute", "emoji_mediumlightsalute_v2.png", R.drawable.emoji_salute_mediumlight, false, "", null, 128);
        n(this, R.string.Emoji_Salute, "LightSalute", "LightSalute", "emoji_lightsalute_v2.png", R.drawable.emoji_salute_light, false, "", null, 128);
        m(R.string.Emoji_Salute, "Salute", "SALUTE", "emoji_salute_v2.png", R.drawable.emoji_salute, false, "抱拳", new String[]{"MediumLightSalute", "LightSalute", "SALUTE", "MediumSalute", "MediumDarkSalute", "DarkSalute"});
        n(this, R.string.Emoji_Salute, "MediumSalute", "MediumSalute", "emoji_mediumsalute_v2.png", R.drawable.emoji_salute_medium, false, "", null, 128);
        n(this, R.string.Emoji_Salute, "MediumDarkSalute", "MediumDarkSalute", "emoji_mediumdarksalute_v2.png", R.drawable.emoji_salute_mediumdark, false, "", null, 128);
        n(this, R.string.Emoji_Salute, "DarkSalute", "DarkSalute", "emoji_darksalute_v2.png", R.drawable.emoji_salute_dark, false, "", null, 128);
        n(this, R.string.Emoji_Done, "Done", "DONE", "emoji_done.png", R.drawable.emoji_done, false, "完成", null, 128);
        n(this, R.string.Emoji_Eighteen, "Lark_Emoji_18x_0", "18X", "emoji_eighteen.png", R.drawable.emoji_eighteen, false, "18禁", null, 128);
        n(this, R.string.Emoji_Cleaver, "Lark_Emoji_Cleaver_0", "CLEAVER", "emoji_cleaver_v3.png", R.drawable.emoji_cleaver_v3, false, "刀", null, 128);
        n(this, R.string.Emoji_PlusOne, "+1", "JIAYI", "emoji_plusone.png", R.drawable.emoji_plusone, false, "+1", null, 128);
        n(this, R.string.Emoji_WellDone, "Lark_Emoji_WellDone_0", "WELLDONE", "emoji_welldone.png", R.drawable.emoji_welldone, true, "V5", null, 128);
        n(this, R.string.Emoji_GoodJob, "Lark_Emoji_GoodJob_0", "GOODJOB", "emoji_goodjob.png", R.drawable.emoji_goodjob, true, "给力", null, 128);
        n(this, R.string.Emoji_HeartBroken, "Lark_Emoji_HeartBroken_0", "HEARTBROKEN", "emoji_heartbroken.png", R.drawable.emoji_heartbroken, false, "伤心", null, 128);
        n(this, R.string.Emoji_Poop, "Lark_Emoji_Poop_0", "POOP", "emoji_poop.png", R.drawable.emoji_poop, false, "屎", null, 128);
        n(this, R.string.Emoji_Gift, "Lark_Emoji_Gift_0", "GIFT", "emoji_gift_v3.png", R.drawable.emoji_gift, false, "礼物", null, 128);
        n(this, R.string.Emoji_Cake, "Lark_Emoji_Cake_0", "CAKE", "emoji_cake_v2.png", R.drawable.emoji_cake, false, "蛋糕", null, 128);
        n(this, R.string.Emoji_Party, "Lark_Emoji_Party_0", "PARTY", "emoji_party.png", R.drawable.emoji_party, false, "撒花", null, 128);
        n(this, R.string.Emoji_EyesClosed, "Lark_Emoji_EyesClosed_0", "EYESCLOSED", "emoji_eyesclosed.png", R.drawable.emoji_eyesclosed, false, "不看", null, 128);
        n(this, R.string.Emoji_Bomb, "Lark_Emoji_Bomb_0", "BOMB", "emoji_bomb.png", R.drawable.emoji_bomb, false, "炸弹", null, 128);
        n(this, R.string.Emoji_Fireworks, "Fireworks", "FIREWORKS", "emoji_fireworks_v2.png", R.drawable.emoji_fireworks, false, "", null, 128);
        n(this, R.string.Emoji_Bull, "Bull", "BULL", "emoji_bull.png", R.drawable.emoji_bull, false, "", null, 128);
        n(this, R.string.Emoji_Calf, "Calf", "CALF", "emoji_calf.png", R.drawable.emoji_calf, false, "", null, 128);
        n(this, R.string.Emoji_Candiedhaws, "Candiedhaws", "CANDIEDHAWS", "emoji_candiedhaws.png", R.drawable.emoji_candiedhaws, false, "", null, 128);
        n(this, R.string.Emoji_Redpacket, "Redpacket", "REDPACKET", "emoji_redpacket_v2.png", R.drawable.emoji_redpacket, false, "", null, 128);
        n(this, R.string.Emoji_Luck, "Luck", "LUCK", "emoji_luck.png", R.drawable.emoji_luck, false, "", null, 128);
        n(this, R.string.Emoji_Firecracker, "Firecracker", "FIRECRACKER", "emoji_firecracker_v3.png", R.drawable.emoji_firecracker, false, "", null, 128);
        n(this, R.string.Emoji_EatingFood, "EatingFood", "EatingFood", "emoji_eatingfood_v2.png", R.drawable.emoji_eatingfood, false, null, null, 128);
        n(this, R.string.Emoji_Typing, "Typing", "Typing", "emoji_typing.png", R.drawable.emoji_typing, false, null, null, 128);
        n(this, R.string.Emoji_Lemon, "Lemon", "Lemon", "emoji_lemon_v2.png", R.drawable.emoji_lemon, false, null, null, 128);
        n(this, R.string.Emoji_LGTM, "LGTM", "LGTM", "emoji_lgtm_v3.png", R.drawable.emoji_lgtm, false, null, null, 128);
        n(this, R.string.Emoji_ThumbsDown, "MediumLightThumbsDown", "MediumLightThumbsDown", "emoji_mediumlightthumbsdown_v2.png", R.drawable.emoji_thumbsdown_mediumlight, false, null, null, 128);
        n(this, R.string.Emoji_ThumbsDown, "LightThumbsDown", "LightThumbsDown", "emoji_lightthumbsdown_v2.png", R.drawable.emoji_thumbsdown_light, false, null, null, 128);
        m(R.string.Emoji_ThumbsDown, "ThumbsDown", "ThumbsDown", "emoji_thumbsdown_v2.png", R.drawable.emoji_thumbsdown, false, null, new String[]{"MediumLightThumbsDown", "LightThumbsDown", "ThumbsDown", "MediumThumbsDown", "MediumDarkThumbsDown", "DarkThumbsDown"});
        n(this, R.string.Emoji_ThumbsDown, "MediumThumbsDown", "MediumThumbsDown", "emoji_mediumthumbsdown_v2.png", R.drawable.emoji_thumbsdown_medium, false, null, null, 128);
        n(this, R.string.Emoji_ThumbsDown, "MediumDarkThumbsDown", "MediumDarkThumbsDown", "emoji_mediumdarkthumbsdown_v2.png", R.drawable.emoji_thumbsdown_mediumdark, false, null, null, 128);
        n(this, R.string.Emoji_ThumbsDown, "DarkThumbsDown", "DarkThumbsDown", "emoji_darkthumbsdown_v2.png", R.drawable.emoji_thumbsdown_dark, false, null, null, 128);
        n(this, R.string.Emoji_Drumstick, "Drumstick", "Drumstick", "emoji_drumstick.png", R.drawable.emoji_drumstick, false, null, null, 128);
        n(this, R.string.Emoji_Pepper, "Pepper", "Pepper", "emoji_pepper.png", R.drawable.emoji_pepper, false, null, null, 128);
        n(this, R.string.Emoji_BubbleTea, "BubbleTea", "BubbleTea", "emoji_bubbletea.png", R.drawable.emoji_bubbletea, false, null, null, 128);
        n(this, R.string.Emoji_Coffee, "Coffee", "Coffee", "emoji_coffee_v2.png", R.drawable.emoji_coffee, false, null, null, 128);
        n(this, R.string.Emoji_Yes, "Yes", "Yes", "emoji_yes_v2.png", R.drawable.emoji_yes, false, null, null, 128);
        n(this, R.string.Emoji_No, "No", "No", "emoji_no_v3.png", R.drawable.emoji_no_v3, false, null, null, 128);
        n(this, R.string.Emoji_OKR, "OKR", "OKR", "emoji_okr.png", R.drawable.emoji_okr, false, null, null, 128);
        n(this, R.string.Emoji_CheckMark, "CheckMark", "CheckMark", "emoji_checkmark.png", R.drawable.emoji_checkmark, false, null, null, 128);
        n(this, R.string.Emoji_CrossMark, "CrossMark", "CrossMark", "emoji_crossmark.png", R.drawable.emoji_crossmark, false, null, null, 128);
        n(this, R.string.Emoji_MinusOne, "MinusOne", "MinusOne", "emoji_minusone_v4.png", R.drawable.emoji_minusone, false, null, null, 128);
        n(this, R.string.Emoji_Hundred, "Hundred", "Hundred", "emoji_hundred.png", R.drawable.emoji_hundred, false, null, null, 128);
        n(this, R.string.Emoji_Pin, WikiFolderPushPlugin.PIN, WikiFolderPushPlugin.PIN, "emoji_pin.png", R.drawable.emoji_pin, false, null, null, 128);
        n(this, R.string.Emoji_Alarm, "Alarm", "Alarm", "emoji_alarm.png", R.drawable.emoji_alarm, false, null, null, 128);
        n(this, R.string.Emoji_Loudspeaker, "Loudspeaker", "Loudspeaker", "emoji_loudspeaker.png", R.drawable.emoji_loudspeaker, false, null, null, 128);
        n(this, R.string.Emoji_Trophy, "Trophy", "Trophy", "emoji_trophy.png", R.drawable.emoji_trophy, false, null, null, 128);
        n(this, R.string.Emoji_Fire, "Fire", "Fire", "emoji_fire.png", R.drawable.emoji_fire, false, null, null, 128);
        n(this, R.string.Emoji_Music, "Music", "Music", "emoji_music_v2.png", R.drawable.emoji_music, false, null, null, 128);
        n(this, R.string.Emoji_Basketball, "Basketball", "Basketball", "emoji_basketball_v3.png", R.drawable.emoji_basketball, false, null, null, 128);
        n(this, R.string.Emoji_Soccer, "Soccer", "Soccer", "emoji_soccer_v3.png", R.drawable.emoji_soccer, false, null, null, 128);
        n(this, R.string.Emoji_GeneralBusinessTrip, "GeneralBusinessTrip", "GeneralBusinessTrip", "emoji_generalbusinesstrip_v2.png", R.drawable.emoji_generalbusinesstrip, false, null, null, 128);
        n(this, R.string.Emoji_GeneralDoNotDisturb, "GeneralDoNotDisturb", "GeneralDoNotDisturb", "emoji_generaldonotdisturb_v3.png", R.drawable.emoji_generaldonotdisturb_v3, false, null, null, 128);
        n(this, R.string.Emoji_GeneralInMeetingBusy, "GeneralInMeetingBusy", "GeneralInMeetingBusy", "emoji_generalInmeetingbusy_v2.png", R.drawable.emoji_generalinmeetingbusy, false, null, null, 128);
        n(this, R.string.Emoji_GeneralMoonRest, "GeneralMoonRest", "GeneralMoonRest", "emoji_generalmoonrest_v2.png", R.drawable.emoji_generalmoonrest, false, null, null, 128);
        n(this, R.string.Emoji_GeneralSun, "GeneralSun", "GeneralSun", "emoji_generalsun.png", R.drawable.emoji_generalsun, false, null, null, 128);
        n(this, R.string.Emoji_GeneralTravellingCar, "GeneralTravellingCar", "GeneralTravellingCar", "emoji_generaltravellingcar.png", R.drawable.emoji_generaltravellingcar, false, null, null, 128);
        n(this, R.string.Emoji_GeneralWorkFromHome, "GeneralWorkFromHome", "GeneralWorkFromHome", "emoji_generalworkfromhome.png", R.drawable.emoji_generalworkfromhome, false, null, null, 128);
        n(this, R.string.Emoji_Status_PrivateMessage, "Status_PrivateMessage", "Status_PrivateMessage", "emoji_status_privatemessage.png", R.drawable.emoji_status_privatemessage, false, null, null, 128);
        n(this, R.string.Emoji_StatusBus, "StatusBus", "StatusBus", "emoji_statusbus.png", R.drawable.emoji_statusbus, false, null, null, 128);
        n(this, R.string.Emoji_StatusEnjoyLife, "StatusEnjoyLife", "StatusEnjoyLife", "emoji_statusenjoylife.png", R.drawable.emoji_statusenjoylife, false, null, null, 128);
        n(this, R.string.Emoji_StatusFlashOfInspiration, "StatusFlashOfInspiration", "StatusFlashOfInspiration", "emoji_statusflashofinspiration.png", R.drawable.emoji_statusflashofinspiration, false, null, null, 128);
        n(this, R.string.Emoji_StatusInFlight, "StatusInFlight", "StatusInFlight", "emoji_statusinflight.png", R.drawable.emoji_statusinflight, false, null, null, 128);
        n(this, R.string.Emoji_StatusReading, "StatusReading", "StatusReading", "emoji_statusreading.png", R.drawable.emoji_statusreading, false, null, null, 128);
        n(this, R.string.Emoji_BePatientAndThinkLongTerm, "Ambitious", "Ambitious", UIHelper.getString(R.string.Image_key_Ambitious), R.drawable.emoji_bepatientandthinklongterm, false, null, null, 128);
        n(this, R.string.Emoji_BePatientAndThinkLongTerm, "Patient", "Patient", UIHelper.getString(R.string.Image_key_Ambitious), R.drawable.emoji_bepatientandthinklongterm, false, null, null, 128);
        n(this, R.string.Emoji_CustomerSuccess, "CustomerSuccess", "CustomerSuccess", UIHelper.getString(R.string.Image_key_CustomerSuccess), R.drawable.emoji_customersuccess, false, null, null, 128);
        n(this, R.string.Emoji_PursueUltimate, "PursueUltimate", "PursueUltimate", UIHelper.getString(R.string.Image_key_PursueUltimate), R.drawable.emoji_pursueultimate, false, null, null, 128);
        n(this, R.string.Emoji_BeReliableAndTakeOwnership, "Responsible", "Responsible", UIHelper.getString(R.string.Image_key_Responsible), R.drawable.emoji_bereliableandtakeownership, false, null, null, 128);
        n(this, R.string.Emoji_BeReliableAndTakeOwnership, "Reliable", "Reliable", UIHelper.getString(R.string.Image_key_Responsible), R.drawable.emoji_bereliableandtakeownership, false, null, null, 128);
        n(this, R.string.Emoji_Snowman, "Snowman", "Snowman", "emoji_snowman.png", R.drawable.emoji_snowman, false, null, null, 128);
        n(this, R.string.Emoji_XmasHat, "XmasHat", "XmasHat", "emoji_xmashat.png", R.drawable.emoji_xmashat, false, null, null, 128);
        n(this, R.string.Emoji_XmasTree, "XmasTree", "XmasTree", "emoji_xmastree.png", R.drawable.emoji_xmastree, false, null, null, 128);
        n(this, R.string.Emoji_OneSecond, "OneSecond", "OneSecond", "emoji_onesecond.png", R.drawable.emoji_onesecond, false, null, null, 128);
        n(this, R.string.Emoji_Sigh, "Sigh", "Sigh", "emoji_sigh.png", R.drawable.emoji_sigh, false, null, null, 128);
        n(this, R.string.Emoji_OnIt, "OnIt", "OnIt", "emoji_onit_v1.png", R.drawable.emoji_onit_v1, false, null, null, 128);
        n(this, R.string.Emoji_2022, "2022", "2022", "emoji_twentytwentytwo.png", R.drawable.emoji_twentytwentytwo, false, null, null, 128);
        n(this, R.string.Emoji_RoarForYou, "RoarForYou", "RoarForYou", "emoji_roarforyou.png", R.drawable.emoji_roarforyou, false, null, null, 192);
        n(this, R.string.Emoji_StickyRiceBalls, "StickyRiceBalls", "StickyRiceBalls", "emoji_stickyriceballs.png", R.drawable.emoji_stickyriceballs, false, null, null, 192);
        n(this, R.string.Emoji_MeMeMe, "MeMeMe", "MeMeMe", "emoji_mememe.png", R.drawable.emoji_mememe, false, null, null, 192);
        n(this, R.string.Emoji_OkHand, "MediumlightOKHand", "MediumlightOKHand", "emoji_mediumlightokhand.png", R.drawable.emoji_mediumlightokhand, false, null, null, 192);
        n(this, R.string.Emoji_OkHand, "LightOKHand", "LightOKHand", "emoji_lightokhand.png", R.drawable.emoji_lightokhand, false, null, null, 192);
        n(this, R.string.Emoji_OkHand, "OKHand", "OKHand", "emoji_okhand.png", R.drawable.emoji_okhand, false, null, new String[]{"MediumlightOKHand", "LightOKHand", "OKHand", "MediumOKHand", "MediumdarkOKHand", "DarkOKHand"}, 64);
        n(this, R.string.Emoji_OkHand, "MediumOKHand", "MediumOKHand", "emoji_mediumokhand.png", R.drawable.emoji_mediumokhand, false, null, null, 192);
        n(this, R.string.Emoji_OkHand, "MediumdarkOKHand", "MediumdarkOKHand", "emoji_mediumdarkokhand.png", R.drawable.emoji_mediumdarkokhand, false, null, null, 192);
        n(this, R.string.Emoji_OkHand, "DarkOKHand", "DarkOKHand", "emoji_darkokhand.png", R.drawable.emoji_darkokhand, false, null, null, 192);
        n(this, R.string.Emoji_YouAreTheBest, "YouAreTheBest", "YouAreTheBest", "emoji_youarethebest.png", R.drawable.emoji_youarethebest, false, null, new String[]{"MediumlightYouAreTheBest", "LightYouAreTheBest", "YouAreTheBest", "MediumYouAreTheBest", "MediumdarkYouAreTheBest", "DarkYouAreTheBest"}, 64);
        n(this, R.string.Emoji_YouAreTheBest, "MediumlightYouAreTheBest", "MediumlightYouAreTheBest", "emoji_mediumlightyouarethebest_v1.png", R.drawable.emoji_mediumlightyouarethebest_v1, false, null, null, 192);
        n(this, R.string.Emoji_YouAreTheBest, "LightYouAreTheBest", "LightYouAreTheBest", "emoji_lightyouarethebest_v1.png", R.drawable.emoji_lightyouarethebest_v1, false, null, null, 192);
        n(this, R.string.Emoji_YouAreTheBest, "MediumYouAreTheBest", "MediumYouAreTheBest", "emoji_mediumyouarethebest_v1.png", R.drawable.emoji_mediumyouarethebest_v1, false, null, null, 192);
        n(this, R.string.Emoji_YouAreTheBest, "MediumdarkYouAreTheBest", "MediumdarkYouAreTheBest", "emoji_mediumdarkyouarethebest_v1.png", R.drawable.emoji_mediumdarkyouarethebest_v1, false, null, null, 192);
        n(this, R.string.Emoji_YouAreTheBest, "DarkYouAreTheBest", "DarkYouAreTheBest", "emoji_darkyouarethebest_v1.png", R.drawable.emoji_darkyouarethebest_v1, false, null, null, 192);
        n(this, R.string.Emoji_GeneralVacation, "GeneralVacation", "GeneralVacation", "emoji_onleavestatus.png", R.drawable.emoji_onleavestatus, false, null, null, 192);
        n(this, R.string.Emoji_Mooncake, "Mooncake", "Mooncake", "emoji_mooncake_v2.png", R.drawable.emoji_mooncake_v2, false, null, null, 192);
        n(this, R.string.Emoji_MoonRabbit, "MoonRabbit", "MoonRabbit", "emoji_moonrabbit_v2.png", R.drawable.emoji_moonrabbit_v2, false, null, null, 192);
        n(this, R.string.Emoji_Partying, "Partying", "Partying", "emoji_partying_v1.png", R.drawable.emoji_partying_v1, false, null, null, 192);
        n(this, R.string.Emoji_GoGoGo, "GoGoGo", "GoGoGo", "emoji_gogogo_v4.png", R.drawable.emoji_gogogo_v4, false, null, null, 192);
        n(this, R.string.Emoji_TV, "TV", "TV", "emoji_tv_v1.png", R.drawable.emoji_tv_v1, false, null, null, 192);
        n(this, R.string.Emoji_Movie, "Movie", "Movie", "emoji_movie_v1.png", R.drawable.emoji_movie_v1, false, null, null, 192);
        n(this, R.string.Emoji_Pumpkin, "Pumpkin", "Pumpkin", "emoji_pumpkin_v1.png", R.drawable.emoji_pumpkin_v1, false, null, null, 192);
        n(this, R.string.Emoji_2023, "2023", "2023", "emoji_2023_v4.png", R.drawable.emoji_2023_v4, false, null, null, 192);
        n(this, R.string.Emoji_JubilantRabbit, "JubilantRabbit", "JubilantRabbit", "emoji_jubilantrabbit_v1.png", R.drawable.emoji_jubilantrabbit_v1, false, null, null, 192);
        n(this, R.string.Emoji_VRHeadset, "VRHeadset", "VRHeadset", "emoji_vrheadset_v1.png", R.drawable.emoji_vrheadset_v1, false, null, null, 192);
        n(this, R.string.Emoji_FullMoonFace, "FullMoonFace", "FullMoonFace", "emoji_fullmoonface_v1.png", R.drawable.emoji_fullmoonface_v1, false, null, null, 192);
        n(this, R.string.Emoji_ColdSweat, "ColdSweat", "ColdSweat", "emoji_coldsweat_v1.png", R.drawable.emoji_coldsweat_v1, false, null, null, 192);
        n(this, R.string.Emoji_Delighted, "Delighted", "Delighted", "emoji_delighted_v1.png", R.drawable.emoji_delighted_v1, false, null, null, 192);
        n(this, R.string.Emoji_BeamingFace, "BeamingFace", "BeamingFace", "emoji_beamingface_v1.png", R.drawable.emoji_beamingface_v1, false, null, null, 192);
        n(this, R.string.Emoji_ThanksFace, "ThanksFace", "ThanksFace", "emoji_thanksface_v1.png", R.drawable.emoji_thanksface_v1, false, null, null, 192);
        n(this, R.string.Emoji_SaluteFace, "SaluteFace", "SaluteFace", "emoji_saluteface_v1.png", R.drawable.emoji_saluteface_v1, false, null, null, 192);
        n(this, R.string.Emoji_Shrug, "Shrug", "Shrug", "emoji_shrug_v1.png", R.drawable.emoji_shrug_v1, false, null, null, 192);
        n(this, R.string.Emoji_ClownFace, "ClownFace", "ClownFace", "emoji_clownface_v1.png", R.drawable.emoji_clownface_v1, false, null, null, 192);
        n(this, R.string.Emoji_WavingHand, "MediumlightWavingHand", "MediumlightWavingHand", "emoji_mediumlightwavinghand_v1.png", R.drawable.emoji_mediumlightwavinghand_v1, false, null, null, 192);
        n(this, R.string.Emoji_WavingHand, "LightWavingHand", "LightWavingHand", "emoji_lightwavinghand_v1.png", R.drawable.emoji_lightwavinghand_v1, false, null, null, 192);
        n(this, R.string.Emoji_WavingHand, "WavingHand", "WavingHand", "emoji_wavinghand_v1.png", R.drawable.emoji_wavinghand_v1, false, null, new String[]{"MediumlightWavingHand", "LightWavingHand", "WavingHand", "MediumWavingHand", "MediumdarkWavingHand", "DarkWavingHand"}, 64);
        n(this, R.string.Emoji_WavingHand, "MediumWavingHand", "MediumWavingHand", "emoji_mediumwavinghand_v1.png", R.drawable.emoji_mediumwavinghand_v1, false, null, null, 192);
        n(this, R.string.Emoji_WavingHand, "MediumdarkWavingHand", "MediumdarkWavingHand", "emoji_mediumdarkwavinghand_v1.png", R.drawable.emoji_mediumdarkwavinghand_v1, false, null, null, 192);
        n(this, R.string.Emoji_WavingHand, "DarkWavingHand", "DarkWavingHand", "emoji_darkwavinghand_v1.png", R.drawable.emoji_darkwavinghand_v1, false, null, null, 192);
        n(this, R.string.Emoji_2024, "2024", "2024", "emoji_2024_v1.png", R.drawable.emoji_2024_v1, false, null, null, 192);
        n(this, R.string.Emoji_HappyDragon, "HappyDragon", "HappyDragon", "emoji_happydragon_v3.png", R.drawable.emoji_happydragon_v3, false, null, null, 192);
        n(this, R.string.Emoji_2025, "2025", "2025", "emoji_2025_v1.png", R.drawable.emoji_2025_v1, false, null, null, 192);
        n(this, R.string.Emoji_Snake2025, "SiSiASYouWish", "SiSiASYouWish", "emoji_sisiasyouwish_v1.png", R.drawable.emoji_sisiasyouwish_v1, false, null, null, 192);
        n(this, R.string.Emoji_2026, "2026", "2026", "emoji_2026_v1.png", R.drawable.emoji_2026_v1, false, null, null, 192);
        n(this, R.string.Emoji_Horse2026, "BeAtTheForefront", "BeAtTheForefront", "emoji_beattheforefront_v1.png", R.drawable.emoji_beattheforefront_v1, false, null, null, 192);
        n(this, R.string.Emoji_ThanksHoldingBoard, "ThanksHoldingBoard", "ThanksHoldingBoard", "emoji_thanksholdingboard_v1.png", R.drawable.emoji_thanksholdingboard_v1, false, null, null, 192);
        Locale r100 = com.ss.android.lark.language.service.impl.a.o().getLanguageSetting();
        Log.i("EmojiMapManager2", "setDefaultData, local: " + wsb.c.a(r100));
        if (Intrinsics.areEqual(r100.getLanguage(), Locale.CHINESE.getLanguage()) == true) goto L5;
        n(this, R.string.Emoji_Money, "Lark_Emoji_Money_0", "MONEY", "emoji_dollar.png", R.drawable.emoji_dollar, false, "钱", null, 128);
        n(this, R.string.Emoji_OK, "Lark_Emoji_OK_0", "OK", "emoji_ok_v2.png", R.drawable.emoji_ok, false, "OK", null, 128);
        n(this, R.string.Emoji_Betrayed, "Lark_Emoji_Betrayed_0", "BETRAYED", "emoji_mad.png", R.drawable.emoji_mad, false, "绿帽子", null, 128);
        n(this, R.string.Emoji_Awesomen, "Awesomen", "AWESOMEN", "emoji_socool_v2.png", R.drawable.emoji_socool, false, "", null, 128);
        n(this, R.string.Emoji_TwentyTwentyone, "2021", "2021", "emoji_balloon_v2.png", R.drawable.emoji_balloon, false, "", null, 128);
        n(this, R.string.Emoji_Fortune, "Fortune", "FORTUNE", "emoji_gold.png", R.drawable.emoji_gold, false, "", null, 128);
        n(this, R.string.Emoji_Get, "Get", "Get", "emoji_gotit_v1.png", R.drawable.emoji_gotit_v1, false, null, null, 128);
        n(this, R.string.Emoji_AiNailedIt, "AINailedIt", "AINailedIt", "emoji_ai_nailed_it_zh.png", R.drawable.emoji_ai_answer_apply_cn, false, null, null, 128);
        return;
    L5:
        n(this, R.string.Emoji_Money, "Lark_Emoji_Money_0", "MONEY", "emoji_money.png", R.drawable.emoji_money, false, "钱", null, 128);
        n(this, R.string.Emoji_OK, "Lark_Emoji_OK_0", "OK", "emoji_ok_v2.png", R.drawable.emoji_ok, false, "OK", null, 128);
        n(this, R.string.Emoji_Betrayed, "Lark_Emoji_Betrayed_0", "BETRAYED", "emoji_betrayed.png", R.drawable.emoji_betrayed, false, "绿帽子", null, 128);
        n(this, R.string.Emoji_Awesomen, "Awesomen", "AWESOMEN", "emoji_awesomen_v2.png", R.drawable.emoji_awesomen, false, "", null, 128);
        n(this, R.string.Emoji_TwentyTwentyone, "2021", "2021", "emoji_twentytwentyone_v2.png", R.drawable.emoji_twentytwentyone, false, "", null, 128);
        n(this, R.string.Emoji_Fortune, "Fortune", "FORTUNE", "emoji_fortune.png", R.drawable.emoji_fortune, false, "", null, 128);
        n(this, R.string.Emoji_Get, "Get", "Get", "emoji_get_v3.png", R.drawable.emoji_get_v3, false, null, null, 128);
        n(this, R.string.Emoji_AiNailedIt, "AINailedIt", "AINailedIt", "emoji_ai_nailed_it_en.png", R.drawable.emoji_ai_answer_apply_en, false, null, null, 128);
    }

    @Override // rsb.a
    public final ConcurrentHashMap<String, qsb.a> Q1() {
        return this.f433018c;
    }

    @Override // rsb.a
    public final ConcurrentHashMap<String, String> h2() {
        return this.f433019d;
    }

    @Inject
    public EmojiMapManager2(m r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        super(r100);
        this.f433017b = new ConcurrentHashMap();
        this.f433018c = new ConcurrentHashMap();
        this.f433019d = new ConcurrentHashMap();
        this.f433020e = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("EmojiMapManager2"));
        this.f433021f = new ConcurrentHashMap();
        this.f433022g = new ConcurrentHashMap();
        this.f433023h = Integer.MIN_VALUE;
        this.f433024i = Integer.MIN_VALUE;
        this.f433025j = LazyKt.lazy(EmojiMapManager2$emojiLoadExecutor$2.INSTANCE);
        Log.i("EmojiMapManager2", "init");
        u();
    }

    @Override // rsb.a
    public final qsb.a Yd(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reactionKey");
        return this.f433018c.get(r100);
    }

    @Override // rsb.a
    public final qsb.a b0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "emojiKey");
        return this.f433017b.get(r100);
    }

    @Override // rsb.a
    public final void c9(rsb.a.InterfaceC7530a r100) {
        this.f433026k = r100;
    }

    @Override // rsb.a
    public final String df(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (i7(r100) == true) goto L5;
        qsb.a r101 = p(r100);
        if (r101 == null) goto L9;
        String r102 = r101.f534725c;
    L10:
        if (r102 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == false) goto L18;
        Log.i("EmojiMapManager2", "getReactionOrEmojiText, emoji text is null, key = ".concat(r100));
    L18:
        if (r101 == null) goto L24;
        String r104 = r101.f534725c;
        if (r104 != null) goto L23;
        return r100;
    L23:
        return r104;
    L24:
        return r100;
    L12:
        if (r102.length() == 0) goto L15;
        r103 = false;
        goto L16
    L9:
        r102 = null;
        goto L10
    L5:
        return UIHelper.getString(R.string.Lark_IM_ImageIllegalUnableToDisplay_Text);
    }

    @Override // rsb.a
    public final boolean i7(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        qsb.a r101 = p(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.f534730h;
    }

    @Override // rsb.a
    /* JADX INFO: renamed from: if, reason: not valid java name */
    public final boolean mo8648if(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        qsb.a r101 = p(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return !TextUtils.isEmpty(r101.f534726d);
    }

    @Override // rsb.a
    public final boolean l4(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        qsb.a r101 = p(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.b() == null) goto L9;
        return true;
    L9:
        return false;
    }

    public final qsb.a p(String r100) {
        qsb.a r101 = b0(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return Yd(r100);
    }

    public final void s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (i7(r100) == false) goto L7;
        Log.w("EmojiMapManager2", "requestBitmap, key is delete");
        return;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        Log.e("EmojiMapManager2", "requestBitmap, key is null");
        return;
    L10:
        qsb.a r101 = p(r100);
        if (r101 != null) goto L20;
        Log.i("EmojiMapManager2", "requestBitmap, key = " + r100 + ", emoji entity is null, get emojis from net.");
        List<String> r102 = CollectionsKt.listOf(r100);
        if (this.f433026k != null) goto L15;
        Log.w("EmojiMapManager2", "getEntityFromNet, emojiDataFetcher is null");
    L15:
        rsb.a.InterfaceC7530a r103 = this.f433026k;
        if (r103 == null) goto L23;
        r103.k0(this.f433024i, r102);
        return;
    L23:
        return;
    L20:
        if (r101.b() != null) goto L24;
        Log.i("EmojiMapManager2", "requestBitmap, key = " + r100 + ", emoji bitmap is null, load bitmap.");
        r(r101.f534726d, r101);
        return;
    }

    @Override // rsb.a
    @Deprecated(message = "replace with [requestBitmap(String)]", replaceWith = @ReplaceWith(expression = "requestBitmap(key)", imports = {}))
    public final void sb(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        s(r100);
    }

    @Override // rsb.a
    public final String ub(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (i7(r100) == false) goto L5;
        return null;
    L5:
        qsb.a r101 = p(r100);
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f534726d;
    }

    @Override // rsb.a
    public final Bitmap v1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (i7(r100) == false) goto L5;
        return null;
    L5:
        qsb.a r101 = p(r100);
        if (r101 != null) goto L10;
        Statistics.sendEvent("emoji_show_fallback", new JSONObject().put("version", this.f433024i).put("key", r100));
        return null;
    L10:
        return r101.b();
    }

    @Override // rsb.a
    @Deprecated(message = "replace with [getReactionOrEmojiBitmap]", replaceWith = @ReplaceWith(expression = "getReactionOrEmojiBitmap(key)", imports = {}))
    public final Bitmap Hb(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return v1(r100);
    }

    @Override // rsb.a
    @Deprecated(message = "replace with [getReactionOrEmojiText]", replaceWith = @ReplaceWith(expression = "getReactionOrEmojiText(key)", imports = {}))
    public final String K9(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return df(r100);
    }

    @Override // rsb.a
    public final void V8(Set<? extends qsb.a> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "set");
        Log.i("EmojiMapManager2", "updateMap, version = " + r101 + ", change count = " + r100.size());
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        this.f433024i = r101;     // Catch: Throwable -> L29
        Iterator<T> r102 = r100.iterator();     // Catch: Throwable -> L29
    L8:
        if (r102.hasNext() == false) goto L19;
        qsb.a r103 = (qsb.a) r102.next();     // Catch: Throwable -> L29
        qsb.a r104 = this.f433017b.get(r103.f534723a);     // Catch: Throwable -> L29
        if (r104 == null) goto L12;
        String r105 = r104.f534725c;     // Catch: Throwable -> L29
    L13:
        this.f433017b.put(r103.f534723a, r103);     // Catch: Throwable -> L29
        this.f433018c.put(r103.f534724b, r103);     // Catch: Throwable -> L29
        if (r105 == null) goto L18;
        if (y0.a(r103.f534725c, r105) == true) goto L18;
        this.f433019d.remove(r105);     // Catch: Throwable -> L29
    L18:
        this.f433019d.put(r103.f534725c, r103.f534723a);     // Catch: Throwable -> L29
        goto L8
    L12:
        r105 = null;
        goto L13
    L19:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(this);
        Iterator<T> r107 = r100.iterator();
    L23:
        if (r107.hasNext() == false) goto L27;
        qsb.a r108 = (qsb.a) r107.next();
        if (r108.b() != null) goto L23;
        r(r108.f534726d, r108);
        goto L23
    L27:
        this.f433020e.execute(new com.ss.android.lark.newemoji.impl.a(this));
        return;
    L29:
        th = move-exception;
        throw th;
    }

    public final void r(String r100, qsb.a r101) {
        Log.i("EmojiMapManager2", "loadBitmapFromNet, start load bitmap of " + r101.f534723a + " from net, " + r100);
        ImageLoader.with(UIHelper.getContext()).load(new EmojiImageResource(r100)).diskCacheStrategy(DiskCacheStrategy.RESULT).sourceExecutor((GlideExecutor) this.f433025j.getValue()).asBitmap().listener(new b(SystemClock.elapsedRealtime(), r100)).into(new c(r101, r100, this));
    }

    @Override // rsb.a
    public final void ge(String r100, boolean r101, IGetDataCallback<Boolean> r102, IGetDataCallback<Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (i7(r100) == false) goto L10;
        Log.w("EmojiMapManager2", "requestBitmapWithCallback, key is delete");
        if (r102 == null) goto L7;
        r102.onError(new ErrorResult("key is delete"));
    L7:
        if (r103 == null) goto L52;
        r103.onError(new ErrorResult("key is delete"));
        return;
    L52:
        return;
    L10:
        boolean r104 = false;
        if (r100.length() != 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L16;
        qsb.a r106 = p(r100);
        if (r106 != null) goto L24;
    L36:
        if (r102 != null) goto L38;
    L43:
        if (r103 != null) goto L45;
    L50:
        s(r100);
        return;
    L45:
        if (this.f433022g.get(r100) != null) goto L47;
        this.f433022g.put(r100, new CopyOnWriteArrayList());
    L47:
        Log.i("EmojiMapManager2", "requestBitmapWithCallback, add image resources callback of ".concat(r100));
        CopyOnWriteArrayList<WeakReference<IGetDataCallback<Boolean>>> r107 = this.f433022g.get(r100);
        if (r107 == null) goto L50;
        r107.add(new WeakReference(r103));
        goto L50
    L38:
        if (this.f433021f.get(r100) != null) goto L40;
        this.f433021f.put(r100, new CopyOnWriteArrayList());
    L40:
        Log.i("EmojiMapManager2", "requestBitmapWithCallback, add emoji entity callback of ".concat(r100));
        CopyOnWriteArrayList<WeakReference<IGetDataCallback<Boolean>>> r108 = this.f433021f.get(r100);
        if (r108 == null) goto L43;
        r108.add(new WeakReference(r102));
        goto L43
    L24:
        if (r106.f534726d.length() <= 0) goto L26;
        r104 = true;
    L26:
        if (r104 == false) goto L28;
    L29:
        if (r102 == null) goto L32;
        r102.onSuccess(Boolean.TRUE);
    L32:
        if (r106.b() == null) goto L43;
        if (r103 == null) goto L54;
        r103.onSuccess(Boolean.TRUE);
        return;
    L54:
        return;
    L28:
        if (r106.b() == null) goto L36;
    L16:
        if (r102 == null) goto L18;
        r102.onError(new ErrorResult("key is null"));
    L18:
        if (r103 == null) goto L53;
        r103.onError(new ErrorResult("key is null"));
        return;
    L53:
        return;
    L13:
        r105 = false;
        goto L14
    }

    public final void m(int r110, String r111, String r112, String r113, int r114, boolean r115, String r116, String[] r210) {
        String r117 = UIHelper.getString(r110);
        qsb.a r118 = new qsb.a(r111, r112, r117, r113, r114, Boolean.valueOf(r115));
        if (r210 == null) goto L5;
        List r100 = ArraysKt.toList(r210);
        r118.f534728f.clear();
        r118.f534728f.addAll(r100);
    L5:
        this.f433017b.put(r111, r118);
        this.f433018c.put(r112, r118);
        this.f433019d.put(r117, r111);
        boolean r101 = false;
        if (r116 != null) goto L8;
    L13:
        if (r101 == false) goto L16;
        this.f433017b.put(r116, r118);
        return;
    L16:
        return;
    L8:
        if (r116.length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 != true) goto L13;
        r101 = true;
        goto L13
    L10:
        r102 = false;
        goto L11
    }

    public static /* synthetic */ void n(EmojiMapManager2 r110, int r111, String r112, String r113, String r114, int r115, boolean r116, String r117, String[] r210, int r211) {
        if ((r211 & 64) == 0) goto L5;
        String r118 = null;
    L7:
        if ((r211 & 128) == 0) goto L9;
        String[] r119 = null;
    L10:
        r110.m(r111, r112, r113, r114, r115, r116, r118, r119);
        return;
    L9:
        r119 = r210;
        goto L10
    L5:
        r118 = r117;
        goto L7
    }
}
