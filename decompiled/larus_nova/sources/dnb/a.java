package dnb;

import android.app.Activity;
import android.content.Context;
import androidx.camera.video.AudioStats;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.param.IMConstants$NetworkLevel;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.keyboard.plugin.tool.at.KeyboardAtModule;
import com.ss.android.lark.keyboard.plugin.tool.face.KeyboardEmojiModule;
import com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pmb.d;
import yob.e;

/* JADX INFO: loaded from: classes36.dex */
public class a implements KeyboardAtModule.a, KeyboardEmojiModule.a, KeyboardPhotoModule.a, KeyboardVoiceModule.a {

    /* JADX INFO: renamed from: dnb.a$a, reason: collision with other inner class name */
    public static final class C5691a implements KeyboardVoiceModule.c {
        public C5691a() {
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.c
        public final void a(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "chatterId");
            d r102 = nmb.a.a().getCoreDependency();
            Chatter.ChatterType r103 = Chatter.ChatterType.UNKNOWN;
            new ContactSource();
            r102.d();
        }
    }

    public a() {
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public IMConstants$NetworkLevel getCurNetWorkLevel() {
        List<h3c.a> r100 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.f439712a;
        com.ss.android.lark.rustinfrabridge.netstate.impl.d.b.f439716a.getClass();
        Object r101 = LarkNetworkLevelManager.f439693d;
        return IMConstants$NetworkLevel.forNumber(LarkNetworkLevelManager.a.a().getCurNetWorkLevel().getValue());
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.KeyboardEmojiModule.a, com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule.a
    public int getFileUploadAuthorizatedDenyCode() {
        IIMApi r100 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getFileUploadAuthorizatedDenyCode();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.KeyboardEmojiModule.a, com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule.a
    public int getFileUploadAuthorizatedDenyCodeByFilePolicy() {
        IIMApi r100 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r100 != null) goto L7;
        return 321001;
    L7:
        return r100.getFileUploadDenyCodeByFilePolicy();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public KeyboardVoiceModule.c getProfileDependency() {
        return new C5691a();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public KeyboardVoiceModule.d getVcDependency() {
        int r100 = nmb.b.f519617a;
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Boolean.class) == false) goto L6;
        Object r101 = Boolean.FALSE;
    L33:
        if (r101 == null) goto L37;
        return (KeyboardVoiceModule.d) r101;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.IVcDependency");
    L6:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Byte.class) == false) goto L9;
        r101 = (byte) 0;
        goto L33
    L9:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Short.class) == false) goto L12;
        r101 = (short) 0;
        goto L33
    L12:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Integer.class) == false) goto L15;
        r101 = 0;
        goto L33
    L15:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Long.class) == false) goto L18;
        r101 = 0L;
        goto L33
    L18:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Float.class) == false) goto L21;
        r101 = Float.valueOf(0.0f);
        goto L33
    L21:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Double.class) == false) goto L24;
        r101 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        goto L33
    L24:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Character.class) == false) goto L27;
        r101 = (char) 0;
        goto L33
    L27:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, ArrayList.class) == false) goto L30;
        r101 = CollectionsKt.emptyList();
        goto L33
    L30:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Unit.class) == false) goto L32;
        r101 = Unit.INSTANCE;
        goto L33
    L32:
        r101 = nmb.b.a(KeyboardVoiceModule.d.class);
        goto L33
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public Locale getCurrentLocale() {
        e.a().getClass();
        int r100 = com.ss.android.lark.language.service.impl.a.f431092f;
        return com.ss.android.lark.language.service.impl.a.b.f431098a.getCacheLanguageSetting();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule.a
    public int getUnifiedStorageLimitErrorCode() {
        return owa.a.d().getUnifiedStorageLimitErrorCode();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.KeyboardEmojiModule.a
    public String getUploadAuthorizationTip() {
        return owa.a.b().a();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public boolean isEn() {
        e.a().getClass();
        return com.ss.android.lark.language.service.impl.c.a.f431101a.b();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public boolean isZh() {
        e.a().getClass();
        com.ss.android.lark.language.service.impl.c r100 = com.ss.android.lark.language.service.impl.c.a.f431101a;
        if (r100.c() == false) goto L5;
    L10:
        return true;
    L5:
        if (r100.d() == true) goto L10;
        if (r100.e() == true) goto L10;
        return false;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public boolean isCurrentFeatureEnable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "featureName");
        return FeatureGatingModule.getFeatureGatingService().isCurrentEnable(r100);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.at.KeyboardAtModule.a, com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public boolean isFeatureGatingEnable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "featureName");
        return FeatureGatingModule.getFeatureGatingService().isEnable(r100);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule.a
    public boolean isHitStorageQuotaLimit(int r100) {
        return owa.a.d().isHitStorageQuotaLimit(r100);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule.a
    public void showUnifiedStorageLimitCTADialog(Activity r100) {
        owa.a.d().showUnifiedStorageLimitCTADialog(r100);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.KeyboardEmojiModule.a, com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule.a
    public void onAuthorizatedDeny(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        owa.a.b().b(r100, r101);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule.a
    public boolean showQuotaLimitDialog(Activity r100, int r101) {
        return owa.a.d().showQuotaLimitDialog(r100, r101);
    }
}
