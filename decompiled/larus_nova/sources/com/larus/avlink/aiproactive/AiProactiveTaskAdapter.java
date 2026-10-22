package com.larus.avlink.aiproactive;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.impl.databinding.LarusLayoutItemAiProactiveTaskBinding;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001b\u001c\u001dB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\fJ\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/larus/avlink/aiproactive/AiProactiveTaskAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/avlink/aiproactive/model/UserAonTaskData;", "Lcom/larus/avlink/aiproactive/AiProactiveTaskAdapter$TaskViewHolder;", "listener", "Lcom/larus/avlink/aiproactive/AiProactiveTaskAdapter$Listener;", "<init>", "(Lcom/larus/avlink/aiproactive/AiProactiveTaskAdapter$Listener;)V", "isLongHeadDownCalibrated", "", "Ljava/lang/Boolean;", "setLongHeadDownCalibrationStatusQuietly", "", "isCalibrated", "(Ljava/lang/Boolean;)V", "refreshCalibrationBanners", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "payloads", "", "", "Listener", "TaskViewHolder", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiProactiveTaskAdapter extends ListAdapter<t88.n, TaskViewHolder> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AiProactiveTaskAdapter$Companion$DIFF$1 f291521c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f291522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f291523b;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/avlink/aiproactive/AiProactiveTaskAdapter$TaskViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/avlink/impl/databinding/LarusLayoutItemAiProactiveTaskBinding;", "listener", "Lcom/larus/avlink/aiproactive/AiProactiveTaskAdapter$Listener;", "<init>", "(Lcom/larus/avlink/impl/databinding/LarusLayoutItemAiProactiveTaskBinding;Lcom/larus/avlink/aiproactive/AiProactiveTaskAdapter$Listener;)V", "title", "Landroidx/appcompat/widget/AppCompatTextView;", "switch", "Lcom/larus/bmhome/view/item/CustomSwitchCompat;", "descLine1", "descLine2", "taskBottomBanner", "Landroidx/constraintlayout/widget/ConstraintLayout;", "bind", "", "task", "Lcom/larus/avlink/aiproactive/model/UserAonTaskData;", "isLongHeadDownCalibrated", "", "(Lcom/larus/avlink/aiproactive/model/UserAonTaskData;Ljava/lang/Boolean;)V", "bindTaskBottomBanner", "resolveSceneLeadingIcon", "", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TaskViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f291524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AppCompatTextView f291525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CustomSwitchCompat f291526c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AppCompatTextView f291527d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AppCompatTextView f291528e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ConstraintLayout f291529f;

        public TaskViewHolder(LarusLayoutItemAiProactiveTaskBinding r100, b r101) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            Intrinsics.checkNotNullParameter(r101, "listener");
            super(r100.f293250a);
            this.f291524a = r101;
            this.f291525b = r100.f293254e;
            this.f291526c = r100.f293253d;
            this.f291527d = r100.f293251b;
            this.f291528e = r100.f293252c;
            this.f291529f = r100.f293255f;
        }

        public final void T3(final t88.n r100, Boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "task");
            int r102 = 0;
            if (t88.a.b(r100) == false) goto L9;
            boolean r103 = true;
            if (r100.j() != 1) goto L9;
            if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L9;
        L10:
            ConstraintLayout r104 = this.f291529f;
            if (r103 == true) goto L14;
            r102 = 8;
        L14:
            r104.setVisibility(r102);
            ConstraintLayout r105 = this.f291529f;
            if (r103 == false) goto L17;
            View.OnClickListener r106 = new r(this, r100);
        L18:
            r105.setOnClickListener(r106);
            return;
        L17:
            r106 = null;
        L9:
            r103 = false;
            goto L10
        }
    }

    public static final class a {
    }

    public interface b {
        void JK(View r100, t88.n r101);

        void gz(t88.n r100);

        boolean vu(t88.n r100, boolean r101);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.avlink.aiproactive.AiProactiveTaskAdapter$Companion$DIFF$1] */
    static {
        f291521c = new AiProactiveTaskAdapter$Companion$DIFF$1();
    }

    public final void y2() {
        List<t88.n> r100 = getCurrentList();
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (t88.a.b((t88.n) ListProtector.get(r100, r102)) == false) goto L7;
        notifyItemChanged(r102, "payload_calibration_banner");
    L7:
        r102 = r102 + 1;
        goto L3
    }

    public AiProactiveTaskAdapter(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        super(f291521c);
        this.f291522a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r210, int r211) {
        final TaskViewHolder r100 = (TaskViewHolder) r210;
        Intrinsics.checkNotNullParameter(r100, "holder");
        final t88.n r101 = getItem(r211);
        Boolean r102 = this.f291523b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "task");
        AppCompatTextView r103 = r100.f291525b;
        String r104 = r101.k();
        String r105 = "";
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r103.setText(r104);
        boolean r106 = true;
        if (r101.j() != 1) goto L8;
        boolean r107 = true;
    L9:
        String r108 = null;
        r100.f291526c.setOnCheckedChangeListener(null);
        CustomSwitchCompat r109 = r100.f291526c;
        r109.setChecked(r107);
        r109.setThumbResource(R.drawable.larus_bg_switch_thumb);
        r109.setTrackResource(v19.c.b(R.attr.larus_bg_switch_track, r109.getContext(), R.drawable.larus_bg_switch_track));
        r100.f291526c.setOnCheckedChangeListener(new t(r100, r101, r107));
        Map<Integer, List<String>> r110 = r101.b();
        if (r110 == null) goto L14;
        List<String> r111 = r110.get(3);
        if (r111 == null) goto L14;
        List r112 = CollectionsKt.filterNotNull(r111);
    L15:
        if (r110 == null) goto L19;
        List<String> r113 = r110.get(2);
        if (r113 == null) goto L19;
        List r114 = CollectionsKt.filterNotNull(r113);
    L20:
        if (r110 == null) goto L24;
        List<String> r115 = r110.get(1);
        if (r115 == null) goto L24;
        List r116 = CollectionsKt.filterNotNull(r115);
    L25:
        if (r110 == null) goto L29;
        List<String> r117 = r110.get(0);
        if (r117 == null) goto L29;
        List r118 = CollectionsKt.filterNotNull(r117);
    L30:
        if (r112 == null) goto L42;
        ArrayList r119 = new ArrayList();
        Iterator r120 = r112.iterator();
    L33:
        if (r120.hasNext() == false) goto L40;
        Object r121 = r120.next();
        if (((String) r121).length() <= 0) goto L37;
        boolean r122 = true;
    L38:
        if (r122 == false) goto L33;
        r119.add(r121);
        goto L33
    L37:
        r122 = false;
        goto L38
    L40:
        String r123 = CollectionsKt.joinToString$default(r119, " · ", null, null, 0, null, null, 62, null);
        if (r123 == null) goto L42;
    L67:
        if (r118 == null) goto L78;
        ArrayList r124 = new ArrayList();
        Iterator r125 = r118.iterator();
    L70:
        if (r125.hasNext() == false) goto L77;
        Object r126 = r125.next();
        if (((String) r126).length() <= 0) goto L74;
        boolean r127 = true;
    L75:
        if (r127 == false) goto L70;
        r124.add(r126);
        goto L70
    L74:
        r127 = false;
        goto L75
    L77:
        r108 = CollectionsKt.joinToString$default(r124, "｜", null, null, 0, null, null, 62, null);
    L78:
        if (r108 == null) goto L82;
        r105 = r108;
    L82:
        if (r123.length() != 0) goto L84;
        boolean r128 = true;
    L86:
        if (r128 == false) goto L88;
        r100.f291527d.setVisibility(8);
        r100.f291527d.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        r100.f291527d.setCompoundDrawablePadding(0);
    L96:
        if (r105.length() == 0) goto L99;
        r106 = false;
    L99:
        if (r106 == false) goto L101;
        r100.f291528e.setVisibility(8);
    L102:
        r100.T3(r101, r102);
        r100.itemView.setOnLongClickListener(new s(r100, r101));
        return;
    L101:
        r100.f291528e.setVisibility(0);
        r100.f291528e.setText(r105);
        goto L102
    L88:
        r100.f291527d.setVisibility(0);
        r100.f291527d.setText(r123);
        if (r101.h() != 3) goto L91;
        int r129 = R.drawable.larus_ic_dora_imu;
    L92:
        if (r129 == 0) goto L94;
        r100.f291527d.setCompoundDrawablesRelativeWithIntrinsicBounds(r129, 0, 0, 0);
        AppCompatTextView r130 = r100.f291527d;
        Resources r131 = r130.getResources();
        r130.setCompoundDrawablePadding((int) ((WindowDisplayMetricsOverride.apply(r131, r131.getDisplayMetrics()).density * 4.0f) + 0.5f));
        goto L96
    L94:
        r100.f291527d.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        r100.f291527d.setCompoundDrawablePadding(0);
        goto L96
    L91:
        r129 = 0;
        goto L92
    L84:
        r128 = false;
    L42:
        if (r114 == null) goto L53;
        ArrayList r132 = new ArrayList();
        Iterator r133 = r114.iterator();
    L45:
        if (r133.hasNext() == false) goto L52;
        Object r134 = r133.next();
        if (((String) r134).length() <= 0) goto L49;
        boolean r135 = true;
    L50:
        if (r135 == false) goto L45;
        r132.add(r134);
        goto L45
    L49:
        r135 = false;
        goto L50
    L52:
        r123 = CollectionsKt.joinToString$default(r132, " · ", null, null, 0, null, null, 62, null);
        goto L67
    L53:
        if (r116 == null) goto L64;
        ArrayList r136 = new ArrayList();
        Iterator r137 = r116.iterator();
    L56:
        if (r137.hasNext() == false) goto L63;
        Object r138 = r137.next();
        if (((String) r138).length() <= 0) goto L60;
        boolean r139 = true;
    L61:
        if (r139 == false) goto L56;
        r136.add(r138);
        goto L56
    L60:
        r139 = false;
        goto L61
    L63:
        r123 = CollectionsKt.joinToString$default(r136, "｜", null, null, 0, null, null, 62, null);
    L65:
        if (r123 != null) goto L67;
        r123 = "";
        goto L67
    L64:
        r123 = null;
    L29:
        r118 = null;
    L24:
        r116 = null;
    L19:
        r114 = null;
    L14:
        r112 = null;
        goto L15
    L8:
        r107 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_layout_item_ai_proactive_task, r100, false);
        int r111 = R.id.ai_proactive_head_down_calibration_action;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.ai_proactive_head_down_calibration_action)) == null) goto L23;
        r111 = R.id.ai_proactive_head_down_calibration_desc;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.ai_proactive_head_down_calibration_desc)) == null) goto L23;
        r111 = R.id.ai_proactive_head_down_calibration_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r101, R.id.ai_proactive_head_down_calibration_icon)) == null) goto L23;
        r111 = R.id.ai_proactive_item_bottom_gap;
        if (((Space) ViewBindings.findChildViewById(r101, R.id.ai_proactive_item_bottom_gap)) == null) goto L23;
        r111 = R.id.ai_proactive_item_desc_line1;
        AppCompatTextView r102 = (AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.ai_proactive_item_desc_line1);
        if (r102 == null) goto L23;
        r111 = R.id.ai_proactive_item_desc_line2;
        AppCompatTextView r103 = (AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.ai_proactive_item_desc_line2);
        if (r103 == null) goto L23;
        r111 = R.id.ai_proactive_item_switch;
        CustomSwitchCompat r104 = (CustomSwitchCompat) ViewBindings.findChildViewById(r101, R.id.ai_proactive_item_switch);
        if (r104 == null) goto L23;
        r111 = R.id.ai_proactive_item_title;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.ai_proactive_item_title);
        if (r105 == null) goto L23;
        r111 = R.id.ai_proactive_task_bottom_banner;
        ConstraintLayout r106 = (ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.ai_proactive_task_bottom_banner);
        if (r106 == null) goto L23;
        return new TaskViewHolder(new LarusLayoutItemAiProactiveTaskBinding((ConstraintLayout) r101, r102, r103, r104, r105, r106), this.f291522a);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r111)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        TaskViewHolder r103 = (TaskViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        boolean r104 = true;
        if ((!r102.isEmpty()) == false) goto L18;
        List r105 = r102;
        if ((r105 instanceof Collection) == true) goto L7;
    L9:
        Iterator r106 = r105.iterator();
    L11:
        if (r106.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(r106.next(), "payload_calibration_banner") == false) goto L11;
    L16:
        if (r104 == false) goto L18;
        r103.T3(getItem(r101), this.f291523b);
        return;
    L15:
        r104 = false;
        goto L16
    L7:
        if (r105.isEmpty() == false) goto L9;
    L18:
        super.onBindViewHolder(r103, r101, r102);
    }
}
