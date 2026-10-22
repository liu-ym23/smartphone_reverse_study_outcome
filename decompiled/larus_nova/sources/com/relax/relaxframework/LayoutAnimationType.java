package com.relax.relaxframework;

import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/LayoutAnimationType;", "", "", "value", "I", "getValue", "()I", "Create", UserChangedCallback.CHANGE_TYPE_UPDATE, "Delete", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum LayoutAnimationType extends Enum<LayoutAnimationType> {
    public static final LayoutAnimationType Create = null;
    public static final LayoutAnimationType Delete = null;
    public static final LayoutAnimationType Update = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayoutAnimationType[] f404754a = null;
    private final int value;

    public static LayoutAnimationType valueOf(String r100) {
        return (LayoutAnimationType) r27.a.a(LayoutAnimationType.class, r100);
    }

    public static LayoutAnimationType[] values() {
        return (LayoutAnimationType[]) f404754a.clone();
    }

    static {
        LayoutAnimationType r100 = new LayoutAnimationType("Create", 0, 0);
        Create = r100;
        LayoutAnimationType r101 = new LayoutAnimationType(UserChangedCallback.CHANGE_TYPE_UPDATE, 1, 1);
        Update = r101;
        LayoutAnimationType r102 = new LayoutAnimationType("Delete", 2, 2);
        Delete = r102;
        f404754a = new LayoutAnimationType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public LayoutAnimationType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
