package com.bytedance.locallife.poi.newdetail.component.feed.coi;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/feed/coi/CoiUIGravity;", "", "", GXTemplateKey.GAIAX_LAYER_GRAVITY, "Ljava/lang/String;", "getGravity", "()Ljava/lang/String;", "GRAVITY_BOTTOM", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum CoiUIGravity extends Enum<CoiUIGravity> {
    public static final CoiUIGravity GRAVITY_BOTTOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CoiUIGravity[] f263156a = null;
    private final String gravity;

    public static CoiUIGravity valueOf(String r100) {
        return (CoiUIGravity) r27.a.a(CoiUIGravity.class, r100);
    }

    public static CoiUIGravity[] values() {
        return (CoiUIGravity[]) f263156a.clone();
    }

    static {
        CoiUIGravity r100 = new CoiUIGravity();
        GRAVITY_BOTTOM = r100;
        f263156a = new CoiUIGravity[]{r100};
    }

    public CoiUIGravity() {
        super("GRAVITY_BOTTOM", 0);
        this.gravity = "bottom";
    }

    public final String getGravity() {
        return this.gravity;
    }
}
