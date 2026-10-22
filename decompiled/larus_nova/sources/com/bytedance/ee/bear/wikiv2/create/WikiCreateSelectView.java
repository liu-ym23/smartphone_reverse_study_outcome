package com.bytedance.ee.bear.wikiv2.create;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.keyframes.model.KFAnimation;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u0003567B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010)\u001a\u00020*H\u0002J\u001e\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u000f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002J\u000e\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020!R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020!8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cancelFromXml", "Landroid/widget/TextView;", "getCancelFromXml", "()Landroid/widget/TextView;", "setCancelFromXml", "(Landroid/widget/TextView;)V", "selectRecyclerFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getSelectRecyclerFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setSelectRecyclerFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "doubaoCloseFromXml", "Landroid/view/View;", "getDoubaoCloseFromXml", "()Landroid/view/View;", "setDoubaoCloseFromXml", "(Landroid/view/View;)V", "delegate", "Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectView$ViewDelegate;", "getDelegate", "()Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectView$ViewDelegate;", "setDelegate", "(Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectView$ViewDelegate;)V", "isDoubaoStyle", "", "<set-?>", "isForsetiOn", "()Z", "setForsetiOn", "(Z)V", "isForsetiOn$delegate", "Lkotlin/properties/ReadWriteProperty;", "initView", "", "initRecycler", "recycler", "data", "", "Lcom/bytedance/ee/bear/creationmenu/SelectItem;", "resolveSpanCount", "", "itemCount", "setEnable", "enable", "ViewDelegate", "Companion", "SelectAdapter", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiCreateSelectView extends LinearLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f240671g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f240672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f240673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f240674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f240675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f240676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f240677f;

    public static final class a {
    }

    public static final class b extends BaseQuickAdapter<com.bytedance.ee.bear.creationmenu.g, BaseViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f240678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f240679b;

        public b(List<com.bytedance.ee.bear.creationmenu.g> r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            if (r101 == false) goto L5;
            int r102 = R.layout.wiki_create_select_item_doubao;
        L6:
            super(r102, r100);
            this.f240678a = r101;
            this.f240679b = true;
            return;
        L5:
            r102 = R.layout.wiki_create_select_item;
            goto L6
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public final void convert(BaseViewHolder r100, com.bytedance.ee.bear.creationmenu.g r101) {
            com.bytedance.ee.bear.creationmenu.g r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "helper");
            Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
            float r103 = 1.0f;
            CharSequence r104 = "";
            boolean r105 = false;
            if (this.f240678a == false) goto L27;
            r100.itemView.setEnabled(this.f240679b);
            if (this.f240679b == true) goto L7;
        L11:
            int r106 = r102.f217326e;
            if (r106 <= 0) goto L14;
            r104 = eu5.b.f474075a.getText(r106);
        L18:
            Intrinsics.checkNotNull(r104);
            AppCompatImageView r107 = (AppCompatImageView) r100.getView(R.id.select_icon);
            r107.setImageResource(kac.a.b(r102.f217325d));
            if (r105 == false) goto L21;
            float r108 = 1.0f;
        L22:
            r107.setAlpha(r108);
            r107.setEnabled(this.f240679b);
            AppCompatTextView r109 = (AppCompatTextView) r100.getView(R.id.select_title);
            r109.setText(r104);
            if (r105 == true) goto L26;
            r103 = 0.3f;
        L26:
            r109.setAlpha(r103);
            r109.setEnabled(this.f240679b);
            return;
        L21:
            r108 = 0.3f;
            goto L22
        L14:
            CharSequence r110 = r102.f217327f;
            if (r110 == null) goto L18;
            r104 = r110;
            goto L18
        L7:
            if (r102.f217322a == false) goto L11;
            if (r102.f217323b == false) goto L11;
            r105 = true;
            goto L11
        L27:
            AppCompatTextView r111 = (AppCompatTextView) r100.getView(R.id.select_item);
            int r112 = r102.f217326e;
            if (r112 <= 0) goto L30;
            r104 = eu5.b.f474075a.getText(r112);
        L34:
            Intrinsics.checkNotNull(r104);
            r111.setText(r104);
            r111.setCompoundDrawablesWithIntrinsicBounds(0, kac.a.b(r102.f217325d), 0, 0);
            r111.setEnabled(this.f240679b);
            if (this.f240679b == true) goto L37;
        L41:
            r103 = 0.3f;
        L42:
            r111.setAlpha(r103);
            return;
        L37:
            if (r102.f217322a == false) goto L41;
            if (r102.f217323b == false) goto L41;
        L30:
            CharSequence r113 = r102.f217327f;
            if (r113 == null) goto L34;
            r104 = r113;
            goto L34
        }
    }

    public interface c {
        void a(int r100);

        void onCancelClick();
    }

    public static final class d extends ObservableProperty<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiCreateSelectView f240680a;

        public d(Object r100, WikiCreateSelectView r101) {
            this.f240680a = r101;
            super(r100);
        }

        @Override // kotlin.properties.ObservableProperty
        public final void afterChange(KProperty<?> r100, Boolean r101, Boolean r102) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            boolean r103 = r102.booleanValue();
            r101.booleanValue();
            WikiCreateSelectView r104 = this.f240680a;
            if (r104.f240676e == true) goto L10;
            TextView r105 = r104.getCancelFromXml();
            if (r103 == false) goto L7;
            int r106 = 8;
        L8:
            r105.setVisibility(r106);
            return;
        L7:
            r106 = 0;
            goto L8
        }
    }

    static {
        f240671g = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(WikiCreateSelectView.class, "isForsetiOn", "isForsetiOn()Z", 0))};
    }

    public final TextView getCancelFromXml() {
        KeyEvent.Callback r100 = this.f240672a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.cancel);
        this.f240672a = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final View getDoubaoCloseFromXml() {
        View r100 = this.f240674c;
        if (r100 != null) goto L6;
        View r101 = findViewById(R.id.doubao_close);
        this.f240674c = r101;
        return r101;
    L6:
        return r100;
    }

    public final RecyclerView getSelectRecyclerFromXml() {
        KeyEvent.Callback r100 = this.f240673b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.select_recycler);
        this.f240673b = (RecyclerView) r100;
    L6:
        return (RecyclerView) r100;
    }

    public final c getDelegate() {
        return this.f240675d;
    }

    public final void setCancelFromXml(TextView r100) {
        this.f240672a = r100;
    }

    public final void setDelegate(c r100) {
        this.f240675d = r100;
    }

    public final void setDoubaoCloseFromXml(View r100) {
        this.f240674c = r100;
    }

    public final void setEnable(boolean r100) {
        RecyclerView.Adapter r101 = getSelectRecyclerFromXml().getAdapter();
        if ((r101 instanceof b) == false) goto L5;
        b r102 = (b) r101;
    L6:
        if (r102 == null) goto L9;
        r102.f240679b = r100;
        r102.notifyDataSetChanged();
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setForsetiOn(boolean r100) {
        this.f240677f.setValue(this, f240671g[0], Boolean.valueOf(r100));
    }

    public final void setSelectRecyclerFromXml(RecyclerView r100) {
        this.f240673b = r100;
    }

    public WikiCreateSelectView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        boolean r102 = en4.a.l();
        this.f240676e = r102;
        Delegates r103 = Delegates.INSTANCE;
        this.f240677f = new d(Boolean.FALSE, this);
        if (r102 == false) goto L5;
        int r104 = R.layout.wiki_create_select_view_doubao;
    L6:
        LayoutInflater.from(r100).inflate(r104, this);
        if (ForsetiHelper.p() == false) goto L9;
        setBackgroundResource(R.drawable.facade_round_top_xxl);
    L9:
        RecyclerView r105 = getSelectRecyclerFromXml();
        List<com.bytedance.ee.bear.creationmenu.g> r106 = com.bytedance.ee.bear.wikiv2.create.a.b();
        Context r107 = getContext();
        int r108 = r106.size();
        if (r102 == true) goto L13;
    L15:
        int r109 = 4;
    L16:
        r105.setLayoutManager(new GridLayoutManager(r107, r109));
        b r110 = new b(r106, r102);
        r110.setOnItemClickListener(new com.bytedance.ee.bear.wikiv2.create.d(r110, r106, this));
        r105.setAdapter(r110);
        if (r102 == false) goto L19;
        getDoubaoCloseFromXml().setOnClickListener(new e(this));
        return;
    L19:
        getCancelFromXml().setOnClickListener(new f(this));
        return;
    L13:
        if (r108 > 5) goto L15;
        r109 = RangesKt.coerceAtLeast(r108, 1);
        goto L16
    L5:
        r104 = R.layout.wiki_create_select_view;
        goto L6
    }
}
