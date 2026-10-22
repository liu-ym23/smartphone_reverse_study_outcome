package com.larus.bmhome.view.resourcebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.chat.common.databinding.LarusResourceBarBinding;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0016\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J2\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J2\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010 \u001a\u00020\u00192\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001eH\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u001dH\u0016J\b\u0010$\u001a\u00020\u0019H\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u001dH\u0016J\u0018\u0010)\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020\u000bH\u0016J\u0012\u0010+\u001a\u0004\u0018\u00010\u001d2\u0006\u0010&\u001a\u00020'H\u0016J\u0017\u0010,\u001a\u0004\u0018\u00010\u000b2\u0006\u0010&\u001a\u00020'H\u0016¢\u0006\u0002\u0010-J\u001c\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001eH\u0016J\b\u0010/\u001a\u000200H\u0016J\u000e\u00101\u001a\u0004\u0018\u00010'*\u00020\u0010H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u00063"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/ResourceBar;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/view/resourcebar/bean/IResourceItemOperator;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusResourceBarBinding;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "adapter", "Lcom/larus/bmhome/view/resourcebar/ResourceBarAdapter;", "callback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "adapterCallback", "com/larus/bmhome/view/resourcebar/ResourceBar$adapterCallback$1", "Lcom/larus/bmhome/view/resourcebar/ResourceBar$adapterCallback$1;", "init", "", "bind", "items", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "Lkotlin/collections/ArrayList;", "bindAndRefresh", "refresh", "refreshCurrentItems", "addItem", MapController.ITEM_LAYER_TAG, "scrollToLastIfNeed", "removeItem", "key", "", "refreshItem", "refreshUpLinkProgress", "upLinkProgress", "getItem", "getItemPosition", "(Ljava/lang/String;)Ljava/lang/Integer;", "getList", "getView", "Landroid/view/View;", "messageIdentity", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceBar extends LinearLayout implements mt8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusResourceBarBinding f317136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ResourceBarConfig f317137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ResourceBarAdapter f317138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BaseResourceViewHolder.a f317139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f317140e;

    public static final class a {
    }

    public static final class b implements BaseResourceViewHolder.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResourceBar f317141a;

        public b(ResourceBar r100) {
            this.f317141a = r100;
        }

        @Override // com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder.a
        public final boolean b(String r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
            FLogger.f375446a.i("ResourceBar", "onLongClick, key:" + r100);
            BaseResourceViewHolder.a r102 = this.f317141a.f317139d;
            if (r102 != null) goto L7;
            return false;
        L7:
            return r102.b(r100, r101);
        }

        @Override // com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder.a
        public final void a(String r100, int r101, View r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, BaseSwitches.V);
            FLogger.f375446a.i("ResourceBar", "onClick, key:" + r100 + ", event:" + r101);
            BaseResourceViewHolder.a r103 = this.f317141a.f317139d;
            if (r103 == null) goto L6;
            r103.a(r100, r101, r102);
            return;
        }
    }

    static {
    }

    @Override // mt8.a
    public View getView() {
        return this;
    }

    @Override // mt8.a
    public final void d() {
        FLogger.f375446a.i("ResourceBar", "refreshCurrentItems");
        ResourceBarAdapter r100 = this.f317138c;
        if (r100 == null) goto L6;
        r100.notifyDataSetChanged();
        return;
    }

    @Override // mt8.a
    public ArrayList<ResourceItemBean> getList() {
        ResourceBarAdapter r100 = this.f317138c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f317145c;
    }

    public final void j() {
        FLogger.f375446a.i("ResourceBar", "init");
        LayoutInflater.from(getContext()).inflate(R.layout.larus_resource_bar, this);
        RecyclerView r100 = (RecyclerView) ViewBindings.findChildViewById(this, R.id.horizontal_list);
        if (r100 == null) goto L7;
        this.f317136a = new LarusResourceBarBinding(this, r100);
        setOrientation(1);
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R.id.horizontal_list)));
    }

    public final void l() {
        ResourceBarConfig r100 = this.f317137b;
        LarusResourceBarBinding r101 = null;
        if (r100 == null) goto L5;
        Mode r102 = r100.getMode();
    L7:
        if (r102 != Mode.EDIT) goto L26;
        ResourceBarAdapter r103 = this.f317138c;
        if (r103 == null) goto L27;
        ArrayList<ResourceItemBean> r104 = r103.f317145c;
        if (r104 != null) goto L13;
        return;
    L13:
        if (r104.size() < 1) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == true) goto L19;
        r104 = null;
    L19:
        if (r104 == null) goto L29;
        LarusResourceBarBinding r106 = this.f317136a;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L24:
        r101.f324063b.scrollToPosition(r104.size() - 1);
        return;
    L23:
        r101 = r106;
        goto L24
    L29:
        return;
    L15:
        r105 = false;
        goto L16
    L27:
        return;
    L26:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public ResourceBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f317140e = new b(this);
        j();
    }

    public static String k(ResourceBarConfig r100) {
        Object r101 = r100.getExt().get("key_message");
        if ((r101 instanceof Message) == false) goto L5;
        Message r102 = (Message) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        String r103 = r102.getLocalMessageId();
        String r104 = "";
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        if (r103.length() != 0) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L22;
        String r106 = r102.getMessageId();
        if (r106 == null) goto L21;
        r104 = r106;
    L21:
        return r104;
    L22:
        return r103;
    L14:
        r105 = false;
        goto L15
    L5:
        r102 = null;
        goto L6
    }

    @Override // mt8.a
    public final ResourceItemBean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ResourceBarAdapter r101 = this.f317138c;
        ResourceItemBean r102 = null;
        if (r101 == null) goto L15;
        Intrinsics.checkNotNullParameter(r100, "key");
        Iterator<ResourceItemBean> r103 = r101.f317145c.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        ResourceItemBean r104 = r103.next();
        if (Intrinsics.areEqual(r104.getKey(), r100) == false) goto L6;
        r102 = r104;
    L11:
        return r102;
    L15:
        return null;
    }

    @Override // mt8.a
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        FLogger.f375446a.i("ResourceBar", "removeItem");
        ResourceBarAdapter r101 = this.f317138c;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "key");
        Integer r102 = r101.z2(r100);
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
        ListProtector.remove(r101.f317145c, r103);
        r101.notifyDataSetChanged();
        return;
    L9:
        return;
    }

    @Override // mt8.a
    public final void e(ArrayList<ResourceItemBean> r210) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("refresh, itemCount=");
        if (r210 == null) goto L5;
        int r102 = r210.size();
    L6:
        r101.append(r102);
        r100.i("ResourceBar", r101.toString());
        final ResourceBarAdapter r103 = this.f317138c;
        if (r103 == null) goto L20;
        final ArrayList r104 = new ArrayList(r103.f317145c);
        final ArrayList r105 = new ArrayList();
        if (r210 == null) goto L12;
        r105.addAll(r210);
    L12:
        if (r103.f317143a.getMode() == Mode.EDIT) goto L14;
    L16:
        r103.f317145c.clear();
        r103.f317145c.addAll(r105);
        if (r104.isEmpty() == false) goto L19;
        r103.notifyDataSetChanged();
        goto L20
    L19:
        DiffUtil.calculateDiff(new ResourceBarAdapter$refresh$1(r104, r105, r103)).dispatchUpdatesTo(r103);
        goto L20
    L14:
        if (r103.f317143a.getShowAddItem() == false) goto L16;
        r105.add(new ResourceItemBean(null, null, null, null, null, null, 0, null, false, ResourceType.ADD, 0, 0, 0, 0, false, false, false, false, 0, null, 1048063, null));
    L20:
        l();
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // mt8.a
    public final void f(ResourceItemBean r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        FLogger r101 = FLogger.f375446a;
        r101.i("ResourceBar", "refreshItem, type=" + r100.getResourceType() + ", progress=" + r100.getUpLinkProgress());
        ResourceBarAdapter r102 = this.f317138c;
        if (r102 == null) goto L17;
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Integer r103 = r102.z2(r100.getKey());
        if (r103 == null) goto L18;
        int r104 = r103.intValue();
        ResourceItemBean r105 = (ResourceItemBean) CollectionsKt.getOrNull(r102.f317145c, r104);
        if (r105 == null) goto L11;
        boolean r106 = true;
        if (r105.equalsExcludeProgress(r100) != true) goto L11;
    L13:
        if (r106 == false) goto L15;
        r101.i("ResourceBarAdapter", "refreshItem, type=" + r100.getResourceType() + ", change progress=" + r100.getUpLinkProgress());
        r102.B2(r100.getKey(), r100.getUpLinkProgress());
        return;
    L15:
        r101.i("ResourceBarAdapter", "refreshItem, type=" + r100.getResourceType() + ", replace");
        ListProtector.set(r102.f317145c, r104, r100);
        r102.notifyItemChanged(r104);
        return;
    L11:
        r106 = false;
        goto L13
    L18:
        return;
    }

    @Override // mt8.a
    public final void i(ResourceItemBean r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        FLogger.f375446a.i("ResourceBar", "addItem, type=" + r100.getResourceType() + ", status=" + r100.getStatus() + ", progress=" + r100.getUpLinkProgress());
        ResourceBarAdapter r101 = this.f317138c;
        if (r101 == null) goto L19;
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        boolean r102 = true;
        if (r101.f317143a.getMode() == Mode.EDIT) goto L7;
    L9:
        int r103 = r101.f317145c.size();
    L10:
        Integer r104 = Integer.valueOf(r103);
        if (r104.intValue() >= 0) goto L14;
        r102 = false;
    L14:
        if (r102 == true) goto L17;
        r104 = null;
    L17:
        if (r104 == null) goto L19;
        ListProtector.add(r101.f317145c, r104.intValue(), r100);
        r101.notifyDataSetChanged();
        goto L19
    L7:
        if (r101.f317143a.getShowAddItem() == false) goto L9;
        r103 = r101.f317145c.size() - 1;
    L19:
        l();
    }

    public ResourceBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f317140e = new b(this);
        j();
    }

    @Override // mt8.a
    public final void g(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        FLogger.f375446a.i("ResourceBar", "refreshUpLinkProgress, key:" + r100 + ", upLinkProgress:" + r101);
        ResourceBarAdapter r102 = this.f317138c;
        if (r102 == null) goto L6;
        r102.B2(r100, r101);
        return;
    }

    public ResourceBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f317140e = new b(this);
        j();
    }

    @Override // mt8.a
    public final void b(ResourceBarConfig r100, ArrayList<ResourceItemBean> r101, BaseResourceViewHolder.a r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "items");
        FLogger.f375446a.i("ResourceBar", "bind, config:" + r100 + ", items size:" + r101.size());
        this.f317137b = r100;
        this.f317139d = r102;
        this.f317138c = new ResourceBarAdapter(r100, this.f317140e);
        LarusResourceBarBinding r103 = this.f317136a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L5:
        r103.f324063b.setAdapter(this.f317138c);
        LarusResourceBarBinding r104 = this.f317136a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L8:
        r104.f324063b.setItemAnimator(null);
        e(r101);
    }

    @Override // mt8.a
    public final void h(ResourceBarConfig r100, ArrayList<ResourceItemBean> r101, BaseResourceViewHolder.a r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "items");
        FLogger.f375446a.i("ResourceBar", "bindAndRefresh, config:" + r100 + ", items size:" + r101.size());
        this.f317139d = r102;
        ResourceBarAdapter r103 = this.f317138c;
        ResourceBarConfig r104 = this.f317137b;
        this.f317137b = r100;
        if (r103 == null) goto L17;
        LarusResourceBarBinding r105 = this.f317136a;
        String r106 = null;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L8:
        if (r105.f324063b.getAdapter() != r103) goto L17;
        if (r103.f317143a.getMode() != r100.getMode()) goto L17;
        if (r104 == null) goto L14;
        r106 = k(r104);
    L14:
        if (Intrinsics.areEqual(r106, k(r100)) == false) goto L17;
        boolean r107 = false;
    L18:
        if (r107 == false) goto L20;
        b(r100, r101, r102);
        return;
    L20:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "config");
        r103.f317143a = r100;
        r103.notifyDataSetChanged();
        e(r101);
        return;
    L17:
        r107 = true;
        goto L18
    }
}
