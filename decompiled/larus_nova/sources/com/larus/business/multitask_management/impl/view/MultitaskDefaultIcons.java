package com.larus.business.multitask_management.impl.view;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0019"}, d2 = {"Lcom/larus/business/multitask_management/impl/view/MultitaskDefaultIcons;", "", "uri", "", "resIdProvider", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getUri", "()Ljava/lang/String;", FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, "PAUSE", "RIGHT", "RECORDING_ICON", "AI_SIMULT_TRANS_ICON", "RECORDING_PAUSE", "RECORDING_RESUME", "QUICK_ACCESS_DOC", "QUICK_ACCESS_PPT", "QUICK_ACCESS_SHEET", "QUICK_ACCESS_FOLDER", "resId", "getResId", "()I", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MultitaskDefaultIcons extends Enum<MultitaskDefaultIcons> {
    public static final MultitaskDefaultIcons AI_SIMULT_TRANS_ICON = null;
    public static final MultitaskDefaultIcons PAUSE = null;
    public static final MultitaskDefaultIcons PLAY = null;
    public static final MultitaskDefaultIcons QUICK_ACCESS_DOC = null;
    public static final MultitaskDefaultIcons QUICK_ACCESS_FOLDER = null;
    public static final MultitaskDefaultIcons QUICK_ACCESS_PPT = null;
    public static final MultitaskDefaultIcons QUICK_ACCESS_SHEET = null;
    public static final MultitaskDefaultIcons RECORDING_ICON = null;
    public static final MultitaskDefaultIcons RECORDING_PAUSE = null;
    public static final MultitaskDefaultIcons RECORDING_RESUME = null;
    public static final MultitaskDefaultIcons RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultitaskDefaultIcons[] f321138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321139b = null;
    private final Function0<Integer> resIdProvider;
    private final String uri;

    public static EnumEntries<MultitaskDefaultIcons> getEntries() {
        return f321139b;
    }

    static {
        MultitaskDefaultIcons r100 = new MultitaskDefaultIcons(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 0, "multitask_play", new i());
        PLAY = r100;
        MultitaskDefaultIcons r101 = new MultitaskDefaultIcons("PAUSE", 1, "multitask_pause", new l());
        PAUSE = r101;
        MultitaskDefaultIcons r102 = new MultitaskDefaultIcons("RIGHT", 2, "multitask_right_arrow", new m());
        RIGHT = r102;
        MultitaskDefaultIcons r103 = new MultitaskDefaultIcons("RECORDING_ICON", 3, "multitask_recording_icon", new n());
        RECORDING_ICON = r103;
        MultitaskDefaultIcons r104 = new MultitaskDefaultIcons("AI_SIMULT_TRANS_ICON", 4, "multitask_ai_simult_trans_icon", new o());
        AI_SIMULT_TRANS_ICON = r104;
        MultitaskDefaultIcons r105 = new MultitaskDefaultIcons("RECORDING_PAUSE", 5, "multitask_recording_icon_pause", new p());
        RECORDING_PAUSE = r105;
        MultitaskDefaultIcons r110 = new MultitaskDefaultIcons("RECORDING_RESUME", 6, "multitask_recording_icon_resume", new q());
        RECORDING_RESUME = r110;
        MultitaskDefaultIcons r111 = new MultitaskDefaultIcons("QUICK_ACCESS_DOC", 7, QuickAccessNodeDefaultIcons.DOC.getUri(), new r());
        QUICK_ACCESS_DOC = r111;
        MultitaskDefaultIcons r112 = new MultitaskDefaultIcons("QUICK_ACCESS_PPT", 8, QuickAccessNodeDefaultIcons.PPT.getUri(), new s());
        QUICK_ACCESS_PPT = r112;
        MultitaskDefaultIcons r113 = new MultitaskDefaultIcons("QUICK_ACCESS_SHEET", 9, QuickAccessNodeDefaultIcons.SHEET.getUri(), new j());
        QUICK_ACCESS_SHEET = r113;
        MultitaskDefaultIcons r106 = new MultitaskDefaultIcons("QUICK_ACCESS_FOLDER", 10, QuickAccessNodeDefaultIcons.FOLDER.getUri(), new k());
        QUICK_ACCESS_FOLDER = r106;
        MultitaskDefaultIcons[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106};
        f321138a = r107;
        f321139b = EnumEntriesKt.enumEntries(r107);
    }

    public static MultitaskDefaultIcons[] values() {
        return (MultitaskDefaultIcons[]) f321138a.clone();
    }

    public final int getResId() {
        return this.resIdProvider.invoke().intValue();
    }

    public final String getUri() {
        return this.uri;
    }

    public static MultitaskDefaultIcons valueOf(String r100) {
        return (MultitaskDefaultIcons) r27.a.a(MultitaskDefaultIcons.class, r100);
    }

    public MultitaskDefaultIcons(String r100, int r101, String r102, Function0 r103) {
        super(r100, r101);
        this.uri = r102;
        this.resIdProvider = r103;
    }
}
