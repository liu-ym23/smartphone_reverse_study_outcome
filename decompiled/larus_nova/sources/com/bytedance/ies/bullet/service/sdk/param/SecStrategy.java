package com.bytedance.ies.bullet.service.sdk.param;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/SecStrategy;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", EffectConstants.NORMAL, "SANDBOX", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SecStrategy extends Enum<SecStrategy> {
    public static final SecStrategy NORMAL = null;
    public static final SecStrategy SANDBOX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SecStrategy[] f248145a = null;
    private final String value;

    public static SecStrategy valueOf(String r100) {
        return (SecStrategy) r27.a.a(SecStrategy.class, r100);
    }

    public static SecStrategy[] values() {
        return (SecStrategy[]) f248145a.clone();
    }

    static {
        SecStrategy r100 = new SecStrategy(EffectConstants.NORMAL, 0, "0");
        NORMAL = r100;
        SecStrategy r101 = new SecStrategy("SANDBOX", 1, "1");
        SANDBOX = r101;
        f248145a = new SecStrategy[]{r100, r101};
    }

    public final String getValue() {
        return this.value;
    }

    public SecStrategy(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
