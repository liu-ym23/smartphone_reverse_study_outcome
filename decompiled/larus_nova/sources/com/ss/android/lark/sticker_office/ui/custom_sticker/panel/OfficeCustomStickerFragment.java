package com.ss.android.lark.sticker_office.ui.custom_sticker.panel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sticker_office.databinding.FragmentOfficeCustomStickerBinding;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.ViewKtKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u001dH\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\u0012\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\b\u0010'\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020*H\u0002J\u001e\u0010+\u001a\u00020\u001d2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020*H\u0002J&\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u0002052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001a\u000200H\u0002J\u0012\u00106\u001a\u00020\u001d2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\b\u00109\u001a\u00020\u001dH\u0002J\b\u0010:\u001a\u00020\u001dH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeCustomStickerFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/lark/sticker/entity/IOfficeCustomStickerPanel;", "<init>", "()V", "viewBinding", "Lcom/ss/android/lark/sticker_office/databinding/FragmentOfficeCustomStickerBinding;", "viewModel", "Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeCustomStickerViewModel;", "getViewModel", "()Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeCustomStickerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "stickerAdapter", "Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeCustomStickerAdapter;", "getStickerAdapter", "()Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeCustomStickerAdapter;", "stickerAdapter$delegate", "onCustomStickerListener", "Lcom/ss/android/lark/sticker/entity/OnCustomStickerListener;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onPause", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "setOnCustomStickerListener", "listener", "pickFromAlbum", "initAddSticker", "initStickerGrid", "observeStickerList", "createAddSticker", "Lcom/ss/android/lark/chat/entity/sticker/Sticker;", "uploadStickers", "photoPaths", "", "", "keepOriginal", "", "deleteSticker", "sticker", "onUploadSuccess", "uploadStickersResult", "Lcom/ss/android/lark/sticker/core/model/UploadStickersResult;", "onUploadFail", "err", "", "restoreEmptyAddLayoutIfNeeded", "showDefaultUploadError", "Companion", "sticker-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeCustomStickerFragment extends Fragment implements g6c.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f440877h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FragmentOfficeCustomStickerBinding f440878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f440879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f440880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g6c.b f440881g;

    public static final class a {
    }

    static {
    }

    public final OfficeCustomStickerAdapter U90() {
        return (OfficeCustomStickerAdapter) this.f440880f.getValue();
    }

    public final OfficeCustomStickerViewModel V90() {
        return (OfficeCustomStickerViewModel) this.f440879e.getValue();
    }

    public final void W90() {
        new UDDialogBuilder(requireActivity()).title(R.string.Lark_Legacy_LarkTip).titleBold(true).message(R.string.Lark_Legacy_StickerUploadNetErrorTip).addActionButton(R.id.lkui_dialog_btn_right, R.string.Lark_Legacy_ConfirmTip, null).show();
    }

    public OfficeCustomStickerFragment() {
        this.f440879e = LazyKt.lazy(OfficeCustomStickerFragment$viewModel$2.INSTANCE);
        this.f440880f = LazyKt.lazy(new OfficeCustomStickerFragment$stickerAdapter$2(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Log.i("OfficeCustomStickerFragment", LiveCommonConstants.REASON_ON_DEDTROY);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Log.i("OfficeCustomStickerFragment", "onDestroyView");
        OfficeCustomStickerViewModel r100 = V90();
        r100.getClass();
        Log.i("OfficeCustomStickerViewModel", "clear");
        r100.f440886d = null;
        int r101 = com.ss.android.lark.sticker.core.di.c.f440791a;
        ((e6c.b) e0c.k.a(LarkContext.getApplication(), e6c.b.class)).y1(r100.f440888f);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        Log.i("OfficeCustomStickerFragment", "onPause");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Log.i("OfficeCustomStickerFragment", "onResume");
        OfficeCustomStickerViewModel r100 = V90();
        if (r100.f440887e == false) goto L8;
        CoroutineScope r101 = r100.f440886d;
        if (r101 == null) goto L9;
        BuildersKt.launch$default(r101, null, null, new OfficeCustomStickerViewModel$loadStickersFromServer$1(r100, null), 3, null);
        return;
    L9:
        return;
    }

    public static final void S90(OfficeCustomStickerFragment r100) {
        r100.getClass();
        i6c.a.c("add_sticker", i6c.a.a());
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl((itb.e) LarkContext.spiByDwarf(itb.e.class));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        Log.e("OfficeCustomStickerFragment", "get IOfficeMediaApi failed", r103);
        r102 = null;
    L11:
        itb.e r104 = (itb.e) r102;
        if (r104 != null) goto L14;
        Log.w("OfficeCustomStickerFragment", "pickFromAlbum failed, officeMediaApi is null");
        return;
    L14:
        itb.g r105 = new itb.g(9, true, false, false, 120);
        if (r104.f0(r100.requireActivity(), r105, new k(r100, r105)) == true) goto L21;
        Log.w("OfficeCustomStickerFragment", "pickFromAlbum failed, host media api returned false");
        return;
    L21:
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // g6c.a
    public final void RP(com.ss.android.lark.keyboard_biz_emoji_office.b r100) {
        this.f440881g = r100;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Log.i("OfficeCustomStickerFragment", "onViewCreated");
        FragmentOfficeCustomStickerBinding r102 = this.f440878d;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r102 = null;
    L5:
        r102.f440848b.setOnClickListener(new g(this));
        FragmentOfficeCustomStickerBinding r103 = this.f440878d;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r103 = null;
    L8:
        RecyclerView r104 = r103.f440849c;
        r104.setLayoutManager(new GridLayoutManager(requireContext(), 4));
        r104.setAdapter(U90());
        Intrinsics.checkNotNull(r104);
        ViewKtKt.a(r104, new h(this, r104));
        V90().f440884b.observe(this, new i(this));
        OfficeCustomStickerViewModel r105 = V90();
        LifecycleCoroutineScope r106 = LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner());
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "lifecycleScope");
        Log.i("OfficeCustomStickerViewModel", "init");
        r105.f440886d = r106;
        int r107 = com.ss.android.lark.sticker.core.di.c.f440791a;
        ((e6c.b) e0c.k.a(LarkContext.getApplication(), e6c.b.class)).q7(r105.f440888f);
        OfficeCustomStickerViewModel r108 = V90();
        CoroutineScope r109 = r108.f440886d;
        if (r109 == null) goto L12;
        BuildersKt.launch$default(r109, null, null, new OfficeCustomStickerViewModel$loadStickers$1(r108, null, null), 3, null);
        return;
    }

    public static final void T90(OfficeCustomStickerFragment r100, List r101, boolean r102) {
        r100.getClass();
        if (r101.isEmpty() == true) goto L7;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100.getViewLifecycleOwner()), null, null, new OfficeCustomStickerFragment$uploadStickers$1(r100, r101, r102, null), 3, null);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Log.i("OfficeCustomStickerFragment", "onCreateView");
        View r103 = r100.inflate(R.layout.fragment_office_custom_sticker, r101, false);
        int r104 = R.id.addLayout;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.addLayout);
        if (r105 == null) goto L9;
        r104 = R.id.recyclerView;
        RecyclerView r106 = (RecyclerView) ViewBindings.findChildViewById(r103, R.id.recyclerView);
        if (r106 == null) goto L9;
        FragmentOfficeCustomStickerBinding r107 = new FragmentOfficeCustomStickerBinding((FrameLayout) r103, r105, r106);
        this.f440878d = r107;
        return r107.f440847a;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
