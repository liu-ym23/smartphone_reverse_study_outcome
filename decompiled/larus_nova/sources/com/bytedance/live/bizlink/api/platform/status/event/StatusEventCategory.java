package com.bytedance.live.bizlink.api.platform.status.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/live/bizlink/api/platform/status/event/StatusEventCategory;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "VIDEO", "AUDIO", "multi-biz-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum StatusEventCategory extends Enum<StatusEventCategory> {
    public static final StatusEventCategory AUDIO = null;
    public static final StatusEventCategory VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StatusEventCategory[] f254864a = null;
    private final String value;

    static {
        StatusEventCategory r100 = new StatusEventCategory("VIDEO", 0, "video");
        VIDEO = r100;
        StatusEventCategory r101 = new StatusEventCategory("AUDIO", 1, "audio");
        AUDIO = r101;
        f254864a = new StatusEventCategory[]{r100, r101};
    }

    public static StatusEventCategory valueOf(String r100) {
        return (StatusEventCategory) a.a(StatusEventCategory.class, r100);
    }

    public static StatusEventCategory[] values() {
        return (StatusEventCategory[]) f254864a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public StatusEventCategory(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
