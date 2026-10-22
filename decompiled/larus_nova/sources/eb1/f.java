package eb1;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.live.soloktv.view.SegmentSelectResult;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nb1.i;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bK\u0010LR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R*\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010E\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010*\u001a\u0004\bF\u0010,\"\u0004\bG\u0010.R\"\u0010H\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010*\u001a\u0004\bI\u0010,\"\u0004\bJ\u0010.¨\u0006M"}, d2 = {"Leb1/f;", "", "Leb1/b;", "audioRecord", "Leb1/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Leb1/b;", "m", "(Leb1/b;)V", "Leb1/e;", "midiRecordModel", "Leb1/e;", "f", "()Leb1/e;", "r", "(Leb1/e;)V", "", "voiceVolume", FaceService.girlLabel, "l", "()F", "x", "(F)V", "bgmVolume", "e", "q", "", "originEnable", "Z", ce.f26391f, "()Z", "s", "(Z)V", "Lcom/bytedance/android/live/ktv/common/model/bean/h;", "tuningEffect", "Lcom/bytedance/android/live/ktv/common/model/bean/h;", ce.f26395j, "()Lcom/bytedance/android/live/ktv/common/model/bean/h;", BaseSwitches.V, "(Lcom/bytedance/android/live/ktv/common/model/bean/h;)V", "", "tuningEffectFile", "Ljava/lang/String;", ce.f26396k, "()Ljava/lang/String;", "w", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/soloktv/view/SegmentSelectResult;", "segmentResult", "Lcom/bytedance/android/live/soloktv/view/SegmentSelectResult;", "h", "()Lcom/bytedance/android/live/soloktv/view/SegmentSelectResult;", "t", "(Lcom/bytedance/android/live/soloktv/view/SegmentSelectResult;)V", "", "Leb1/c;", "bgRecordList", "Ljava/util/List;", "d", "()Ljava/util/List;", "p", "(Ljava/util/List;)V", "Lnb1/i;", ThumbGlideUrl.SOURCE_TEMPLATE, "Lnb1/i;", RXScreenCaptureService.KEY_INDEX, "()Lnb1/i;", "u", "(Lnb1/i;)V", "bgCategory", "b", OfficeSDKRequestTag.KEY_NEW_USER, "bgMvId", "c", "o", "<init>", "()V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f {

    @SerializedName("audio_record")
    private b audioRecord;

    @SerializedName("bg_category")
    private String bgCategory;

    @SerializedName("bg_mv_id")
    private String bgMvId;

    @SerializedName("bg_select_list")
    private List<c> bgRecordList;

    @SerializedName("bgm_volume")
    private float bgmVolume;

    @SerializedName("midi_record")
    private e midiRecordModel;

    @SerializedName("is_use_original")
    private boolean originEnable;

    @SerializedName(MonitorConstants.SEGMENT)
    private SegmentSelectResult segmentResult;

    @SerializedName(ThumbGlideUrl.SOURCE_TEMPLATE)
    private i template;

    @SerializedName("tuning_effect")
    private h tuningEffect;

    @SerializedName("tuning_effect_file")
    private String tuningEffectFile;

    @SerializedName("voice_volume")
    private float voiceVolume;

    public f() {
        this.audioRecord = new b();
        this.midiRecordModel = new e();
        this.voiceVolume = 0.5f;
        this.bgmVolume = 0.5f;
        this.originEnable = true;
        this.bgCategory = "recommend";
        this.bgMvId = "";
    }

    public final b a() {
        return this.audioRecord;
    }

    public final String b() {
        return this.bgCategory;
    }

    public final String c() {
        return this.bgMvId;
    }

    public final List<c> d() {
        return this.bgRecordList;
    }

    public final float e() {
        return this.bgmVolume;
    }

    public final e f() {
        return this.midiRecordModel;
    }

    public final boolean g() {
        return this.originEnable;
    }

    public final SegmentSelectResult h() {
        return this.segmentResult;
    }

    public final i i() {
        return this.template;
    }

    public final h j() {
        return this.tuningEffect;
    }

    public final String k() {
        return this.tuningEffectFile;
    }

    public final float l() {
        return this.voiceVolume;
    }

    public final void m(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.audioRecord = r100;
    }

    public final void n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bgCategory = r100;
    }

    public final void o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bgMvId = r100;
    }

    public final void p(List<c> r100) {
        this.bgRecordList = r100;
    }

    public final void q(float r100) {
        this.bgmVolume = r100;
    }

    public final void r(e r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.midiRecordModel = r100;
    }

    public final void s(boolean r100) {
        this.originEnable = r100;
    }

    public final void t(SegmentSelectResult r100) {
        this.segmentResult = r100;
    }

    public final void u(i r100) {
        this.template = r100;
    }

    public final void v(h r100) {
        this.tuningEffect = r100;
    }

    public final void w(String r100) {
        this.tuningEffectFile = r100;
    }

    public final void x(float r100) {
        this.voiceVolume = r100;
    }
}
