package com.larus.bmhome.chat.standarduikit.localfileblock.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.mainbot.impl.databinding.LarusBlockItemPcLocalFileBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c;
import vl8.h;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tJF\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0018J\u0010\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\u0013J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\u0012\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010 \u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/localfileblock/view/PcLocalFileCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusBlockItemPcLocalFileBinding;", "isPreviewSupported", "", "isLoading", "isDownloaded", "downloadCompletedTask", "Ljava/lang/Runnable;", "trackingStatus", "", "isSourceDeviceOffline", "isClick", "bindData", "", "fileName", "fileType", "sourceDeviceName", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function1;", "updateSourceDevice", "deviceName", "updateDownloaded", "updateLoading", "recycle", "clearDownloadCompleted", "updateDownloadState", "startCompletionTimer", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcLocalFileCardView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f309475f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusBlockItemPcLocalFileBinding f309476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f309477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f309478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f309479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f309480e;

    public PcLocalFileCardView(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        LayoutInflater.from(r110).inflate(R.layout.larus_block_item_pc_local_file, this);
        int r111 = R.id.download_action;
        View r100 = ViewBindings.findChildViewById(this, R.id.download_action);
        if (r100 == null) goto L19;
        r111 = R.id.file_text;
        LinearLayout r101 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.file_text);
        if (r101 == null) goto L19;
        r111 = R.id.iv_download;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.iv_download);
        if (r102 == null) goto L19;
        r111 = R.id.iv_file_icon;
        SimpleDraweeView r103 = (SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.iv_file_icon);
        if (r103 == null) goto L19;
        r111 = R.id.loading_indicator;
        ProgressBar r104 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.loading_indicator);
        if (r104 == null) goto L19;
        r111 = R.id.tv_file_name;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_file_name);
        if (r105 == null) goto L19;
        r111 = R.id.tv_subtitle;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_subtitle);
        if (r106 == null) goto L19;
        this.f309476a = new LarusBlockItemPcLocalFileBinding(this, r100, r101, r102, r103, r104, r105, r106);
        setBackgroundResource(R.drawable.larus_pc_local_file_background);
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r111)));
    }

    public final void R5(boolean r100) {
        h r101 = this.f309480e;
        int r102 = 0;
        if (r101 != null) goto L5;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L14;
        if (r100 == false) goto L14;
        if (r101 == null) goto L14;
        postDelayed(r101, 3000);
    L14:
        AppCompatImageView r104 = this.f309476a.f358475d;
        if (r103 == false) goto L17;
        int r105 = R.drawable.larus_pc_remote_file_completed;
    L18:
        r104.setImageResource(r105);
        if (r103 == false) goto L21;
        int r106 = c.a(R.attr.larus_neutral_50, getContext(), R.color.larus_neutral_50);
    L22:
        this.f309476a.f358475d.setImageTintList(ColorStateList.valueOf(r106));
        ProgressBar r107 = this.f309476a.f358477f;
        if (this.f309478c == false) goto L25;
        int r108 = 0;
    L26:
        r107.setVisibility(r108);
        AppCompatImageView r109 = this.f309476a.f358475d;
        if (this.f309478c == false) goto L29;
        int r110 = 4;
    L35:
        r109.setVisibility(r110);
        View r111 = this.f309476a.f358473b;
        if (this.f309479d == false) goto L38;
        r102 = 8;
    L38:
        r111.setVisibility(r102);
        return;
    L29:
        if (r103 == false) goto L32;
    L34:
        r110 = 0;
        goto L35
    L32:
        if (this.f309479d == false) goto L34;
        r110 = 8;
        goto L35
    L25:
        r108 = 8;
        goto L26
    L21:
        r106 = c.a(R.attr.larus_neutral_70, getContext(), R.color.larus_neutral_70);
        goto L22
    L17:
        r105 = R.drawable.larus_pc_remote_file_download;
        goto L18
    L5:
        if (this.f309478c == true) goto L9;
        if (this.f309479d == false) goto L9;
        r103 = true;
        goto L10
    }

    public final void S5(boolean r100) {
        boolean r101 = this.f309479d;
        if (r101 == true) goto L6;
        if (r100 == false) goto L6;
        boolean r102 = true;
    L7:
        if (r101 == false) goto L15;
        if (r100 == true) goto L15;
        if (this.f309478c == true) goto L15;
        h r103 = this.f309480e;
        if (r103 == null) goto L14;
        removeCallbacks(r103);
    L14:
        this.f309480e = null;
    L15:
        this.f309479d = r100;
        R5(r102);
        return;
    L6:
        r102 = false;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [vl8.h] */
    public final void T5(boolean r100) {
        if (this.f309478c == false) goto L6;
        if (r100 == true) goto L6;
        boolean r101 = true;
    L7:
        if (r100 == false) goto L12;
        h r102 = this.f309480e;
        if (r102 == null) goto L11;
        removeCallbacks(r102);
    L11:
        this.f309480e = new h(this);
    L12:
        this.f309478c = r100;
        R5(r101);
        if (this.f309477b == true) goto L16;
        if (r100 == true) goto L16;
        float r103 = 0.4f;
    L17:
        this.f309476a.f358476e.setAlpha(r103);
        this.f309476a.f358474c.setAlpha(r103);
        this.f309476a.f358475d.setAlpha(r103);
        return;
    L16:
        r103 = 1.0f;
    L6:
        r101 = false;
        goto L7
    }

    public final void U5(String r100) {
        Context r101 = getContext();
        Object[] r102 = new Object[1];
        if (r100 == null) goto L5;
        String r103 = StringsKt.trim(r100).toString();
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r102[0] = r103;
        String r104 = StringsKt.trimEnd(r101.getString(R.string.larus_remote_file_view_detail_from_computer_cn, r102)).toString();
        this.f309476a.f358479h.setText(r104);
        setContentDescription(this.f309476a.f358478g.getText() + ", " + r104);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
