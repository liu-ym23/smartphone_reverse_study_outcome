package com.bytedance.ee.bear.bitable.fieldedit.view.edit.extendfield;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendConfigItem;
import com.bytedance.ee.bear.bitable.common.widgets.SyncIconImageView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0016\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldListView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onItemListener", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldListView$OnItemListener;", "getOnItemListener", "()Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldListView$OnItemListener;", "setOnItemListener", "(Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldListView$OnItemListener;)V", "setData", "", "data", "", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldListView$ExtendFieldCheckModel;", "ExtendFieldCheckModel", "OnItemListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtendFieldListView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f211357a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FieldExtendConfigItem f211358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Boolean f211359b;

        public a(FieldExtendConfigItem r100, Boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f211358a = r100;
            this.f211359b = r101;
        }
    }

    public static abstract class b {
        public b() {
        }

        public void a(UDCheckBox r100, a r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "buttonView");
            Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        }

        public void b(UDCheckBox r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "buttonView");
            Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        }

        public abstract void c(View r100, a r101);
    }

    public static final class c implements UDCheckBox.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExtendFieldListView f211360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f211361b;

        public c(ExtendFieldListView r100, a r101) {
            this.f211360a = r100;
            this.f211361b = r101;
        }

        @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
        public final void a(UDCheckBox r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "buttonView");
            b r102 = this.f211360a.getOnItemListener();
            if (r102 == null) goto L6;
            r102.a(r100, this.f211361b, r101);
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExtendFieldListView f211362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f211363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f211364c;

        public d(ExtendFieldListView r100, View r101, a r102) {
            this.f211362a = r100;
            this.f211363b = r101;
            this.f211364c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f211362a.getOnItemListener();
            if (r101 == null) goto L6;
            r101.b((UDCheckBox) this.f211363b.findViewById(R.id.checkBox), this.f211364c);
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExtendFieldListView f211365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f211366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f211367c;

        public e(ExtendFieldListView r100, View r101, a r102) {
            this.f211365a = r100;
            this.f211366b = r101;
            this.f211367c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f211365a.getOnItemListener();
            if (r101 == null) goto L6;
            View r102 = this.f211366b;
            Intrinsics.checkNotNull(r102);
            r101.c(r102, this.f211367c);
            return;
        }
    }

    public final b getOnItemListener() {
        return this.f211357a;
    }

    public ExtendFieldListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setOrientation(1);
    }

    public final void setData(List<a> r110) {
        removeAllViews();
        View r100 = null;
        if (r110 == null) goto L30;
        Iterator<T> r101 = r110.iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L30;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        a r105 = (a) r103;
        View r106 = LayoutInflater.from(getContext()).inflate(R.layout.bitable_field_edit_property_extend_item_view, this, false);
        if (r102 != 0) goto L17;
        if (r110.size() != 1) goto L15;
        ((LinearLayout) r106.findViewById(R.id.container)).setBackgroundResource(R.drawable.facade_round_around_xl);
    L19:
        View r107 = r106.findViewById(R.id.divider);
        ((SyncIconImageView) r106.findViewById(R.id.icon)).setImageResource(r105.f211358a.getFieldCompositeType().getIcon());
        ((SyncIconImageView) r106.findViewById(R.id.icon)).setSyncIconVisible(true);
        ((TextView) r106.findViewById(R.id.title)).setText(r105.f211358a.getName());
        if (r105.f211359b != null) goto L25;
        ((UDCheckBox) r106.findViewById(R.id.checkBox)).setVisibility(8);
        if (r105.f211358a.isChecked() == false) goto L24;
        ((SyncIconImageView) r106.findViewById(R.id.icon)).setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(r106.getContext(), R.color.text_disabled)));
        ((TextView) r106.findViewById(R.id.title)).setTextColor(ContextCompat.getColor(r106.getContext(), R.color.text_disabled));
    L29:
        ((LinearLayout) r106.findViewById(R.id.container)).setOnClickListener(new e(this, r106, r105));
        addView(r106);
        r100 = r107;
        r102 = r104;
        goto L6
    L24:
        ((SyncIconImageView) r106.findViewById(R.id.icon)).setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(r106.getContext(), R.color.icon_n1)));
        ((TextView) r106.findViewById(R.id.title)).setTextColor(ContextCompat.getColor(r106.getContext(), R.color.text_title));
        goto L29
    L25:
        ((UDCheckBox) r106.findViewById(R.id.checkBox)).setVisibility(0);
        ((UDCheckBox) r106.findViewById(R.id.checkBox)).setChecked(r105.f211358a.isChecked());
        if (r105.f211359b.booleanValue() == false) goto L28;
        ((UDCheckBox) r106.findViewById(R.id.checkBox)).setEnabled(true);
        ((UDCheckBox) r106.findViewById(R.id.checkBox)).setOnCheckedChangeListener(new c(this, r105));
        goto L29
    L28:
        ((UDCheckBox) r106.findViewById(R.id.checkBox)).setEnabled(false);
        ((UDCheckBox) r106.findViewById(R.id.checkBox)).setClickable(false);
        ((FrameLayout) r106.findViewById(R.id.checkBoxContainer)).setOnClickListener(new d(this, r106, r105));
        goto L29
    L15:
        ((LinearLayout) r106.findViewById(R.id.container)).setBackgroundResource(R.drawable.facade_round_top_xl);
        goto L19
    L17:
        if (r102 != (r110.size() - 1)) goto L19;
        ((LinearLayout) r106.findViewById(R.id.container)).setBackgroundResource(R.drawable.facade_round_bottom_xl);
    L30:
        if (r100 == null) goto L38;
        r100.setVisibility(8);
        return;
    }

    public final void setOnItemListener(b r100) {
        this.f211357a = r100;
    }

    public ExtendFieldListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setOrientation(1);
    }

    public ExtendFieldListView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(1);
    }
}
