package com.ivy.ivykit.api.bridge.inject;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/ivy/ivykit/api/bridge/inject/ActionSheetBuilder;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "title", "", "subtitle", SlcCommonAction.KEY_ACTIONS, "", "Lcom/ivy/ivykit/api/bridge/inject/ActionSheetBuilderAction;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "getContext", "()Landroid/content/Context;", "getSubtitle", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ivy_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ActionSheetBuilder {
    private final List<ActionSheetBuilderAction> actions;
    private final Context context;
    private final String subtitle;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionSheetBuilder copy$default(ActionSheetBuilder r100, Context r101, String r102, String r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.context;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.title;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.subtitle;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.actions;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Context component1() {
        return this.context;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.subtitle;
    }

    public final List<ActionSheetBuilderAction> component4() {
        return this.actions;
    }

    public final ActionSheetBuilder copy(Context r100, String r101, String r102, List<ActionSheetBuilderAction> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, SlcCommonAction.KEY_ACTIONS);
        return new ActionSheetBuilder(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ActionSheetBuilder) == true) goto L8;
        return false;
    L8:
        ActionSheetBuilder r101 = (ActionSheetBuilder) r100;
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subtitle, r101.subtitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.context.hashCode() * 31;
        String r101 = this.title;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.subtitle;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.actions.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionSheetBuilder(context=" + this.context + ", title=" + this.title + ", subtitle=" + this.subtitle + ", actions=" + this.actions + ")";
    }

    public final List<ActionSheetBuilderAction> getActions() {
        return this.actions;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public ActionSheetBuilder(Context r100, String r101, String r102, List<ActionSheetBuilderAction> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, SlcCommonAction.KEY_ACTIONS);
        this.context = r100;
        this.title = r101;
        this.subtitle = r102;
        this.actions = r103;
    }

    public /* synthetic */ ActionSheetBuilder(Context r100, String r101, String r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}
