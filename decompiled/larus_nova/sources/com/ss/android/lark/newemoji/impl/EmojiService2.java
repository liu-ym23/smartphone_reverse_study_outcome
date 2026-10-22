package com.ss.android.lark.newemoji.impl;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.Emoji;
import com.bytedance.lark.pb.im.v1.GetEmojisRequest;
import com.bytedance.lark.pb.im.v1.GetEmojisResponse;
import com.bytedance.lark.pb.im.v1.PushEmojis;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class EmojiService2 extends c0c.c implements rsb.b, rsb.a.InterfaceC7530a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f433032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rsb.a f433033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f433034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f433035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f433036f;

    public static final class a {
    }

    public static final class b implements zob.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EmojiService2 f433037a;

        public b(EmojiService2 r100) {
            this.f433037a = r100;
        }

        @Override // zob.b
        public final void a(Locale r100, Locale r101) {
            Log.i("EmojiService2", "onLanguageChange, from " + wsb.c.a(r100) + " to " + wsb.c.a(r101));
            this.f433037a.f433033c.f3();
            this.f433037a.P4();
        }
    }

    static {
    }

    @Override // rsb.b
    public final void P4() {
        k0(this.f433033c.U9(), null);
    }

    @Override // c0c.c
    public final void c() {
        Log.i("EmojiService2", MapMonitorConst.EVENT_DESTROY);
        yob.e.a().getClass();
        int r100 = com.ss.android.lark.language.service.impl.a.f431092f;
        com.ss.android.lark.language.service.impl.a.b.f431098a.k(this.f433035e);
        this.f433033c.c9(null);
        Disposable r101 = this.f433036f;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        this.f433036f = null;
    }

    @Override // c0c.c
    public final void e() {
        Log.i("EmojiService2", "onPrepared");
        yob.e.a().getClass();
        int r100 = com.ss.android.lark.language.service.impl.a.f431092f;
        com.ss.android.lark.language.service.impl.a.b.f431098a.c(this.f433035e);
        this.f433033c.c9(this);
        Disposable r101 = this.f433036f;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        this.f433036f = this.f433032b.i(Command.PUSH_EMOJIS, PushEmojis.ADAPTER).subscribe(new d(this), e.f433046a);
        P4();
    }

    @Override // rsb.b, rsb.a.InterfaceC7530a
    public final void k0(int r110, final List<String> r111) {
        if (this.f433034d.get() == false) goto L5;
        return;
    L5:
        this.f433034d.set(true);
        Log.i("EmojiService2", "fetchEmojis start");
        if (r110 != Integer.MIN_VALUE) goto L8;
        final boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        Integer r101 = null;
    L12:
        GetEmojisRequest.Builder r102 = new GetEmojisRequest.Builder().version(r101);
        if (CollectionUtils.isEmpty(r111) == true) goto L15;
        r102.trigger_keys(r111);
    L15:
        final long r103 = SystemClock.elapsedRealtime();
        final Function1<ErrorResult, Unit> r104 = new EmojiService2$fetchEmojis$errorHandler$1(r103, r100, r111);
        l r105 = this.f433032b;
        Intrinsics.checkNotNull(r102);
        t.a(r105.h(new com.bytedance.lark.rustclient.api.d(r102, GetEmojisResponse.ADAPTER, Command.GET_EMOJIS, null, null, null, null, 248)).a(), new EmojiService2$fetchEmojis$1(this, r103, r100, r111), new EmojiService2$fetchEmojis$2(this, r104), new EmojiService2$fetchEmojis$3(this, r104));
        return;
    L11:
        r101 = Integer.valueOf(r110);
        goto L12
    L8:
        r100 = false;
        goto L9
    }

    public final Set<qsb.a> m(int r110, Map<String, Emoji> r111) {
        if (this.f433033c.U9() < r110) goto L5;
    L41:
        return null;
    L5:
        if (CollectionUtils.isEmpty(r111) == true) goto L41;
        HashSet r112 = new HashSet();
        Iterator<Map.Entry<String, Emoji>> r113 = r111.entrySet().iterator();
    L9:
        if (r113.hasNext() == false) goto L40;
        Map.Entry<String, Emoji> r100 = r113.next();
        Emoji r101 = r100.getValue();
        String r102 = r100.getKey();
        if (this.f433033c.b0(r102) != null) goto L18;
        if (this.f433033c.Yd(r102) != null) goto L18;
        if (TextUtils.isEmpty(r102) == true) goto L9;
        qsb.a r103 = new qsb.a(r102, r102, r101.text, r101.image_key, null, r101.is_deleted);
        r103.f534731i = r101.width.intValue();
        r103.f534732j = r101.height.intValue();
        List<String> r104 = r101.skin_keys;
        r103.f534728f.clear();
        r103.f534728f.addAll(r104);
        r112.add(r103);
    L18:
        qsb.a r105 = this.f433033c.b0(r102);
        if (r105 != null) goto L24;
        r105 = this.f433033c.Yd(r102);
        if (r105 == null) goto L9;
    L24:
        if (Intrinsics.areEqual(Boolean.valueOf(r105.f534730h), r101.is_deleted) == true) goto L26;
    L30:
        boolean r106 = false;
    L31:
        if (r106 == true) goto L9;
        if (TextUtils.equals(r105.f534725c, r101.text) == true) goto L36;
        Log.i("EmojiService2", "parseEmojisFromPb, emoji text update, key: " + r102 + ", origin text: " + r105.f534725c + ", pb text: " + r101.text);
    L36:
        if (TextUtils.equals(r105.f534726d, r101.image_key) == false) goto L38;
        Bitmap r107 = r105.b();
    L39:
        qsb.a r108 = new qsb.a(r105.f534723a, r105.f534724b, r101.text, r101.image_key, r107, r101.is_deleted);
        r108.f534731i = r101.width.intValue();
        r108.f534732j = r101.height.intValue();
        List<String> r109 = r101.skin_keys;
        r108.f534728f.clear();
        r108.f534728f.addAll(r109);
        r112.add(r108);
        goto L9
    L38:
        r107 = null;
        goto L39
    L26:
        if (TextUtils.equals(r105.f534725c, r101.text) == false) goto L30;
        if (TextUtils.equals(r105.f534726d, r101.image_key) == false) goto L30;
        r106 = true;
        goto L31
    L40:
        return r112;
    }

    @Inject
    public EmojiService2(m r100, l r101, rsb.a r102) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "rustClient");
        Intrinsics.checkNotNullParameter(r102, "emojiMapManager");
        super(r100);
        this.f433032b = r101;
        this.f433033c = r102;
        this.f433034d = new AtomicBoolean(false);
        this.f433035e = new b(this);
        s.a(this);
        r102.c9(this);
    }
}
