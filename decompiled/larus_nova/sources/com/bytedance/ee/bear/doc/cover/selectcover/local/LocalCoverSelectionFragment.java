package com.bytedance.ee.bear.doc.cover.selectcover.local;

import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.document.g5;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.api.FileType;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.vfs.VFSPath;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import s45.g;
import s45.h;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\rH\u0002J(\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/local/LocalCoverSelectionFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "mCoverViewModel", "Lcom/bytedance/ee/bear/doc/cover/CoverViewModel;", "fileSizeCheckListener", "Lcom/bytedance/ee/bear/fileselector/listener/IFileSizeCheckListener;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "setTipText", "setTipTextStyle", "tipView", "Landroid/widget/TextView;", "text", "", "tipInfoStr", "tipLink", "openAlbumInner", "getAlbumFileSelectListener", "Lcom/bytedance/ee/bear/fileselector/api/IFileSelectListener;", "openCameraInner", "getCameraFileSelectListener", "file2ImageItem", "Lcom/bytedance/ee/bear/doc/cover/selectcover/local/LocalImageItem;", "path", "Lcom/ss/android/lark/vfs/VFSPath;", "imageType", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalCoverSelectionFragment extends BaseFragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f217814g = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CoverViewModel f217815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f217816f;

    public static final class a {
    }

    public static final class b implements bb5.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocalCoverSelectionFragment f217817a;

        public b(LocalCoverSelectionFragment r100) {
            this.f217817a = r100;
        }

        @Override // bb5.c
        public final void a(FileType r100) {
            Intrinsics.checkNotNullParameter(r100, "fileType");
            if (Intrinsics.areEqual("IMAGE", r100.name()) == false) goto L5;
            Toast.showFailureText(this.f217817a.getContext(), R.string.CreationMobile_Docs_DocCover_ExceedFileSize_Toast);
            return;
        L5:
            Toast.showFailureText(this.f217817a.getContext(), R.string.LarkCCM_Docs_CantUploadFileBlock_Mob);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocalCoverSelectionFragment f217818a;

        public c(LocalCoverSelectionFragment r100) {
            this.f217818a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LocalCoverSelectionFragment r101 = this.f217818a;
            int r102 = LocalCoverSelectionFragment.f217814g;
            FragmentActivity r103 = r101.getActivity();
            if (r103 == null) goto L9;
            int r104 = com.bytedance.ee.bear.fileselector.d.f226786a;
            FragmentManager r105 = r103.getSupportFragmentManager();
            FileSelectConfig.g r106 = FileSelectConfig.fullScreenAlbumBuilder();
            r106.f226780a.fileSelectListener = new ly4.a(r101);
            b r107 = r101.f217816f;
            if (r107 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("fileSizeCheckListener");
            r107 = null;
        L7:
            FileSelectConfig r108 = r106.f226780a;
            r108.fileCheckListener = r107;
            r108.maxImageSize = 20971520;
            r108.enableImageCompress = true;
            r108.maxSelectImageNum = 1;
            r108.maxImageCompressSize = 20971520;
            r108.showGif = true;
            r108.showVideo = false;
            com.bytedance.ee.bear.fileselector.d.a.c(r103, r105, r106.a(), "DocCover_LocalCoverSelectionFragment");
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocalCoverSelectionFragment f217819a;

        public d(LocalCoverSelectionFragment r100) {
            this.f217819a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LocalCoverSelectionFragment r101 = this.f217819a;
            int r102 = LocalCoverSelectionFragment.f217814g;
            FragmentActivity r103 = r101.getActivity();
            if (r103 == null) goto L9;
            int r104 = com.bytedance.ee.bear.fileselector.d.f226786a;
            FragmentManager r105 = r103.getSupportFragmentManager();
            FileSelectConfig.h r106 = FileSelectConfig.larkCamaraBuilder();
            FileSelectConfig r107 = r106.f226780a;
            r107.enableImageCompress = true;
            r107.maxImageCompressSize = 20971520;
            r106.f226780a.fileSelectListener = new ly4.b(r101);
            b r108 = r101.f217816f;
            if (r108 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("fileSizeCheckListener");
            r108 = null;
        L7:
            r106.f226780a.fileCheckListener = r108;
            com.bytedance.ee.bear.fileselector.d.a.c(r103, r105, r106.a(), "DocCover_LocalCoverSelectionFragment");
            return;
        }
    }

    static {
    }

    public LocalCoverSelectionFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f217815e = (CoverViewModel) q.a(this, CoverViewModel.class);
        this.f217816f = new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.String] */
    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        r110.findViewById(R.id.album).setOnClickListener(new c(this));
        r110.findViewById(R.id.take_photo).setOnClickListener(new d(this));
        ((TextView) r110.findViewById(R.id.album_tv)).setTextColor(getResources().getColor(R.color.text_title));
        ((TextView) r110.findViewById(R.id.take_photo_tv)).setTextColor(getResources().getColor(R.color.text_title));
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        r112.element = getResources().getString(R.string.CreationMobile_Docs_DocCover_MaxSize_Desc) + ' ';
        String r100 = getResources().getString(R.string.LarkCCM_Docs_ForMoreInformation_LearnMore);
        h r101 = g.f540568a;
        String r113 = g.a.a("cover_help_center", "990851076781", "560882006899", null);
        TextView r114 = (TextView) r110.findViewById(R.id.tv_cover_tip);
        TextPaint r102 = r114.getPaint();
        int r103 = n.v();
        ViewGroup.LayoutParams r104 = r114.getLayoutParams();
        int r105 = 0;
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        int r106 = ((ViewGroup.MarginLayoutParams) r104).getMarginStart();
    L6:
        int r107 = r103 - r106;
        ViewGroup.LayoutParams r108 = r114.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r105 = ((ViewGroup.MarginLayoutParams) r108).getMarginEnd();
    L9:
        int r109 = r107 - r105;
        float r115 = r102.measureText((String) r112.element);
        float r116 = r102.measureText(r100);
        r114.getViewTreeObserver().addOnGlobalLayoutListener(new ly4.c(new Ref.BooleanRef(), r109, r115, r114, r116, r112, this, r100, r113));
        r114.setText((CharSequence) r112.element);
        return;
    L5:
        r106 = 0;
        goto L6
    }

    public static final LocalImageItem U90(LocalCoverSelectionFragment r100, VFSPath r110, String r111) {
        r100.getClass();
        String r101 = UUID.randomUUID().toString();
        int[] r102 = g5.a(r110);
        int r103 = r102[0];
        int r104 = r102[1];
        return new LocalImageItem(r111, r101, r110.getRealPath(), r110.getName(), r110.toFile().length(), r103, r104);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.doc_cover_local_selection_fragment, r101, false);
    }
}
