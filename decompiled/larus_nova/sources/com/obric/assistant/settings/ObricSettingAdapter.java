package com.obric.assistant.settings;

import android.app.Activity;
import android.os.SystemClock;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.oui.badge.OBadgeView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.tag.OTextTag;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001f B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/assistant/settings/ObricSettingAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/obric/assistant/settings/GroupUiModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "isObricOS", "", "lastClickTime", "", "", "", "lastDisabledToastTime", "setData", "", "newItems", "", "getItemViewType", "", "position", "isFirstRV", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "Companion", "GroupViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSettingAdapter extends ListAdapter<j, RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ObricSettingAdapter$Companion$diffCallback$1 f391720f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f391721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f391722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f391723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Long> f391724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f391725e;

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tJ\"\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001a\u0010!\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J2\u0010$\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J(\u0010'\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010)H\u0002J \u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010)H\u0002J\"\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010)2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010-\u001a\u0004\u0018\u00010,H\u0002J\u001a\u0010.\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020/H\u0002J\u0018\u00100\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u00061"}, d2 = {"Lcom/obric/assistant/settings/ObricSettingAdapter$GroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "activity", "Landroid/app/Activity;", "itemGroup", "Landroid/widget/LinearLayout;", "getItem", "Lkotlin/Function1;", "", "Lcom/obric/assistant/settings/GroupUiModel;", "<init>", "(Lcom/obric/assistant/settings/ObricSettingAdapter;Landroid/app/Activity;Landroid/widget/LinearLayout;Lkotlin/jvm/functions/Function1;)V", "getActivity", "()Landroid/app/Activity;", "getItemGroup", "()Landroid/widget/LinearLayout;", "getGetItem", "()Lkotlin/jvm/functions/Function1;", "bind", "", "group", "createSwitchView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/obric/assistant/settings/SwitchUiModel;", "index", "applySwitchAlpha", "itemView", "Lcom/obric/oui/lisitem/OCardListItem;", "enabled", "", "bindSubtitle", "subtitle", "", "bindSwitchInteraction", "endSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "bindDisabledSwitch", "showDisabledToast", "Lkotlin/Function0;", "showDisabledToastIfNeeded", "id", "", "disabledToastText", "createActionView", "Lcom/obric/assistant/settings/ActionUiModel;", "applyActionAlpha", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class GroupViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int f391726e = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f391727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinearLayout f391728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<Integer, j> f391729c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ObricSettingAdapter f391730d;

        public final Activity getActivity() {
            return this.f391727a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void U3(j r110) {
            Intrinsics.checkNotNullParameter(r110, "group");
            FLogger.f375446a.d("ObricSettingAdapter", "Binding group " + r110.f392084a + " with " + r110.f392085b.size() + " items");
            this.f391728b.removeAllViews();
            List<q0> r100 = r110.f392085b;
            ObricSettingAdapter r101 = this.f391730d;
            Iterator<T> r102 = r100.iterator();
            int r103 = 0;
        L4:
            if (r102.hasNext() == false) goto L274;
            Object r104 = r102.next();
            int r105 = r103 + 1;
            if (r103 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            q0 r106 = (q0) r104;
            if ((r106 instanceof g1) == false) goto L139;
            final LinearLayout r107 = this.f391728b;
            final g1 r108 = (g1) r106;
            View r111 = LayoutInflater.from(r107.getContext()).inflate(R.layout.item_obric_setting_action, r107, false);
            if ((r111 instanceof OCardListItem) == false) goto L13;
            OCardListItem r112 = (OCardListItem) r111;
        L14:
            if (r112 == null) goto L257;
            r112.setTag(r108.f392060a);
            r112.setCardType(0);
            r112.p(false);
            if (r108.f392066g == true) goto L37;
            String r113 = r108.f392068i;
            if (r113 != null) goto L20;
        L23:
            boolean r114 = true;
        L24:
            if (r114 == false) goto L37;
            if (r108.f392065f == true) goto L37;
            String r115 = r108.f392067h;
            if (r115 != null) goto L30;
        L33:
            boolean r116 = true;
        L34:
            if (r116 == false) goto L37;
            r112.setTitle(r108.f392061b);
            r112.s(true);
        L86:
            CharSequence r117 = r108.f392062c;
            if (r117 == null) goto L89;
            String r118 = r117.toString();
        L90:
            r112.setSubTitle(r118);
            if (r117 != null) goto L93;
        L96:
            boolean r119 = true;
        L97:
            r112.q(!r119);
            OTextView r120 = r112.getSubTitleView();
            r120.setText(r117);
            r120.setMaxLines(5);
            if ((r117 instanceof Spanned) == false) goto L100;
            MovementMethod r121 = LinkMovementMethod.getInstance();
        L101:
            r120.setMovementMethod(r121);
            r120.setHighlightColor(0);
            if (r108.f392069j == false) goto L104;
            boolean r122 = true;
            r112.setDefaultCustomEndView(1);
        L105:
            r112.m(r122);
            r112.r(false);
            FLogger.f375446a.d("ObricSettingAdapter", "createSwitchView " + r108.f392061b + ",isChecked" + r108.f392063d + ",enabled" + r108.f392069j);
            OSwitch r123 = r112.getEndSwitch();
            final String r124 = r108.f392070k;
            if (r124 != null) goto L108;
        L116:
            final z r125 = 0;
        L118:
            if (r108.f392069j == true) goto L131;
            View r109 = r112.getCustomEndView();
            if ((r109 instanceof ViewGroup) == false) goto L122;
            ViewGroup r126 = (ViewGroup) r109;
        L123:
            if (r126 == null) goto L130;
            OSwitch r127 = (OSwitch) r126.findViewById(R.id.disabled_switch);
            if (r127 == null) goto L127;
            r127.setOnCheckedChangeListener(null);
            r127.setEnabled(false);
            r127.setChecked(r108.f392063d);
        L127:
            View r128 = r126.findViewById(R.id.disabled_switch_container);
            if (r128 == null) goto L130;
            r128.setOnClickListener(new a0(this, r108, r125));
        L130:
            T3(r112, false);
            goto L257
        L122:
            r126 = null;
            goto L123
        L131:
            if (r123 == null) goto L133;
            r123.setOnCheckedChangeListener(null);
        L133:
            if (r123 == null) goto L135;
            r123.setChecked(r108.f392063d);
        L135:
            T3(r112, true);
            b0 r129 = new b0(this.f391730d, r108, this, r103);
            if (r123 == null) goto L257;
            r123.setOnCheckedChangeListener(r129);
            goto L257
        L108:
            if (r124.length() <= 0) goto L110;
            boolean r130 = true;
        L111:
            if (r130 == true) goto L114;
            r124 = null;
        L114:
            if (r124 == null) goto L116;
            r125 = new z(this, r107, r124);
            goto L118
        L110:
            r130 = false;
            goto L111
        L104:
            r122 = true;
            r112.setCustomEndView(R.layout.item_obric_setting_disabled_switch);
            goto L105
        L100:
            r121 = null;
            goto L101
        L93:
            if (r117.length() == 0) goto L96;
            r119 = false;
            goto L97
        L89:
            r118 = null;
            goto L90
        L30:
            if (r115.length() == 0) goto L33;
            r116 = false;
            goto L34
        L20:
            if (r113.length() == 0) goto L23;
            r114 = false;
        L37:
            View r131 = r112.c();
            if ((r131 instanceof ViewGroup) == false) goto L40;
            ViewGroup r132 = (ViewGroup) r131;
        L41:
            if (r132 != null) goto L46;
            r112.i(R.layout.item_obric_setting_custom_title, false);
            View r133 = r112.c();
            if ((r133 instanceof ViewGroup) == false) goto L45;
            r132 = (ViewGroup) r133;
            goto L46
        L45:
            r132 = null;
        L46:
            if (r132 == null) goto L85;
            ((OTextView) r132.findViewById(R.id.custom_title_text)).setText(r108.f392061b);
            OTextTag r134 = (OTextTag) r132.findViewById(R.id.custom_title_new_tag);
            if (r134 == null) goto L59;
            String r135 = r108.f392067h;
            if (r135 != null) goto L52;
        L55:
            boolean r136 = true;
        L56:
            if (r136 == true) goto L58;
            r134.setVisibility(0);
            r134.setText(r108.f392067h);
            goto L59
        L58:
            r134.setVisibility(8);
            goto L59
        L52:
            if (r135.length() == 0) goto L55;
            r136 = false;
        L59:
            final ImageView r137 = (ImageView) r132.findViewById(R.id.custom_title_tips_icon);
            if (r137 == null) goto L71;
            String r138 = r108.f392068i;
            if (r138 != null) goto L64;
        L67:
            boolean r139 = true;
        L68:
            if (r139 == true) goto L70;
            r137.setVisibility(0);
            com.larus.utils.e1.d(r137, new y(this, r108, r137));
            goto L71
        L70:
            r137.setVisibility(8);
            goto L71
        L64:
            if (r138.length() == 0) goto L67;
            r139 = false;
        L71:
            ImageView r140 = (ImageView) r132.findViewById(R.id.custom_title_beta_icon);
            if (r140 != null) goto L74;
        L78:
            OBadgeView r141 = (OBadgeView) r132.findViewById(R.id.custom_title_red_point);
            if (r141 == null) goto L85;
            if (r108.f392065f == false) goto L83;
            int r142 = 0;
        L84:
            r141.setVisibility(r142);
            goto L85
        L83:
            r142 = 8;
            goto L84
        L74:
            if (r108.f392066g == false) goto L76;
            int r143 = 0;
        L77:
            r140.setVisibility(r143);
            goto L78
        L76:
            r143 = 8;
        L85:
            r112.s(false);
            goto L86
        L40:
            r132 = null;
        L257:
            if (r112 == null) goto L271;
            if (r110.f392085b.size() != 1) goto L261;
            int r144 = 0;
        L267:
            OCardListItem.h(r112, r144);
            if (r101.f391722b == true) goto L270;
            rda.a.a(r112, r144);
        L270:
            this.f391728b.addView(r112);
            goto L271
        L261:
            if (r103 != 0) goto L264;
            r144 = 1;
            goto L267
        L264:
            if (r103 != (r110.f392085b.size() - 1)) goto L266;
            r144 = 3;
            goto L267
        L266:
            r144 = 2;
        L271:
            r103 = r105;
            goto L4
        L13:
            r112 = null;
            goto L14
        L139:
            if ((r106 instanceof com.obric.assistant.settings.a) == false) goto L273;
            final LinearLayout r145 = this.f391728b;
            final com.obric.assistant.settings.a r146 = (com.obric.assistant.settings.a) r106;
            View r147 = LayoutInflater.from(r145.getContext()).inflate(R.layout.item_obric_setting_action, r145, false);
            if ((r147 instanceof OCardListItem) == false) goto L143;
            OCardListItem r148 = (OCardListItem) r147;
        L144:
            if (r148 == null) goto L256;
            r148.setTag(r146.f391771a);
            r148.setCardType(0);
            r148.p(false);
            r148.setEnabled(true);
            if (r146.f391777g == false) goto L171;
            View r149 = r148.c();
            if ((r149 instanceof ViewGroup) == false) goto L150;
            ViewGroup r150 = (ViewGroup) r149;
        L151:
            if (r150 != null) goto L156;
            r148.i(R.layout.item_obric_setting_custom_title, false);
            View r151 = r148.c();
            if ((r151 instanceof ViewGroup) == false) goto L155;
            r150 = (ViewGroup) r151;
            goto L156
        L155:
            r150 = null;
        L156:
            if (r150 == null) goto L170;
            ((OTextView) r150.findViewById(R.id.custom_title_text)).setText(r146.f391772b);
            ImageView r152 = (ImageView) r150.findViewById(R.id.custom_title_tips_icon);
            if (r152 == null) goto L160;
            r152.setVisibility(8);
        L160:
            ImageView r153 = (ImageView) r150.findViewById(R.id.custom_title_beta_icon);
            if (r153 != null) goto L163;
        L167:
            OBadgeView r154 = (OBadgeView) r150.findViewById(R.id.custom_title_red_point);
            if (r154 == null) goto L170;
            r154.setVisibility(8);
            goto L170
        L163:
            if (r146.f391777g == false) goto L165;
            int r155 = 0;
        L166:
            r153.setVisibility(r155);
            goto L167
        L165:
            r155 = 8;
        L170:
            r148.s(false);
            boolean r156 = true;
        L172:
            String r157 = r146.f391776f;
            if (r157 != null) goto L175;
        L180:
            boolean r158 = false;
        L182:
            if (r158 == true) goto L184;
            boolean r159 = true;
            r148.m(false);
        L196:
            r148.setSubTitle(r146.f391773c);
            r148.setDefaultTailIcon(0);
            r148.getSubTitleView().setMaxLines(5);
            r148.r(r159);
            String r160 = r146.f391773c;
            if (r160 != null) goto L199;
        L204:
            boolean r161 = false;
        L205:
            r148.q(r161);
            if (r146.f391778h == false) goto L208;
            float r162 = 1.0f;
        L209:
            r148.getTitleView().setAlpha(r162);
            r148.getSubTitleView().setAlpha(r162);
            View r163 = r148.c();
            if ((r163 instanceof ViewGroup) == false) goto L212;
            ViewGroup r164 = (ViewGroup) r163;
        L213:
            if (r164 == null) goto L229;
            OTextView r165 = (OTextView) r164.findViewById(R.id.custom_title_text);
            if (r165 == null) goto L217;
            r165.setAlpha(r162);
        L217:
            OTextTag r166 = (OTextTag) r164.findViewById(R.id.custom_title_new_tag);
            if (r166 == null) goto L220;
            r166.setAlpha(r162);
        L220:
            ImageView r167 = (ImageView) r164.findViewById(R.id.custom_title_tips_icon);
            if (r167 == null) goto L223;
            r167.setAlpha(r162);
        L223:
            ImageView r168 = (ImageView) r164.findViewById(R.id.custom_title_beta_icon);
            if (r168 == null) goto L226;
            r168.setAlpha(r162);
        L226:
            OBadgeView r169 = (OBadgeView) r164.findViewById(R.id.custom_title_red_point);
            if (r169 == null) goto L229;
            r169.setAlpha(r162);
        L229:
            ImageView r170 = (ImageView) r148.findViewById(R.id.tail_icon);
            if (r170 == null) goto L232;
            r170.setAlpha(r162);
        L232:
            View r171 = r148.getCustomEndView();
            if ((r171 instanceof ViewGroup) == false) goto L235;
            ViewGroup r172 = (ViewGroup) r171;
        L236:
            if (r172 == null) goto L243;
            OTextView r173 = (OTextView) r172.findViewById(R.id.custom_end_detail_text);
            if (r173 == null) goto L240;
            r173.setAlpha(r162);
        L240:
            OBadgeView r174 = (OBadgeView) r172.findViewById(R.id.custom_end_red_point);
            if (r174 == null) goto L243;
            r174.setAlpha(r162);
        L243:
            final String r175 = r146.f391779i;
            if (r175 != null) goto L246;
        L254:
            final z r176 = 0;
        L255:
            r148.setOnContentClickListener(new x(r146, this, r176));
            goto L256
        L246:
            if (r175.length() <= 0) goto L248;
            boolean r177 = true;
        L249:
            if (r177 == true) goto L252;
            r175 = null;
        L252:
            if (r175 == null) goto L254;
            r176 = new z(this, r145, r175);
            goto L255
        L248:
            r177 = false;
            goto L249
        L235:
            r172 = null;
            goto L236
        L212:
            r164 = null;
            goto L213
        L208:
            r162 = 0.3f;
            goto L209
        L199:
            if (r160.length() <= 0) goto L201;
            boolean r178 = true;
        L202:
            if (r178 != r159) goto L204;
            r161 = true;
            goto L205
        L201:
            r178 = false;
            goto L202
        L184:
            if (r146.f391775e == false) goto L194;
            r148.setCustomEndView(R.layout.item_obric_setting_custom_end_detail);
            View r179 = r148.getCustomEndView();
            if ((r179 instanceof ViewGroup) == false) goto L188;
            ViewGroup r180 = (ViewGroup) r179;
        L189:
            if (r180 == null) goto L193;
            ((OTextView) r180.findViewById(R.id.custom_end_detail_text)).setText(r146.f391776f);
            OBadgeView r181 = (OBadgeView) r180.findViewById(R.id.custom_end_red_point);
            if (r181 == null) goto L193;
            r181.setVisibility(0);
        L193:
            r159 = true;
            r148.m(true);
            goto L196
        L188:
            r180 = null;
            goto L189
        L194:
            r159 = true;
            r148.setDefaultCustomEndView(3);
            r148.k(r146.f391776f, -1);
            r148.m(true);
            goto L196
        L175:
            if (r157.length() <= 0) goto L177;
            boolean r182 = true;
        L178:
            if (r182 != r156) goto L180;
            r158 = true;
            goto L182
        L177:
            r182 = false;
            goto L178
        L150:
            r150 = null;
            goto L151
        L171:
            r148.setTitle(r146.f391772b);
            r156 = true;
            r148.s(true);
        L256:
            r112 = r148;
            goto L257
        L143:
            r148 = null;
            goto L144
        L273:
            throw new NoWhenBranchMatchedException();
        }

        public static void T3(OCardListItem r100, boolean r101) {
            if (r101 == false) goto L4;
            float r102 = 1.0f;
        L5:
            r100.getTitleView().setAlpha(r102);
            r100.getSubTitleView().setAlpha(r102);
            View r103 = r100.c();
            if ((r103 instanceof ViewGroup) == false) goto L8;
            ViewGroup r104 = (ViewGroup) r103;
        L9:
            if (r104 == null) goto L26;
            OTextView r105 = (OTextView) r104.findViewById(R.id.custom_title_text);
            if (r105 == null) goto L13;
            r105.setAlpha(r102);
        L13:
            OTextTag r106 = (OTextTag) r104.findViewById(R.id.custom_title_new_tag);
            if (r106 == null) goto L16;
            r106.setAlpha(r102);
        L16:
            ImageView r107 = (ImageView) r104.findViewById(R.id.custom_title_tips_icon);
            if (r107 == null) goto L19;
            r107.setAlpha(r102);
        L19:
            ImageView r108 = (ImageView) r104.findViewById(R.id.custom_title_beta_icon);
            if (r108 == null) goto L22;
            r108.setAlpha(r102);
        L22:
            OBadgeView r109 = (OBadgeView) r104.findViewById(R.id.custom_title_red_point);
            if (r109 == null) goto L27;
            r109.setAlpha(r102);
            return;
        L27:
            return;
        L26:
            return;
        L8:
            r104 = null;
            goto L9
        L4:
            r102 = 0.3f;
            goto L5
        }

        public final void V3(String r100, Function0<Unit> r101) {
            long r102 = SystemClock.elapsedRealtime();
            Long r103 = (Long) ((LinkedHashMap) this.f391730d.f391724d).get(r100);
            if (r103 == null) goto L5;
            long r104 = r103.longValue();
        L7:
            if ((r102 - r104) < 3000) goto L12;
            Long r105 = Long.valueOf(r102);
            this.f391730d.f391724d.put(r100, r105);
            if (r101 == null) goto L13;
            r101.invoke();
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r104 = 0;
            goto L7
        }

        public GroupViewHolder(ObricSettingAdapter r100, Activity r101, LinearLayout r102, w r103) {
            Intrinsics.checkNotNullParameter(r102, "itemGroup");
            Intrinsics.checkNotNullParameter(r103, "getItem");
            this.f391730d = r100;
            super(r102);
            this.f391727a = r101;
            this.f391728b = r102;
            this.f391729c = r103;
        }
    }

    public static final class a {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.settings.ObricSettingAdapter$Companion$diffCallback$1] */
    static {
        f391720f = new ObricSettingAdapter$Companion$diffCallback$1();
    }

    public final Activity getActivity() {
        return this.f391721a;
    }

    public ObricSettingAdapter(FragmentActivity r100) {
        super(f391720f);
        this.f391721a = r100;
        this.f391722b = t9a.b.a().b();
        this.f391723c = new LinkedHashMap();
        this.f391724d = new LinkedHashMap();
        this.f391725e = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        j r102 = getItem(r101);
        FLogger.f375446a.d("ObricSettingAdapter", "onBindViewHolder position=" + r101 + ", group=" + r102.f392084a);
        if ((r100 instanceof GroupViewHolder) == false) goto L14;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L6
        ((GroupViewHolder) r100).U3(r102);     // Catch: Throwable -> L6
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L9:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L15;
        FLogger.f375446a.d("ObricSettingAdapter", "onBindViewHolder position=" + r101 + ", group=" + r102.f392084a);
        return;
    L15:
        return;
    L6:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.obric.assistant.settings.w] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        FLogger.f375446a.d("ObricSettingAdapter", "onCreateViewHolder viewType=" + r101);
        LinearLayout r102 = new LinearLayout(r100.getContext());
        if (this.f391722b == true) goto L5;
        int r103 = 2;
    L6:
        r102.setShowDividers(r103);
        RecyclerView.LayoutParams r104 = new RecyclerView.LayoutParams(-1, -2);
        if (this.f391725e == true) goto L9;
    L11:
        int r105 = i5.q();
    L12:
        ((ViewGroup.MarginLayoutParams) r104).topMargin = r105;
        this.f391725e = false;
        r102.setLayoutParams(r104);
        r102.setOrientation(1);
        return new GroupViewHolder(this, this.f391721a, r102, new w(this));
    L9:
        if (this.f391722b == true) goto L11;
        r105 = i5.A();
        goto L12
    L5:
        r103 = 0;
        goto L6
    }
}
