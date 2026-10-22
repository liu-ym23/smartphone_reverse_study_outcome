package com.larus.chat.job.impl.page.edit;

import android.graphics.Typeface;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.larus.chat.job.impl.databinding.LarusChatJobEditOptionsItemBinding;
import com.larus.chat.job.impl.databinding.LarusChatJobEditTextItemBinding;
import com.larus.nova.R;
import com.lynx.textra.PlatformFontCaps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cBE\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/chat/job/impl/page/edit/ChatJobEditAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditListItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onTextChanged", "Lkotlin/Function2;", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditTextKey;", "", "", "onOptionClick", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditOptionKey;", "Landroid/view/View;", "readOnly", "", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Z)V", "textInputSelections", "", "Lcom/larus/chat/job/impl/page/edit/TextInputSelection;", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobEditAdapter extends ListAdapter<z, RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ChatJobEditAdapter$Companion$DIFF_CALLBACK$1 f325161e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<ChatJobEditTextKey, String, Unit> f325162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<ChatJobEditOptionKey, View, Unit> f325163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f325164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<ChatJobEditTextKey, q1> f325165d;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.chat.job.impl.page.edit.ChatJobEditAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        f325161e = new ChatJobEditAdapter$Companion$DIFF_CALLBACK$1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        z r101 = getItem(r100);
        if ((r101 instanceof z.b) == false) goto L6;
        return 1;
    L6:
        if ((r101 instanceof z.a) == false) goto L10;
        return 2;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [com.larus.chat.job.impl.page.edit.e, java.lang.Object] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        final z r112 = getItem(r111);
        if ((r112 instanceof z.b) == false) goto L77;
        if ((r110 instanceof u1) == false) goto L7;
        u1 r113 = (u1) r110;
    L8:
        if (r113 != null) goto L10;
        return;
    L10:
        z.b r100 = (z.b) r112;
        boolean r101 = this.f325164c;
        ?? r102 = new e(this, r112);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "onTextChanged");
        FrameLayout r114 = r113.f325345a.f325047a;
        int r103 = gz8.g.f483423a;
        r114.setBackground(gz8.g.a(r114.getContext()));
        FrameLayout r115 = r113.f325345a.f325047a;
        ViewGroup.LayoutParams r104 = r115.getLayoutParams();
        if (r104 == null) goto L75;
        FrameLayout r105 = r113.f325345a.f325047a;
        boolean r106 = r100.f325366c;
        if (r106 == false) goto L15;
        int r107 = R.attr.larus_dp_152;
    L16:
        if (r106 == false) goto L18;
        int r108 = R.dimen.larus_dp_152;
    L19:
        r104.height = r105.getResources().getDimensionPixelSize(v19.c.b(r107, r105.getContext(), r108));
        r115.setLayoutParams(r104);
        r113.f325345a.f325048b.removeTextChangedListener(r113.f325348d);
        final EditText r116 = r113.f325345a.f325048b;
        boolean r109 = r116.isFocused();
        int r117 = r116.getSelectionStart();
        int r118 = r116.getSelectionEnd();
        Intrinsics.checkNotNull(r116);
        boolean r119 = r100.f325366c;
        if (Intrinsics.areEqual(r113.f325349e, Boolean.valueOf(r119)) == true) goto L39;
        r116.setSingleLine(!r119);
        r116.setMinLines(1);
        int r120 = 6;
        if (r119 == false) goto L25;
        int r121 = 6;
    L26:
        r116.setMaxLines(r121);
        if (r119 == false) goto L29;
        int r122 = 131073;
    L30:
        r116.setInputType(r122);
        if (r119 == false) goto L33;
        r120 = 1;
    L33:
        r116.setImeOptions(r120);
        r116.setVerticalScrollBarEnabled(r119);
        r116.setHorizontallyScrolling(false);
        if (r119 == true) goto L36;
        r113.f325345a.f325048b.setOnTouchListener(null);
    L37:
        r113.f325349e = Boolean.valueOf(r119);
        goto L39
    L36:
        r113.f325345a.f325048b.setOnTouchListener(new s1());
        goto L37
    L29:
        r122 = 16385;
        goto L30
    L25:
        r121 = 1;
    L39:
        if (r100.f325364a != ChatJobEditTextKey.TITLE) goto L41;
        String r123 = "sans-serif-medium";
    L42:
        r116.setTypeface(Typeface.create(r123, 0));
        Editable r124 = r116.getText();
        if (r124 == null) goto L45;
        String r125 = r124.toString();
    L46:
        boolean r126 = true ^ Intrinsics.areEqual(r125, r100.f325365b);
        q1 r127 = r113.f325346b.invoke(r100.f325364a);
        if (r127 == null) goto L49;
        r117 = r127.f325327a;
    L49:
        if (r127 == null) goto L51;
        r118 = r127.f325328b;
    L51:
        if (r126 == false) goto L53;
        r116.setText(r100.f325365b);
    L53:
        if (r109 == true) goto L58;
        if (r127 != null) goto L58;
        if (r126 == false) goto L69;
        r116.setSelection(0);
        r116.scrollTo(0, 0);
        r116.post(new r1(r116));
    L69:
        if (r101 == false) goto L71;
        r116.setKeyListener(null);
        r116.setFocusable(false);
        r116.setFocusableInTouchMode(false);
        r116.setCursorVisible(false);
        r116.setLongClickable(false);
        r116.setTextColor(gz8.g.c(r116.getContext()));
    L71:
        if (r101 == true) goto L138;
        t1 r128 = new t1(r113, r100, r102);
        r113.f325345a.f325048b.addTextChangedListener(r128);
        r113.f325348d = r128;
        return;
    L138:
        return;
    L58:
        if (r117 < 0) goto L69;
        if (r118 < 0) goto L69;
        Editable r129 = r116.getText();
        if (r129 == null) goto L64;
        int r130 = r129.length();
    L65:
        int r131 = RangesKt.coerceIn(r117, 0, r130);
        int r132 = RangesKt.coerceIn(r118, 0, r130);
        if (r131 > r132) goto L68;
        r116.setSelection(r131, r132);
        goto L69
    L68:
        r116.setSelection(r132, r131);
        goto L69
    L64:
        r130 = 0;
        goto L65
    L45:
        r125 = null;
        goto L46
    L41:
        r123 = PlatformFontCaps.DEFAULT_FAMILY_NAME;
        goto L42
    L18:
        r108 = R.dimen.larus_dp_56;
        goto L19
    L15:
        r107 = R.attr.larus_dp_56;
        goto L16
    L75:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L7:
        r113 = null;
        goto L8
    L77:
        if ((r112 instanceof z.a) == false) goto L132;
        if ((r110 instanceof o1) == false) goto L81;
        o1 r133 = (o1) r110;
    L82:
        if (r133 == null) goto L137;
        z.a r134 = (z.a) r112;
        final Function2<ChatJobEditOptionKey, View, Unit> r135 = this.f325163b;
        Intrinsics.checkNotNullParameter(r134, "section");
        Intrinsics.checkNotNullParameter(r135, "onOptionClick");
        LinearLayout r136 = r133.f325310a.f325022a;
        int r137 = gz8.g.f483423a;
        r136.setBackground(gz8.g.a(r136.getContext()));
        Iterator<T> r138 = r133.f325311b.iterator();
        int r139 = 0;
    L85:
        if (r138.hasNext() == false) goto L139;
        Object r140 = r138.next();
        int r141 = r139 + 1;
        if (r139 >= 0) goto L89;
        CollectionsKt.throwIndexOverflow();
    L89:
        final o1.b r142 = (o1.b) r140;
        final a0 r143 = (a0) CollectionsKt.getOrNull(r134.f325363b, r139);
        if (r139 != CollectionsKt.getLastIndex(r134.f325363b)) goto L92;
        boolean r144 = true;
    L93:
        if (r143 == null) goto L95;
        boolean r145 = true;
    L96:
        View r146 = r142.f325312a;
        int r147 = 8;
        if (r145 == false) goto L99;
        int r148 = 0;
    L100:
        r146.setVisibility(r148);
        View r149 = r142.f325315d;
        if (r149 == null) goto L110;
        if (r145 == false) goto L105;
        if (r144 == true) goto L105;
        boolean r150 = true;
    L106:
        if (r150 == false) goto L108;
        int r151 = 0;
    L109:
        r149.setVisibility(r151);
        goto L110
    L108:
        r151 = 8;
    L105:
        r150 = false;
    L110:
        if (r143 == null) goto L128;
        r142.f325313b.setText(r143.f325226b);
        r142.f325314c.setText(r143.f325227c);
        r142.f325312a.setEnabled(r143.f325228d);
        TextView r152 = r142.f325313b;
        float r153 = 0.34f;
        if (r143.f325228d == false) goto L114;
        float r154 = 1.0f;
    L115:
        r152.setAlpha(r154);
        TextView r155 = r142.f325314c;
        if (r143.f325228d == false) goto L118;
        r153 = 1.0f;
    L118:
        r155.setAlpha(r153);
        View r156 = r142.f325316e;
        if (r156 == null) goto L125;
        if (r143.f325229e == false) goto L123;
        r147 = 0;
    L123:
        r156.setVisibility(r147);
    L125:
        if (r143.f325229e == false) goto L127;
        r142.f325312a.setOnClickListener(new n1(r135, r143, r142));
    L129:
        r139 = r141;
        goto L85
    L127:
        r142.f325312a.setOnClickListener(null);
        goto L129
    L114:
        r154 = 0.34f;
        goto L115
    L128:
        r142.f325312a.setOnClickListener(null);
        goto L129
    L99:
        r148 = 8;
        goto L100
    L95:
        r145 = false;
        goto L96
    L92:
        r144 = false;
        goto L93
    L139:
        return;
    L137:
        return;
    L81:
        r133 = null;
        goto L82
    L132:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [com.larus.chat.job.impl.page.edit.f] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.chat.job.impl.page.edit.g] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r310, int r311) {
        Intrinsics.checkNotNullParameter(r310, "parent");
        LayoutInflater r100 = LayoutInflater.from(r310.getContext());
        if (r311 != 1) goto L9;
        View r101 = r100.inflate(R.layout.larus_chat_job_edit_text_item, r310, false);
        EditText r102 = (EditText) ViewBindings.findChildViewById(r101, R.id.larus_chat_job_edit_text_input);
        if (r102 == null) goto L8;
        RecyclerView.ViewHolder r103 = new u1(new LarusChatJobEditTextItemBinding((FrameLayout) r101, r102), new f(this), new g(this));
    L58:
        return r103;
    L8:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(R.id.larus_chat_job_edit_text_input)));
    L9:
        View r104 = r100.inflate(R.layout.larus_chat_job_edit_options_item, r310, false);
        int r105 = R.id.larus_chat_job_edit_environment_arrow;
        AppCompatImageView r106 = (AppCompatImageView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_environment_arrow);
        if (r106 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_environment_divider;
        View r107 = ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_environment_divider);
        if (r107 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_environment_label;
        TextView r110 = (TextView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_environment_label);
        if (r110 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_environment_row;
        ConstraintLayout r111 = (ConstraintLayout) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_environment_row);
        if (r111 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_environment_value;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_environment_value);
        if (r112 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_model_arrow;
        AppCompatImageView r113 = (AppCompatImageView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_model_arrow);
        if (r113 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_model_divider;
        View r114 = ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_model_divider);
        if (r114 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_model_label;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_model_label);
        if (r115 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_model_row;
        ConstraintLayout r116 = (ConstraintLayout) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_model_row);
        if (r116 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_model_value;
        TextView r117 = (TextView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_model_value);
        if (r117 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_project_arrow;
        AppCompatImageView r118 = (AppCompatImageView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_project_arrow);
        if (r118 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_project_label;
        TextView r119 = (TextView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_project_label);
        if (r119 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_project_row;
        ConstraintLayout r210 = (ConstraintLayout) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_project_row);
        if (r210 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_project_value;
        TextView r211 = (TextView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_project_value);
        if (r211 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_repeat_arrow;
        AppCompatImageView r212 = (AppCompatImageView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_repeat_arrow);
        if (r212 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_repeat_divider;
        View r213 = ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_repeat_divider);
        if (r213 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_repeat_label;
        TextView r214 = (TextView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_repeat_label);
        if (r214 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_repeat_row;
        ConstraintLayout r215 = (ConstraintLayout) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_repeat_row);
        if (r215 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_repeat_value;
        TextView r216 = (TextView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_repeat_value);
        if (r216 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_run_time_arrow;
        AppCompatImageView r217 = (AppCompatImageView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_run_time_arrow);
        if (r217 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_run_time_divider;
        View r218 = ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_run_time_divider);
        if (r218 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_run_time_label;
        TextView r219 = (TextView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_run_time_label);
        if (r219 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_run_time_row;
        ConstraintLayout r312 = (ConstraintLayout) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_run_time_row);
        if (r312 == null) goto L60;
        r105 = R.id.larus_chat_job_edit_run_time_value;
        TextView r313 = (TextView) ViewBindings.findChildViewById(r104, R.id.larus_chat_job_edit_run_time_value);
        if (r313 == null) goto L60;
        r103 = new o1(new LarusChatJobEditOptionsItemBinding((LinearLayout) r104, r106, r107, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r312, r313), this.f325164c);
    L60:
        throw new NullPointerException("Missing required view with ID: ".concat(r104.getResources().getResourceName(r105)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatJobEditAdapter(Function2<? super ChatJobEditTextKey, ? super String, Unit> r100, Function2<? super ChatJobEditOptionKey, ? super View, Unit> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "onTextChanged");
        Intrinsics.checkNotNullParameter(r101, "onOptionClick");
        super(f325161e);
        this.f325162a = r100;
        this.f325163b = r101;
        this.f325164c = r102;
        this.f325165d = new LinkedHashMap();
    }
}
