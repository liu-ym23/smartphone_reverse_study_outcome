package com.larus.bmhome.chat;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.databinding.LarusFragmentFilePreviewBinding;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.common_ui.view.FileExportType;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.nova.R;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/FilePreviewFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusFragmentFilePreviewBinding;", "filePath", "", "botId", "exportId", "previousPage", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onCloseAction", "onShareAction", "autoLogEnterPage", "", "getCurrentPageName", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "parseFileType", "Lcom/larus/common_ui/view/FileExportType;", "fileName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilePreviewFragment extends TraceFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f296924j = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusFragmentFilePreviewBinding f296925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f296926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f296927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f296928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f296929i;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return true;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "exporting_file_preview";
    }

    public final void U90() {
        String r100 = this.f296926f;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        FLogger.f375446a.e("FilePreviewFragment", "onShareAction, filePath empty");
        return;
    L12:
        String r102 = this.f296926f;
        String r103 = null;
        if (r102 == null) goto L15;
        r103 = StringsKt.substringAfterLast$default(r102, HTTP.URL_DEFAULT, null, 2, null);
    L15:
        String r110 = r103;
        ShareServiceDelegate r104 = ShareServiceDelegate.f313831b;
        Context r105 = getContext();
        String r111 = this.f296926f;
        IShareService.a.d(r104, r105, "more", "file", new com.larus.bmhome.share.panel.b(null, null, null, null, null, null, null, r111, r110, null, null, r111, r110, null, null, null, false, false, null, null, false, false, null, false, null, null, 67102335), null, 48);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public FilePreviewFragment() {
    }

    public static FileExportType V90(String r100) {
        String r101 = StringsKt.substringAfterLast$default(r100, ".", null, 2, null);
        FileExportType.Companion.getClass();
        Intrinsics.checkNotNullParameter(r101, "extension");
        switch(r101.hashCode()) {
            case 110834: goto L22;
            case 115312: goto L18;
            case 3088960: goto L14;
            case 3447940: goto L10;
            case 96948919: goto L6;
            default: goto L26;
        };
    L6:
        if (r101.equals("excel") == false) goto L26;
        return FileExportType.excel;
    L10:
        if (r101.equals(ExportFileExtension.PPTX) == false) goto L26;
        return FileExportType.pptx;
    L14:
        if (r101.equals(DocumentType.DOCX_NAME) == false) goto L26;
        return FileExportType.word;
    L18:
        if (r101.equals("txt") == false) goto L26;
        return FileExportType.txt;
    L22:
        if (r101.equals(ExportFileExtension.PDF) == false) goto L26;
        return FileExportType.pdf;
    L26:
        return FileExportType.unknown;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        com.larus.trace.tracknode.a.C4500a.a(this, r100);
        if (com.larus.utils.o0.d(this.f296929i) == false) goto L6;
        r100.put("previous_page", this.f296929i);
        return;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getString("arg_file_path", "");
    L6:
        this.f296926f = r103;
        Bundle r104 = getArguments();
        if (r104 == null) goto L9;
        String r105 = r104.getString("arg_bot_id", "");
    L10:
        this.f296927g = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L13;
        String r107 = r106.getString("arg_export_id", "");
    L14:
        this.f296928h = r107;
        Bundle r108 = getArguments();
        if (r108 == null) goto L17;
        r102 = r108.getString("arg_previous_page", "");
    L17:
        this.f296929i = r102;
        return;
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusFragmentFilePreviewBinding r102 = this.f296925e;
        LarusFragmentFilePreviewBinding r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L5:
        com.larus.utils.e1.d(r102.f310899b, new u2(this));
        String r104 = this.f296926f;
        if (r104 == null) goto L8;
        String r105 = StringsKt.substringAfterLast$default(r104, HTTP.URL_DEFAULT, null, 2, null);
    L9:
        if (r105 != null) goto L11;
    L14:
        boolean r106 = true;
    L15:
        if (r106 == false) goto L18;
        FLogger.f375446a.e("FilePreviewFragment", "fileName empty, filePath param: " + this.f296926f);
        return;
    L18:
        final FileExportType r107 = V90(r105);
        LarusFragmentFilePreviewBinding r108 = this.f296925e;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L21:
        com.larus.utils.e1.d(r108.f310900c, new v2(this, r107));
        LarusFragmentFilePreviewBinding r109 = this.f296925e;
        if (r109 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L24:
        r109.f310902e.setImageResource(r107.iconRes());
        LarusFragmentFilePreviewBinding r110 = this.f296925e;
        if (r110 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L27:
        r110.f310903f.setText(r105);
        LarusFragmentFilePreviewBinding r111 = this.f296925e;
        if (r111 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L31:
        com.larus.utils.e1.d(r103.f310904g, new w2(this, r107));
        return;
    L30:
        r103 = r111;
        goto L31
    L11:
        if (r105.length() == 0) goto L14;
        r106 = false;
        goto L15
    L8:
        r105 = null;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.inflate(R.layout.larus_fragment_file_preview, r110, false);
        int r112 = R.id.btn_close;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r101, R.id.btn_close);
        if (r102 == null) goto L21;
        r112 = R.id.btn_share;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r101, R.id.btn_share);
        if (r103 == null) goto L21;
        r112 = R.id.divider;
        View r104 = ViewBindings.findChildViewById(r101, R.id.divider);
        if (r104 == null) goto L21;
        r112 = R.id.fileIcon;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r101, R.id.fileIcon);
        if (r105 == null) goto L21;
        r112 = R.id.fileName;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r101, R.id.fileName);
        if (r106 == null) goto L21;
        r112 = R.id.preview;
        RoundTextView r107 = (RoundTextView) ViewBindings.findChildViewById(r101, R.id.preview);
        if (r107 == null) goto L21;
        r112 = R.id.previewContainer;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.previewContainer)) == null) goto L21;
        r112 = R.id.title_bar;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.title_bar)) == null) goto L21;
        FrameLayout r108 = (FrameLayout) r101;
        this.f296925e = new LarusFragmentFilePreviewBinding(r108, r102, r103, r104, r105, r106, r107);
        Intrinsics.checkNotNull(r108);
        r108.setTag(R.id.lib_track_tag_parent_track_node, this);
        return r108;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r112)));
    }
}
