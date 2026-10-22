package com.larus.community.impl.publish;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBindings;
import com.larus.community.impl.databinding.LarusCommunityCreationPublishDescEditLayoutBinding;
import com.larus.nova.R;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\bH\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/community/impl/publish/CreationPublishDescEditComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/community/impl/publish/ability/ICreationPublishDescAbility;", "<init>", "()V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationPublishDescEditLayoutBinding;", "maxLength", "", "currentCount", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "initView", "showOverLimitToast", "updateCounter", "count", "getCaption", "", "getCaptionCount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishDescEditComponent extends BaseContentWidget implements n29.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f329615p = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LarusCommunityCreationPublishDescEditLayoutBinding f329616m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f329617n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f329618o;

    @Override // n29.b
    public final String CY() {
        LarusCommunityCreationPublishDescEditLayoutBinding r100 = this.f329616m;
        if (r100 == null) goto L12;
        AppCompatEditText r101 = r100.f329096c;
        if (r101 == null) goto L12;
        Editable r102 = r101.getText();
        if (r102 == null) goto L12;
        String r103 = r102.toString();
        if (r103 == null) goto L12;
        String r104 = StringsKt.trim(r103).toString();
        if (r104 == null) goto L12;
        return r104;
    L12:
        return "";
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).c(this, n29.b.class);
    }

    public CreationPublishDescEditComponent() {
        this.f329617n = 50;
    }

    @Override // n29.b
    public final int Uy() {
        return this.f329618o;
    }

    public final void Y2(int r100) {
        this.f329618o = r100;
        LarusCommunityCreationPublishDescEditLayoutBinding r101 = this.f329616m;
        if (r101 == null) goto L6;
        TextView r102 = r101.f329095b;
        StringBuilder r103 = new StringBuilder();
        r103.append(RangesKt.coerceAtMost(r100, this.f329617n));
        r103.append('/');
        r103.append(this.f329617n);
        r102.setText(r103.toString());
        return;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.community.impl.publish.a, java.lang.Object] */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        View r101 = F2();
        if ((r101 instanceof FrameLayout) == false) goto L5;
        FrameLayout r102 = (FrameLayout) r101;
    L6:
        if (r102 == null) goto L14;
        LayoutInflater.from(getContext()).inflate(R.layout.larus_community_creation_publish_desc_edit_layout, r102);
        int r103 = R.id.counter_text;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r102, R.id.counter_text);
        if (r104 == null) goto L13;
        r103 = R.id.desc_edit;
        AppCompatEditText r105 = (AppCompatEditText) ViewBindings.findChildViewById(r102, R.id.desc_edit);
        if (r105 == null) goto L13;
        this.f329616m = new LarusCommunityCreationPublishDescEditLayoutBinding(r102, r104, r105);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    L14:
        LarusCommunityCreationPublishDescEditLayoutBinding r106 = this.f329616m;
        if (r106 == null) goto L18;
        w0.e(r106.f329096c, i5.q());
        Y2(0);
        AppCompatEditText r107 = r106.f329096c;
        int r108 = this.f329617n * 2;
        ?? r109 = new a(this);
        Intrinsics.checkNotNullParameter(r107, "<this>");
        Intrinsics.checkNotNullParameter(r109, "afterTextChanged");
        Ref.ObjectRef r110 = new Ref.ObjectRef();
        r110.element = "";
        r107.addTextChangedListener(new q29.g(r110, new Ref.IntRef(), r108, r109, r107));
        return;
    L18:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
