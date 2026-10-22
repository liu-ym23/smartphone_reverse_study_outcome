package com.ss.android.lark.flow.common.utils;

import android.content.Context;
import androidx.core.graphics.ColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.flow.common.component.tag.FlowTagView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowTagBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f423178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ahb.a f423179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f423180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f423181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f423182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f423183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f423184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f423185h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f423186i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f423187j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f423188k;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f423189a = null;

        static {
            int[] r100 = new int[FlowTagType.values().length];
            r100[FlowTagType.PUBLIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[FlowTagType.DEPARTMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[FlowTagType.RESIGNED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[FlowTagType.FROZEN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[FlowTagType.BLOCK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[FlowTagType.ON_LEAVE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[FlowTagType.EXTERNAL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[FlowTagType.AGENT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f423189a = r100;
        }
    }

    static {
    }

    public final FlowTagView b() {
        Log.i("FlowTagBuilder", "isPublic = " + this.f423180c + ", isDepartment = " + this.f423181d + ", isResigned = " + this.f423182e + ", isFrozen = " + this.f423183f + ", isBlock = " + this.f423184g + ", isOnLeave = " + this.f423185h + ", isExternal = " + this.f423186i);
        boolean r100 = ((com.ss.android.lark.passport.dpop.b) this.f423188k.getValue()).isDoubaoBUser();
        StringBuilder r101 = new StringBuilder("isDoubaoBuser = ");
        r101.append(r100);
        Log.i("FlowTagBuilder", r101.toString());
        ArrayList r102 = new ArrayList();
        a(r102, FlowTagType.RESIGNED, this.f423182e);
        a(r102, FlowTagType.FROZEN, this.f423183f);
        a(r102, FlowTagType.ON_LEAVE, this.f423185h);
        a(r102, FlowTagType.EXTERNAL, this.f423186i);
        a(r102, FlowTagType.PUBLIC, this.f423180c);
        a(r102, FlowTagType.DEPARTMENT, this.f423181d);
        a(r102, FlowTagType.BLOCK, this.f423184g);
        a(r102, FlowTagType.AGENT, this.f423187j);
        Intrinsics.checkNotNullParameter(r102, "candidates");
        com.ss.android.lark.flow.common.utils.a r103 = (com.ss.android.lark.flow.common.utils.a) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(r102, new c(new com.ss.android.lark.flow.common.utils.b())));
        if (r103 != null) goto L6;
        return null;
    L6:
        Log.i("FlowTagBuilder", "build tag type = " + r103.getType());
        switch(b.f423189a[r103.getType().ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            default: goto L9;
        };
    L10:
        Context r104 = this.f423178a;
        return c(r104, UIUtils.getString(r104, R.string.Lark_Agent_Tag), UIUtils.getColor(this.f423178a, R.color.flow_ud_primary_50), UIUtils.getColor(this.f423178a, R.color.flow_ud_primary_transparent_2));
    L11:
        Context r105 = this.f423178a;
        return c(r105, UIUtils.getString(r105, R.string.LarkIM_Feed_External_Tag), UIUtils.getColor(this.f423178a, R.color.flow_ud_primary_50), UIUtils.getColor(this.f423178a, R.color.flow_ud_primary_transparent_2));
    L12:
        Context r106 = this.f423178a;
        return c(r106, UIUtils.getString(r106, R.string.LarkIM_Feed_OnLeave_Tag), UIUtils.getColor(this.f423178a, R.color.flow_ud_conditional_warning_50), ColorUtils.setAlphaComponent(UIUtils.getColor(this.f423178a, R.color.flow_ud_conditional_warning_50), 51));
    L13:
        Context r107 = this.f423178a;
        return c(r107, UIUtils.getString(r107, R.string.Lark_DoubaoIM_Block_Tag), UIUtils.getColor(this.f423178a, R.color.flow_ud_conditional_danger_50), ColorUtils.setAlphaComponent(UIUtils.getColor(this.f423178a, R.color.flow_ud_conditional_danger_50), 51));
    L14:
        Context r108 = this.f423178a;
        return c(r108, UIUtils.getString(r108, R.string.LarkIM_Feed_Unavailable_Tag), UIUtils.getColor(this.f423178a, R.color.flow_ud_conditional_danger_50), ColorUtils.setAlphaComponent(UIUtils.getColor(this.f423178a, R.color.flow_ud_conditional_danger_50), 51));
    L19:
        Context r109 = this.f423178a;
        return c(r109, UIUtils.getString(r109, R.string.LarkIM_Feed_Department_Tag), UIUtils.getColor(this.f423178a, R.color.flow_ud_primary_50), UIUtils.getColor(this.f423178a, R.color.flow_ud_primary_transparent_2));
    L20:
        Context r110 = this.f423178a;
        return c(r110, UIUtils.getString(r110, R.string.LarkIM_Feed_Public_Tag), UIUtils.getColor(this.f423178a, R.color.flow_ud_primary_50), UIUtils.getColor(this.f423178a, R.color.flow_ud_primary_transparent_2));
    L9:
        throw new NoWhenBranchMatchedException();
    L16:
        if (r100 != true) goto L18;
        Context r111 = this.f423178a;
        return c(r111, UIUtils.getString(r111, R.string.LarkIM_Feed_Closed_Tag), UIUtils.getColor(this.f423178a, R.color.flow_ud_neutral_50), UIUtils.getColor(this.f423178a, R.color.flow_ud_neutral_transparent_1));
    L18:
        Context r112 = this.f423178a;
        return c(r112, UIUtils.getString(r112, R.string.LarkIM_Feed_Deleted_Tag), UIUtils.getColor(this.f423178a, R.color.flow_ud_neutral_50), UIUtils.getColor(this.f423178a, R.color.flow_ud_neutral_transparent_1));
    }

    public final Context getContext() {
        return this.f423178a;
    }

    public FlowTagBuilder(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f423178a = r100;
        this.f423179b = new ahb.a(0.0f, 0.0f, 0.0f, 0.0f, 63);
        this.f423188k = LazyKt.lazy(FlowTagBuilder$tokenService$2.INSTANCE);
    }

    public static void a(List r100, FlowTagType r101, boolean r102) {
        if (r102 == false) goto L5;
        ArrayList r103 = (ArrayList) r100;
        r103.add(new com.ss.android.lark.flow.common.utils.a(r101, r103.size()));
        return;
    }

    public final FlowTagView c(Context r100, String r101, int r102, int r103) {
        FlowTagView r104 = new FlowTagView(r100, null, 6, 0);
        r104.setTagStyle(this.f423179b);
        r104.setText(r101);
        r104.setTextColor(r102);
        r104.setTagBackgroundColor(r103);
        return r104;
    }
}
