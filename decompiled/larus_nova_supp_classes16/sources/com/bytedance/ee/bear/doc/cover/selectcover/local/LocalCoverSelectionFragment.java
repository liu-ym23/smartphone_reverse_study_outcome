package com.bytedance.ee.bear.doc.cover.selectcover.local;

import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.document.g5;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.api.FileType;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.vfs.VFSPath;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import s45.g;
import s45.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\rH\u0002J(\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/local/LocalCoverSelectionFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "mCoverViewModel", "Lcom/bytedance/ee/bear/doc/cover/CoverViewModel;", "fileSizeCheckListener", "Lcom/bytedance/ee/bear/fileselector/listener/IFileSizeCheckListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setTipText", "setTipTextStyle", "tipView", "Landroid/widget/TextView;", "text", "", "tipInfoStr", "tipLink", "openAlbumInner", "getAlbumFileSelectListener", "Lcom/bytedance/ee/bear/fileselector/api/IFileSelectListener;", "openCameraInner", "getCameraFileSelectListener", "file2ImageItem", "Lcom/bytedance/ee/bear/doc/cover/selectcover/local/LocalImageItem;", "path", "Lcom/ss/android/lark/vfs/VFSPath;", "imageType", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalCoverSelectionFragment extends BaseFragment {
    public static final /* synthetic */ int g = 0;
    public CoverViewModel e;
    public b f;

    public static final class a {
    }

    public static final class b implements bb5.c {
        public final /* synthetic */ LocalCoverSelectionFragment a;

        public b(LocalCoverSelectionFragment r1) {
            this.a = r1;
        }

        @Override // bb5.c
        public final void a(FileType r2) {
            Intrinsics.checkNotNullParameter(r2, "fileType");
            if (Intrinsics.areEqual("IMAGE", r2.name()) == false) goto L5;
            Toast.showFailureText(this.a.getContext(), 2131887173);
            return;
        L5:
            Toast.showFailureText(this.a.getContext(), 2131888966);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ LocalCoverSelectionFragment a;

        public c(LocalCoverSelectionFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            LocalCoverSelectionFragment r7 = this.a;
            int r0 = LocalCoverSelectionFragment.g;
            FragmentActivity r1 = r7.getActivity();
            if (r1 == null) goto L9;
            int r2 = com.bytedance.ee.bear.fileselector.d.a;
            FragmentManager r3 = r1.getSupportFragmentManager();
            FileSelectConfig.g r4 = FileSelectConfig.fullScreenAlbumBuilder();
            r4.a.fileSelectListener = new ly4.a(r7);
            b r8 = r7.f;
            if (r8 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("fileSizeCheckListener");
            r8 = null;
        L7:
            FileSelectConfig r5 = r4.a;
            r5.fileCheckListener = r8;
            r5.maxImageSize = 20971520;
            r5.enableImageCompress = true;
            r5.maxSelectImageNum = 1;
            r5.maxImageCompressSize = 20971520;
            r5.showGif = true;
            r5.showVideo = false;
            com.bytedance.ee.bear.fileselector.d.a.c(r1, r3, r4.a(), "DocCover_LocalCoverSelectionFragment");
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ LocalCoverSelectionFragment a;

        public d(LocalCoverSelectionFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            LocalCoverSelectionFragment r7 = this.a;
            int r0 = LocalCoverSelectionFragment.g;
            FragmentActivity r1 = r7.getActivity();
            if (r1 == null) goto L9;
            int r2 = com.bytedance.ee.bear.fileselector.d.a;
            FragmentManager r3 = r1.getSupportFragmentManager();
            FileSelectConfig.h r4 = FileSelectConfig.larkCamaraBuilder();
            FileSelectConfig r5 = r4.a;
            r5.enableImageCompress = true;
            r5.maxImageCompressSize = 20971520;
            r4.a.fileSelectListener = new ly4.b(r7);
            b r8 = r7.f;
            if (r8 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("fileSizeCheckListener");
            r8 = null;
        L7:
            r4.a.fileCheckListener = r8;
            com.bytedance.ee.bear.fileselector.d.a.c(r1, r3, r4.a(), "DocCover_LocalCoverSelectionFragment");
            return;
        }
    }

    static {
    }

    public LocalCoverSelectionFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.e = (CoverViewModel) q.a(this, CoverViewModel.class);
        this.f = new b(this);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super.onViewCreated(r13, r14);
        r13.findViewById(2131362450).setOnClickListener(new c(this));
        r13.findViewById(2131388170).setOnClickListener(new d(this));
        ((TextView) r13.findViewById(2131362489)).setTextColor(getResources().getColor(2131106622));
        ((TextView) r13.findViewById(2131388173)).setTextColor(getResources().getColor(2131106622));
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        r16.element = getResources().getString(2131887175) + ' ';
        String r9 = getResources().getString(2131889069);
        h r0 = g.a;
        String r10 = g.a.a("cover_help_center", "990851076781", "560882006899", null);
        TextView r17 = (TextView) r13.findViewById(2131390456);
        TextPaint r1 = r17.getPaint();
        int r2 = n.v();
        ViewGroup.LayoutParams r3 = r17.getLayoutParams();
        int r4 = 0;
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        int r5 = ((ViewGroup.MarginLayoutParams) r3).getMarginStart();
    L6:
        int r6 = r2 - r5;
        ViewGroup.LayoutParams r7 = r17.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r4 = ((ViewGroup.MarginLayoutParams) r7).getMarginEnd();
    L9:
        int r8 = r6 - r4;
        float r11 = r1.measureText((String) r16.element);
        float r12 = r1.measureText(r9);
        r17.getViewTreeObserver().addOnGlobalLayoutListener(new ly4.c(new Ref.BooleanRef(), r8, r11, r17, r12, r16, this, r9, r10));
        r17.setText((CharSequence) r16.element);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public static final LocalImageItem U90(LocalCoverSelectionFragment r9, VFSPath r10, String r11) {
        r9.getClass();
        String r2 = UUID.randomUUID().toString();
        int[] r12 = g5.a(r10);
        int r7 = r12[0];
        int r8 = r12[1];
        return new LocalImageItem(r11, r2, r10.getRealPath(), r10.getName(), r10.toFile().length(), r7, r8);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560074, r3, false);
    }
}
