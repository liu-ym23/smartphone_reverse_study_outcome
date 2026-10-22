package com.larus.uaigc.avatar.instruction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u001dB,\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0014J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/uaigc/avatar/instruction/DigitalAvatarSelectorWidgetAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/actionbar/model/ActionBarDigitalAvatarTemplateItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "callback", "Lcom/larus/uaigc/avatar/instruction/DigitalAvatarSelectorHolderCallback;", "headerViewDsl", "Lkotlin/Function1;", "Lcom/larus/uaigc/avatar/instruction/DigitalAvatarSelectorWidgetAdapter$HeaderComponentBuilder;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lcom/larus/uaigc/avatar/instruction/DigitalAvatarSelectorHolderCallback;Lkotlin/jvm/functions/Function1;)V", "headerComponentBuilder", "headerComponent", "Lcom/larus/uaigc/avatar/instruction/HeaderComponent;", "offset", "", "getItemCount", "getItem", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemViewType", "Companion", "HeaderComponentBuilder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DigitalAvatarSelectorWidgetAdapter extends ListAdapter<com.larus.bmhome.actionbar.model.f, RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DigitalAvatarSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1 f370298d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f370299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f370300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f370301c;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1<? super ViewGroup, ? extends View> f370302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f370303b;

        public b() {
            this.f370302a = new f();
            this.f370303b = new g();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.uaigc.avatar.instruction.DigitalAvatarSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        f370298d = new DigitalAvatarSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1();
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return super.getItemCount() + this.f370301c;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public final com.larus.bmhome.actionbar.model.f getItem(int r100) {
        return (com.larus.bmhome.actionbar.model.f) super.getItem(r100 - this.f370301c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 >= this.f370301c) goto L5;
        return 1;
    L5:
        return 0;
    }

    public DigitalAvatarSelectorWidgetAdapter(DigitalAvatarTemplateListSelectorWidget.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        super(f370298d);
        this.f370299a = r100;
        b r102 = new b();
        if (r101 == null) goto L6;
        r101.invoke(r102);
        this.f370300b = new h(r102);
    L6:
        if (this.f370300b == null) goto L8;
        int r103 = 1;
    L9:
        this.f370301c = r103;
        return;
    L8:
        r103 = 0;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof HeaderViewHolder) == false) goto L8;
        h r102 = this.f370300b;
        if (r102 == null) goto L15;
        HeaderViewHolder r103 = (HeaderViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        r102.f370322a.f370303b.invoke(r103);
        return;
    L15:
        return;
    L8:
        if ((r100 instanceof DigitalAvatarSelectorHolder) == false) goto L17;
        final DigitalAvatarSelectorHolder r104 = (DigitalAvatarSelectorHolder) r100;
        final com.larus.bmhome.actionbar.model.f r105 = (com.larus.bmhome.actionbar.model.f) super.getItem(r101 - this.f370301c);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "data");
        SimpleDraweeView r106 = r104.f370294c;
        g1 r107 = r105.f295105e;
        if (r107 == null) goto L12;
        String r108 = r107.f295156b;
    L13:
        ImageLoaderKt.y(r106, r108, "custom_actionbar_icon_instruction", new c(r104), 4);
        r104.f370295d.setText(r105.f295102b);
        e1.d(r104.f370292a, new com.larus.uaigc.avatar.instruction.a(r104, r105));
        e1.d(r104.f370296e, new com.larus.uaigc.avatar.instruction.b(r104, r105));
        return;
    L12:
        r108 = null;
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 1) goto L10;
        h r102 = this.f370300b;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r103 = r102.f370322a.f370302a.invoke(r100);
        if (r103 == null) goto L8;
    L25:
        return new HeaderViewHolder(r103);
    L8:
        r103 = new View(r100.getContext());
        goto L25
    L10:
        View r104 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_actionbar_image_template_selector_holder, r100, false);
        FrameLayout r105 = (FrameLayout) r104;
        int r106 = R.id.image_template_cover;
        if (((SimpleDraweeView) ViewBindings.findChildViewById(r104, R.id.image_template_cover)) == null) goto L24;
        r106 = R.id.image_template_create_container;
        if (((FrameLayout) ViewBindings.findChildViewById(r104, R.id.image_template_create_container)) == null) goto L24;
        r106 = R.id.image_template_create_view;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r104, R.id.image_template_create_view)) == null) goto L24;
        r106 = R.id.retry_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r104, R.id.retry_icon)) == null) goto L24;
        FrameLayout r107 = (FrameLayout) r105.findViewById(R.id.container);
        if (r107 == null) goto L22;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        r108.width = j19.c.c(100);
        ViewGroup.LayoutParams r109 = r107.getLayoutParams();
        r109.height = j19.c.c(133);
    L22:
        return new DigitalAvatarSelectorHolder(r105, this.f370299a);
    L24:
        throw new NullPointerException("Missing required view with ID: ".concat(r104.getResources().getResourceName(r106)));
    }
}
