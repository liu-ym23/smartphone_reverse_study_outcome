package com.larus.bmhome.common_ui.image;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.gallery.VideoVH;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.bigimg.t1;
import com.larus.bmhome.dora.IDoraEService;
import com.larus.bmhome.viewholder.LifeViewHolder;
import com.larus.bmhome.viewholder.PhotoVH;
import com.larus.common_ui.photoviewer.transition.TransitionPagerAdapter;
import com.larus.common_ui.photoviewer.transition.TransitionViewHolder;
import com.larus.image.loader.b0;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l19.f;
import uo8.b;
import yt8.c;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002KLB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00109\u001a\u0004\u0018\u00010\b2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010\b2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0010\u0010<\u001a\u0004\u0018\u00010\b2\u0006\u0010:\u001a\u00020\u0007J\u000e\u0010=\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007J\u0014\u0010>\u001a\u00020\u001b2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00100@J\u0018\u0010A\u001a\u00020\u00022\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0007H\u0016J\u000e\u0010E\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u0007J\u0010\u0010F\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u0002H\u0016J\u001a\u0010H\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u00022\b\b\u0001\u0010:\u001a\u00020\u0007H\u0016J\u0010\u0010I\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007H\u0016J\b\u0010J\u001a\u00020\u0007H\u0016R:\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u000701X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u000703¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\u000701X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u000703¢\u0006\b\n\u0000\u001a\u0004\b8\u00105¨\u0006M"}, d2 = {"Lcom/larus/bmhome/common_ui/image/CustomPhotoTransitionPagerAdapter;", "Lcom/larus/common_ui/photoviewer/transition/TransitionPagerAdapter;", "Lcom/larus/bmhome/viewholder/LifeViewHolder;", "<init>", "()V", "validMapUrl", "Ljava/util/LinkedHashMap;", "", "Landroid/net/Uri;", "Lkotlin/collections/LinkedHashMap;", "getValidMapUrl", "()Ljava/util/LinkedHashMap;", "setValidMapUrl", "(Ljava/util/LinkedHashMap;)V", "urls", "", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "getUrls", "()Ljava/util/List;", "setUrls", "(Ljava/util/List;)V", "thumbUrls", "", "getThumbUrls", "setThumbUrls", "onImageLoadSuccess", "Lkotlin/Function1;", "", "getOnImageLoadSuccess", "()Lkotlin/jvm/functions/Function1;", "setOnImageLoadSuccess", "(Lkotlin/jvm/functions/Function1;)V", "onImageLongPressListener", "Lkotlin/Function0;", "getOnImageLongPressListener", "()Lkotlin/jvm/functions/Function0;", "setOnImageLongPressListener", "(Lkotlin/jvm/functions/Function0;)V", "onImageScaleListener", "getOnImageScaleListener", "setOnImageScaleListener", "transitionListener", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "getTransitionListener", "()Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "setTransitionListener", "(Lcom/larus/common_ui/photoviewer/transition/TransitionListener;)V", "currentSelectedPosition", "_unselectedPosition", "Landroidx/lifecycle/MutableLiveData;", "unselectedPosition", "Landroidx/lifecycle/LiveData;", "getUnselectedPosition", "()Landroidx/lifecycle/LiveData;", "_selectedPosition", "selectedPosition", "getSelectedPosition", "getValidUri", "position", "getPreviewUri", "getDownloadUri", "getMediaType", "refreshData", "list", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectItem", "onViewDetachedFromWindow", "holder", "onBindViewHolder", "getItemViewType", "getItemCount", "Companion", "DiffCallback", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CustomPhotoTransitionPagerAdapter extends TransitionPagerAdapter<LifeViewHolder> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f310659v = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap<Integer, Uri> f310660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<n1> f310661k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<String> f310662l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function1<? super Integer, Unit> f310663m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function0<Unit> f310664n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function0<Unit> f310665o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f f310666p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f310667q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MutableLiveData<Integer> f310668r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final MutableLiveData f310669s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final MutableLiveData<Integer> f310670t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final MutableLiveData f310671u;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/common_ui/image/CustomPhotoTransitionPagerAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getStableId", "", MapController.ITEM_LAYER_TAG, "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<n1> f310672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<n1> f310673b;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            return this.f310673b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            return this.f310672a.size();
        }

        public static String a(n1 r100) {
            String r101 = r100.f296032c;
            if (r101 == null) goto L6;
            String r102 = StringsKt.substringAfterLast$default(r101, HTTP.URL_DEFAULT, null, 2, null);
            if (r102 == null) goto L6;
            return r102;
        L6:
            String r103 = r100.f296030a;
            if (r103 == null) goto L10;
            return StringsKt.substringAfterLast$default(r103, HTTP.URL_DEFAULT, null, 2, null);
        L10:
            return String.valueOf(r100.hashCode());
        }

        public DiffCallback(List<n1> r100, List<n1> r101) {
            Intrinsics.checkNotNullParameter(r100, "oldItems");
            Intrinsics.checkNotNullParameter(r101, "newItems");
            this.f310672a = r100;
            this.f310673b = r101;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            n1 r102 = (n1) CollectionsKt.getOrNull(this.f310672a, r100);
            n1 r103 = (n1) CollectionsKt.getOrNull(this.f310673b, r101);
            if (r102 == null) goto L12;
            if (r103 != null) goto L7;
            return false;
        L7:
            if (Intrinsics.areEqual(r102.f296032c, r103.f296032c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(r102.f296030a, r103.f296030a) == false) goto L14;
            return true;
        L14:
            return false;
        L12:
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            n1 r102 = (n1) CollectionsKt.getOrNull(this.f310672a, r100);
            n1 r103 = (n1) CollectionsKt.getOrNull(this.f310673b, r101);
            if (r102 == null) goto L18;
            if (r103 == null) goto L21;
            t1 r104 = r102.f296031b;
            String r105 = null;
            if (r104 == null) goto L9;
            String r106 = r104.g();
        L10:
            t1 r107 = r103.f296031b;
            if (r107 == null) goto L13;
            r105 = r107.g();
        L13:
            if (r106 == null) goto L17;
            if (r105 == null) goto L17;
            return Intrinsics.areEqual(r106, r105);
        L17:
            return Intrinsics.areEqual(a(r102), a(r103));
        L9:
            r106 = null;
            goto L10
        L21:
            return false;
        L18:
            return false;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f310661k.size();
    }

    public CustomPhotoTransitionPagerAdapter() {
        this.f310660j = new LinkedHashMap();
        this.f310661k = new ArrayList();
        this.f310663m = new uo8.a();
        this.f310667q = -1;
        MutableLiveData<Integer> r100 = new MutableLiveData();
        this.f310668r = r100;
        this.f310669s = r100;
        MutableLiveData<Integer> r101 = new MutableLiveData();
        this.f310670t = r101;
        this.f310671u = r101;
    }

    public final Uri A2(int r100) {
        List<n1> r101 = this.f310661k;
        String r102 = null;
        if (r101 == null) goto L26;
        n1 r103 = (n1) CollectionsKt.getOrNull(r101, r100);
        if (r103 != null) goto L7;
        return null;
    L7:
        if (Intrinsics.areEqual(r103.f296030a, r103.f296032c) == false) goto L28;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        Object r105 = Result.m9449constructorimpl(this.f310660j.get(Integer.valueOf(r100)));     // Catch: Throwable -> L11
    L14:
        if (Result.m9452exceptionOrNullimpl(r105) == null) goto L23;
        List<n1> r106 = this.f310661k;
        if (r106 == null) goto L21;
        n1 r107 = (n1) ListProtector.get(r106, r100);
        if (r107 == null) goto L21;
        r102 = r107.f296030a;
    L21:
        r105 = b0.a(r102, "common.photo_dialog_preview", false, true, 2);
    L23:
        return (Uri) r105;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L28:
        return b0.a(r103.f296032c, "common.photo_dialog_download", false, false, 6);
    L26:
        return null;
    }

    public final void B2(List<n1> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r101 = new ArrayList();
        r101.addAll(r100);
        DiffUtil.calculateDiff(new DiffCallback(this.f310661k, r101)).dispatchUpdatesTo(this);     // Catch: Exception -> L8
    L10:
        this.f310661k = r101;
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("CustomPhotoTransitionPagerAdapter", "diffResult.dispatchUpdatesTo error e=" + e.getMessage());
        goto L10
    }

    public final void C2(int r100) {
        int r101 = this.f310667q;
        if (r100 != r101) goto L6;
        return;
    L6:
        if (r101 == (-1)) goto L8;
        this.f310668r.setValue(Integer.valueOf(r101));
    L8:
        this.f310670t.setValue(Integer.valueOf(r100));
        this.f310667q = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        String r101 = ((n1) ListProtector.get(this.f310661k, r100)).f296032c;
        String r102 = null;
        if (r101 == null) goto L14;
        String r103 = StringsKt.substringBefore$default(r101, "?", null, 2, null);
        if (r103 == null) goto L14;
        String r104 = StringsKt.substringBefore$default(r103, "#", null, 2, null);
        if (r104 == null) goto L14;
        String r105 = StringsKt.substringAfterLast$default(r104, HTTP.URL_DEFAULT, null, 2, null);
        if (r105 == null) goto L14;
        String r106 = r105.toLowerCase(Locale.ROOT);
        if (r106 == null) goto L14;
        r102 = StringsKt.substringAfterLast$default(r106, ".", null, 2, null);
    L14:
        if (Intrinsics.areEqual(r102, "mp4") == true) goto L18;
        return 1;
    L18:
        return 2;
    }

    @Override // com.larus.common_ui.photoviewer.transition.TransitionPagerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        LifeViewHolder r101 = (LifeViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.z2(r101);
        r101.W3();
    }

    @Override // com.larus.common_ui.photoviewer.transition.TransitionPagerAdapter
    public final void z2(TransitionViewHolder r100) {
        LifeViewHolder r101 = (LifeViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.z2(r101);
        r101.W3();
    }

    /* JADX WARN: Type inference failed for: r10v3, types: [androidx.lifecycle.Observer, java.lang.Object, yt8.c] */
    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.lifecycle.Observer, java.lang.Object, yt8.b] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        final LifeViewHolder r101 = (LifeViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        n1 r102 = (n1) ListProtector.get(this.f310661k, r110);
        List<String> r103 = this.f310662l;
        LifecycleOwner r104 = null;
        if (r103 == null) goto L5;
        String r105 = (String) CollectionsKt.getOrNull(r103, r110);
    L6:
        r101.X3(r102, r105, this.f310663m, this.f310664n, this.f310665o, new b(this));
        MutableLiveData r111 = this.f310669s;
        MutableLiveData r106 = this.f310671u;
        Intrinsics.checkNotNullParameter(r111, "unselectedLiveData");
        Intrinsics.checkNotNullParameter(r106, "selectedLiveData");
        Object r107 = r101.itemView.getContext();
        if ((r107 instanceof LifecycleOwner) == false) goto L9;
        r104 = (LifecycleOwner) r107;
    L9:
        if (r104 == null) goto L19;
        yt8.b r108 = r101.f317573c;
        if (r108 == null) goto L14;
        r111.removeObserver(r108);
    L14:
        ?? r109 = new yt8.b(r101);
        r101.f317573c = r109;
        Intrinsics.checkNotNull(r109);
        r111.observe(r104, r109);
        c r112 = r101.f317572b;
        if (r112 == null) goto L17;
        r106.removeObserver(r112);
    L17:
        ?? r113 = new c(r101);
        r101.f317572b = r113;
        Intrinsics.checkNotNull(r113);
        r106.observe(r104, r113);
        return;
    L19:
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 1) goto L18;
        if (r101 != 2) goto L19;
        IDoraEService r102 = (IDoraEService) ServiceManager.get().getService(IDoraEService.class);
        if (r102 == null) goto L10;
        VideoVH r103 = r102.c(r100);
    L12:
        if ((r103 instanceof LifeViewHolder) == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L21;
        return r103;
    L21:
        return new PhotoVH(LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_image_view_item, r100, false));
    L10:
        r103 = null;
        goto L12
    L19:
        return new PhotoVH(LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_image_view_item, r100, false));
    L18:
        return new PhotoVH(LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_image_view_item, r100, false));
    }
}
