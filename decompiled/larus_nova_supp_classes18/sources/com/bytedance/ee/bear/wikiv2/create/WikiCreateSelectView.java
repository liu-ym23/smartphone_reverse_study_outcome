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
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u0003567B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010)\u001a\u00020*H\u0002J\u001e\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u000f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002J\u000e\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020!R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020!8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cancelFromXml", "Landroid/widget/TextView;", "getCancelFromXml", "()Landroid/widget/TextView;", "setCancelFromXml", "(Landroid/widget/TextView;)V", "selectRecyclerFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getSelectRecyclerFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setSelectRecyclerFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "doubaoCloseFromXml", "Landroid/view/View;", "getDoubaoCloseFromXml", "()Landroid/view/View;", "setDoubaoCloseFromXml", "(Landroid/view/View;)V", "delegate", "Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectView$ViewDelegate;", "getDelegate", "()Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectView$ViewDelegate;", "setDelegate", "(Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectView$ViewDelegate;)V", "isDoubaoStyle", "", "<set-?>", "isForsetiOn", "()Z", "setForsetiOn", "(Z)V", "isForsetiOn$delegate", "Lkotlin/properties/ReadWriteProperty;", "initView", "", "initRecycler", "recycler", WikiFolderPushPlugin.DATA, "", "Lcom/bytedance/ee/bear/creationmenu/SelectItem;", "resolveSpanCount", "", "itemCount", "setEnable", "enable", "ViewDelegate", "Companion", "SelectAdapter", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiCreateSelectView extends LinearLayout {
    public static final /* synthetic */ KProperty<Object>[] g = null;
    public TextView a;
    public RecyclerView b;
    public View c;
    public c d;
    public final boolean e;
    public final d f;

    public static final class a {
    }

    public static final class b extends BaseQuickAdapter<com.bytedance.ee.bear.creationmenu.g, BaseViewHolder> {
        public final boolean a;
        public boolean b;

        public b(List<com.bytedance.ee.bear.creationmenu.g> r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
            if (r3 == false) goto L5;
            int r0 = 2131568230;
        L6:
            super(r0, r2);
            this.a = r3;
            this.b = true;
            return;
        L5:
            r0 = 2131568229;
            goto L6
        }

        public final void convert(BaseViewHolder r7, Object r8) {
            com.bytedance.ee.bear.creationmenu.g r9 = (com.bytedance.ee.bear.creationmenu.g) r8;
            Intrinsics.checkNotNullParameter(r7, "helper");
            Intrinsics.checkNotNullParameter(r9, "item");
            float r1 = 1.0f;
            CharSequence r3 = "";
            boolean r4 = false;
            if (this.a == false) goto L27;
            ((RecyclerView.ViewHolder) r7).itemView.setEnabled(this.b);
            if (this.b == true) goto L7;
        L11:
            int r0 = r9.e;
            if (r0 <= 0) goto L14;
            r3 = eu5.b.a.getText(r0);
        L18:
            Intrinsics.checkNotNull(r3);
            AppCompatImageView r2 = r7.getView(2131385796);
            r2.setImageResource(kac.a.b(r9.d));
            if (r4 == false) goto L21;
            float r10 = 1.0f;
        L22:
            r2.setAlpha(r10);
            r2.setEnabled(this.b);
            AppCompatTextView r11 = r7.getView(2131385818);
            r11.setText(r3);
            if (r4 == true) goto L26;
            r1 = 0.3f;
        L26:
            r11.setAlpha(r1);
            r11.setEnabled(this.b);
            return;
        L21:
            r10 = 0.3f;
            goto L22
        L14:
            CharSequence r5 = r9.f;
            if (r5 == null) goto L18;
            r3 = r5;
            goto L18
        L7:
            if (r9.a == false) goto L11;
            if (r9.b == false) goto L11;
            r4 = true;
            goto L11
        L27:
            AppCompatTextView r12 = r7.getView(2131385798);
            int r6 = r9.e;
            if (r6 <= 0) goto L30;
            r3 = eu5.b.a.getText(r6);
        L34:
            Intrinsics.checkNotNull(r3);
            r12.setText(r3);
            r12.setCompoundDrawablesWithIntrinsicBounds(0, kac.a.b(r9.d), 0, 0);
            r12.setEnabled(this.b);
            if (this.b == true) goto L37;
        L41:
            r1 = 0.3f;
        L42:
            r12.setAlpha(r1);
            return;
        L37:
            if (r9.a == false) goto L41;
            if (r9.b == false) goto L41;
        L30:
            CharSequence r13 = r9.f;
            if (r13 == null) goto L34;
            r3 = r13;
            goto L34
        }
    }

    public interface c {
        void a(int r1);

        void onCancelClick();
    }

    public static final class d extends ObservableProperty<Boolean> {
        public final /* synthetic */ WikiCreateSelectView a;

        public d(Object r1, WikiCreateSelectView r2) {
            this.a = r2;
            super(r1);
        }

        public final void afterChange(KProperty<?> r2, Boolean r3, Boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "property");
            boolean r5 = r4.booleanValue();
            r3.booleanValue();
            WikiCreateSelectView r6 = this.a;
            if (r6.e == true) goto L10;
            TextView r7 = r6.getCancelFromXml();
            if (r5 == false) goto L7;
            int r8 = 8;
        L8:
            r7.setVisibility(r8);
            return;
        L7:
            r8 = 0;
            goto L8
        }
    }

    static {
        g = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(WikiCreateSelectView.class, "isForsetiOn", "isForsetiOn()Z", 0))};
    }

    public final TextView getCancelFromXml() {
        KeyEvent.Callback r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131365114);
        this.a = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final View getDoubaoCloseFromXml() {
        View r0 = this.c;
        if (r0 != null) goto L6;
        View r1 = findViewById(2131370090);
        this.c = r1;
        return r1;
    L6:
        return r0;
    }

    public final RecyclerView getSelectRecyclerFromXml() {
        RecyclerView r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131385811);
        this.b = r0;
    L6:
        return r0;
    }

    public final c getDelegate() {
        return this.d;
    }

    public final void setCancelFromXml(TextView r1) {
        this.a = r1;
    }

    public final void setDelegate(c r1) {
        this.d = r1;
    }

    public final void setDoubaoCloseFromXml(View r1) {
        this.c = r1;
    }

    public final void setEnable(boolean r3) {
        b r0 = getSelectRecyclerFromXml().getAdapter();
        if ((r0 instanceof b) == false) goto L5;
        b r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.b = r3;
        r1.notifyDataSetChanged();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setForsetiOn(boolean r4) {
        this.f.setValue(this, g[0], Boolean.valueOf(r4));
    }

    public final void setSelectRecyclerFromXml(RecyclerView r1) {
        this.b = r1;
    }

    public WikiCreateSelectView(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "attrs");
        super(r6, r7);
        boolean r8 = en4.a.l();
        this.e = r8;
        Delegates r0 = Delegates.INSTANCE;
        this.f = new d(Boolean.FALSE, this);
        if (r8 == false) goto L5;
        int r1 = 2131568234;
    L6:
        LayoutInflater.from(r6).inflate(r1, this);
        if (ForsetiHelper.p() == false) goto L9;
        setBackgroundResource(2131235325);
    L9:
        RecyclerView r9 = getSelectRecyclerFromXml();
        List<com.bytedance.ee.bear.creationmenu.g> r2 = com.bytedance.ee.bear.wikiv2.create.a.b();
        Context r3 = getContext();
        int r4 = r2.size();
        if (r8 == true) goto L13;
    L15:
        int r5 = 4;
    L16:
        r9.setLayoutManager(new GridLayoutManager(r3, r5));
        b r10 = new b(r2, r8);
        r10.setOnItemClickListener(new com.bytedance.ee.bear.wikiv2.create.d(r10, r2, this));
        r9.setAdapter(r10);
        if (r8 == false) goto L19;
        getDoubaoCloseFromXml().setOnClickListener(new e(this));
        return;
    L19:
        getCancelFromXml().setOnClickListener(new f(this));
        return;
    L13:
        if (r4 > 5) goto L15;
        r5 = RangesKt.coerceAtLeast(r4, 1);
        goto L16
    L5:
        r1 = 2131568233;
        goto L6
    }
}
