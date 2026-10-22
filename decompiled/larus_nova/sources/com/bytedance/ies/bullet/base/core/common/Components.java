package com.bytedance.ies.bullet.base.core.common;

import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/base/core/common/Components;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Activity", "Fragment", "DialogFragment", "View", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum Components extends Enum<Components> {
    public static final Components Activity = null;
    public static final Components DialogFragment = null;
    public static final Components Fragment = null;
    public static final Components View = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Components[] f246312a = null;
    private final String tag;

    public static Components valueOf(String r100) {
        return (Components) a.a(Components.class, r100);
    }

    public static Components[] values() {
        return (Components[]) f246312a.clone();
    }

    static {
        Components r100 = new Components("Activity", 0, "activity");
        Activity = r100;
        Components r101 = new Components("Fragment", 1, WidgetService.PARAM_FRAGMENT);
        Fragment = r101;
        Components r102 = new Components("DialogFragment", 2, "dialogFragment");
        DialogFragment = r102;
        Components r103 = new Components("View", 3, "view");
        View = r103;
        f246312a = new Components[]{r100, r101, r102, r103};
    }

    public final String getTag() {
        return this.tag;
    }

    public Components(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
