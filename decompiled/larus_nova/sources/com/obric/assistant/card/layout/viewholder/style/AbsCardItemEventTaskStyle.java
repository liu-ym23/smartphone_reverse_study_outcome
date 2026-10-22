package com.obric.assistant.card.layout.viewholder.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.aiagent.assistant.common.ui.icon.TaskResolvedIcon;
import com.obric.aiagent.assistant.common.ui.icon.b;
import com.obric.aiagent.assistant.common.ui.icon.c;
import com.obric.aiagent.assistant.common.ui.icon.d;
import com.obric.assistant.card.databinding.ObricCardItemEventTaskBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import rca.f;
import rca.g;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001aB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0017H\u0004¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemEventTaskStyle;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemEventTaskBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "onBind", "", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", "", "isDeleted", "", "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;IZZ)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemEventTaskStyle$StyleData;", "(Ljava/lang/Object;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemEventTaskStyle$StyleData;", "getSemanticIconValue", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "key", "StyleData", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemEventTaskStyle<T> extends AbsCardItemBaseStyle<T, ObricCardItemEventTaskBinding> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f386439l = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f386440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f386441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f386442c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f386443d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f386444e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f386440a, r101.f386440a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f386441b, r101.f386441b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f386442c, r101.f386442c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f386443d, r101.f386443d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f386444e, r101.f386444e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f386440a.hashCode() * 31) + this.f386441b.hashCode()) * 31) + this.f386442c.hashCode()) * 31;
            String r101 = this.f386443d;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f386444e;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "StyleData(conditionString=" + this.f386440a + ", taskQuery=" + this.f386441b + ", periodString=" + this.f386442c + ", iconKey=" + this.f386443d + ", colorKey=" + this.f386444e + ')';
        }

        public a(String r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "conditionString");
            Intrinsics.checkNotNullParameter(r101, "taskQuery");
            Intrinsics.checkNotNullParameter(r102, "periodString");
            this.f386440a = r100;
            this.f386441b = r101;
            this.f386442c = r102;
            this.f386443d = r103;
            this.f386444e = r104;
        }
    }

    public abstract a a4(Object r100);

    public AbsCardItemEventTaskStyle(ViewGroup r110) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        View r111 = LayoutInflater.from(r110.getContext()).inflate(R.layout.obric_card_item_event_task, r110, false);
        int r100 = R.id.condition;
        TextView r101 = (TextView) ViewBindings.findChildViewById(r111, R.id.condition);
        if (r101 == null) goto L17;
        r100 = R.id.condition_divider;
        View r102 = ViewBindings.findChildViewById(r111, R.id.condition_divider);
        if (r102 == null) goto L17;
        r100 = R.id.period;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r111, R.id.period);
        if (r103 == null) goto L17;
        r100 = R.id.query;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r111, R.id.query);
        if (r104 == null) goto L17;
        ConstraintLayout r105 = (ConstraintLayout) r111;
        r100 = R.id.run_task;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r111, R.id.run_task);
        if (r106 == null) goto L17;
        r100 = R.id.task_icon;
        ImageView r112 = (ImageView) ViewBindings.findChildViewById(r111, R.id.task_icon);
        if (r112 == null) goto L17;
        super(new ObricCardItemEventTaskBinding(r105, r101, r102, r103, r104, r105, r106, r112));
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r100)));
    }

    public static String b4(AppEntity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        String r104 = r100.getExtraData();     // Catch: Throwable -> L12
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        String r105 = new JSONObject(r104).optString(r101);     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L12
        if ((!StringsKt.isBlank(r105)) == true) goto L10;
        r105 = null;
    L10:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r106) == true) goto L19;
        r102 = r106;
    L19:
        return (String) r102;
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r110, final T r111, int r112, final boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r110, "messageExtra");
        a r115 = a4(r111);
        ImageView r116 = ((ObricCardItemEventTaskBinding) this.f386391a).f386106h;
        String r117 = r115.f386443d;
        String r100 = r115.f386444e;
        int r101 = d.f384432a;
        Intrinsics.checkNotNullParameter(r116, "imageView");
        Intrinsics.checkNotNullParameter(r116, "imageView");
        Context r102 = r116.getContext();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        TaskResolvedIcon.Companion.getClass();
        TaskResolvedIcon r103 = TaskResolvedIcon.a.a(r117);
        if (r103 != null) goto L32;
        int r104 = c.f384431a;
        Map<String, List<String>> r105 = b.f384430a;
        String r106 = TaskResolvedIcon.a.b(r117);
        if (r106 == null) goto L9;
        List<String> r107 = b.f384430a.get(r106);
        if (r107 == null) goto L9;
    L11:
        if (r107.isEmpty() == false) goto L13;
        String r118 = TaskResolvedIcon.GENERAL_3.getKey();
    L28:
        TaskResolvedIcon r119 = TaskResolvedIcon.a.a(r118);
        if (r119 != null) goto L31;
        r119 = TaskResolvedIcon.GENERAL_3;
    L31:
        r103 = r119;
        goto L32
    L13:
        String r108 = TaskResolvedIcon.a.b(null);
        if (r108 != null) goto L16;
    L18:
        if (r117 != null) goto L20;
        r117 = "";
    L20:
        int r120 = r117.hashCode();
        int r109 = r107.size();
        int r121 = r120 % r109;
        if (r121 != 0) goto L24;
        r121 = 0;
    L27:
        r118 = (String) ListProtector.get(r107, r121);
        goto L28
    L24:
        if ((((r120 ^ r109) >> 31) | 1) > 0) goto L27;
        r121 = r121 + r109;
        goto L27
    L16:
        if (r107.contains(r108) == false) goto L18;
        r118 = r108;
    L9:
        r107 = CollectionsKt.emptyList();
    L32:
        int r122 = r103.getDrawableRes();
        Map<String, Integer> r123 = com.obric.aiagent.assistant.common.ui.icon.a.f384429a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r124 = TaskResolvedIcon.a.b(r100);
        if (r124 == null) goto L35;
        Integer r125 = com.obric.aiagent.assistant.common.ui.icon.a.f384429a.get(r124);
    L36:
        if (r125 != null) goto L40;
        r125 = com.obric.aiagent.assistant.common.ui.icon.a.f384429a.get("gray");
        if (r125 != null) goto L40;
        int r126 = 0;
    L42:
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r102.getResources().getConfiguration().uiMode & 48) != 32) goto L45;
        boolean r127 = true;
    L46:
        int r128 = l9a.a.f508115a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Drawable r129 = r102.getDrawable(r122);
        if (r129 != null) goto L49;
        l9a.a.C6664a r130 = null;
    L50:
        r116.setImageDrawable(r130);
        r116.setImageTintList(null);
        r116.clearColorFilter();
        ((ObricCardItemEventTaskBinding) this.f386391a).f386100b.setText(r115.f386440a);
        ((ObricCardItemEventTaskBinding) this.f386391a).f386103e.setText(r115.f386441b);
        ((ObricCardItemEventTaskBinding) this.f386391a).f386102d.setText(r115.f386442c);
        View r131 = ((ObricCardItemEventTaskBinding) this.f386391a).f386101c;
        if ((!StringsKt.isBlank(r115.f386440a)) == true) goto L53;
    L55:
        int r132 = 8;
    L56:
        r131.setVisibility(r132);
        Y3(!r113, null, false);
        ((ObricCardItemEventTaskBinding) this.f386391a).f386104f.setOnClickListener(new f(r113, this, r111));
        ((ObricCardItemEventTaskBinding) this.f386391a).f386105g.setOnClickListener(new g(r113, r111));
        return;
    L53:
        if ((!StringsKt.isBlank(r115.f386442c)) == false) goto L55;
        r132 = 0;
        goto L56
    L49:
        Intrinsics.checkNotNullParameter(r129, "drawable");
        r130 = new l9a.a.C6664a(r129.mutate(), r126, r127, false);
        goto L50
    L45:
        r127 = false;
    L40:
        r126 = r125.intValue();
        goto L42
    L35:
        r125 = null;
        goto L36
    }
}
