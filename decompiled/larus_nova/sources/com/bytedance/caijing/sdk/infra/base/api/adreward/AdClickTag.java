package com.bytedance.caijing.sdk.infra.base.api.adreward;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/adreward/AdClickTag;", "", "Close", "Cancel", "Confirm", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum AdClickTag extends Enum<AdClickTag> {
    public static final AdClickTag Cancel = null;
    public static final AdClickTag Close = null;
    public static final AdClickTag Confirm = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AdClickTag[] f202204a = null;

    public static AdClickTag valueOf(String r100) {
        return (AdClickTag) a.a(AdClickTag.class, r100);
    }

    public static AdClickTag[] values() {
        return (AdClickTag[]) f202204a.clone();
    }

    static {
        AdClickTag r100 = new AdClickTag("Close", 0);
        Close = r100;
        AdClickTag r101 = new AdClickTag("Cancel", 1);
        Cancel = r101;
        AdClickTag r102 = new AdClickTag("Confirm", 2);
        Confirm = r102;
        f202204a = new AdClickTag[]{r100, r101, r102};
    }

    public AdClickTag(String r100, int r101) {
        super(r100, r101);
    }
}
