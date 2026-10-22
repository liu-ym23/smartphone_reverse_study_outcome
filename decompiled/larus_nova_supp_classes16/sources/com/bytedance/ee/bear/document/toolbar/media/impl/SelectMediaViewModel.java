package com.bytedance.ee.bear.document.toolbar.media.impl;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import ay4.d;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.g5;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.api.FileType;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.ss.android.lark.vfs.VFSPath;
import j45.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectMediaViewModel extends ViewModel {
    private static final int IMAGE_MAX_SIZE = 20971520;
    private static final String TAG = "SelectMediaViewModel";
    private static final long VIDEO_MAX_SIZE = -2147483648L;
    private b mDelegate;
    private c selectMediaListener;

    public class a extends za5.b {
        public final /* synthetic */ SelectMediaViewModel a;

        public a(SelectMediaViewModel r1) {
            this.a = r1;
        }

        @Override // za5.b, za5.a
        public final void c(List<? extends FileBean> r6) {
            ArrayList r0 = new ArrayList();
            Iterator<? extends FileBean> r7 = r6.iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            FileBean r1 = r7.next();
            r0.add(SelectMediaViewModel.access$000(this.a, d.a().z(r1.getPath()), r1));
            goto L4
        L6:
            SelectMediaViewModel.access$100(this.a, r0);
        }
    }

    public interface b {
    }

    public interface c {
        void a();
    }

    public static /* synthetic */ void Mo(SelectMediaViewModel r0) {
        r0.cancelFromMediaSelector();
    }

    public static /* synthetic */ void yo(SelectMediaViewModel r0, Context r1, FileType r2) {
        r0.lambda$getImageSizeCheckListener$0(r1, r2);
    }

    private void cancelFromMediaSelector() {
        b r0 = this.mDelegate;
        if (r0 == null) goto L5;
        ((i45.b.a) r0).a.c.a.c(new JSONObject());
        return;
    L5:
        tt5.a.d(TAG, "cancelFromMediaSelector(): fail caused by mDelegate is null");
    }

    private bb5.a getBackToPickerViewListener() {
        return new j45.d(this);
    }

    private za5.a getImageSelectListener() {
        return new a(this);
    }

    private boolean shouldShowVideo() {
        b r0 = this.mDelegate;
        if (r0 != null) goto L5;
        return false;
    L5:
        return ((i45.b.a) r0).a.c.a.b();
    }

    public SelectMediaViewModel() {
    }

    public b getDelegate() {
        return this.mDelegate;
    }

    private bb5.c getImageSizeCheckListener(final Context r2) {
        return new e(this, r2);
    }

    private void insertMedias(List<SelectedMediaItem> r3) {
        b r0 = this.mDelegate;
        if (r0 == null) goto L5;
        i45.b r1 = ((i45.b.a) r0).a;
        r1.b = r1.c.a.a(r3);
        return;
    L5:
        tt5.a.d(TAG, "insertMedias(): fail caused by mDelegate is null");
    }

    public void clearSelectMediaListener(c r2) {
        if (this.selectMediaListener != r2) goto L6;
        this.selectMediaListener = null;
        return;
    }

    public FileSelectConfig.e getDefaultBuilder(FragmentActivity r7) {
        FileSelectConfig.e r0 = FileSelectConfig.ccmAlbumBuilder();
        FileSelectConfig r1 = r0.a;
        r1.columnCount = 4;
        r1.showGif = true;
        r1.adjustHeightByKeyboard = true;
        boolean r2 = shouldShowVideo();
        FileSelectConfig r3 = r0.a;
        r3.showVideo = r2;
        r3.maxImageSize = IMAGE_MAX_SIZE;
        r3.maxVideoSize = VIDEO_MAX_SIZE;
        r3.enableImageCompress = true;
        r0.a.fileSelectListener = getImageSelectListener();
        r0.a.fileCheckListener = getImageSizeCheckListener(r7);
        r0.a.backToPickerViewListener = getBackToPickerViewListener();
        return r0;
    }

    public void setDelegate(b r1) {
        this.mDelegate = r1;
    }

    public void setSelectMediaListener(c r1) {
        this.selectMediaListener = r1;
    }

    public static /* synthetic */ void access$100(SelectMediaViewModel r0, List r1) {
        r0.insertMedias(r1);
    }

    private SelectedMediaItem files2MediaItems(VFSPath r13, FileBean r14) {
        String r3 = UUID.randomUUID().toString();
        int r0 = r14.getWidth();
        int r1 = r14.getHeight();
        if (r14.isVideo() == true) goto L9;
        int[] r2 = g5.a(r13);
        int r4 = r2[0];
        if (r4 <= 0) goto L9;
        int r5 = r2[1];
        if (r5 <= 0) goto L9;
        int r6 = r5;
        int r7 = r4;
    L11:
        return new SelectedMediaItem(r14.getMimeType(), r3, r13.getRealPath(), r7, r6, r14.getDuration(), r13.toFile().length(), r13.getName());
    L9:
        r7 = r0;
        r6 = r1;
        goto L11
    }

    private /* synthetic */ void lambda$getImageSizeCheckListener$0(Context r3, FileType r4) {
        if (FileType.VIDEO.name().equals(r4.name()) == false) goto L6;
        Toast.showFailureText(r3, 2131887456);
    L9:
        c r5 = this.selectMediaListener;
        if (r5 == null) goto L13;
        r5.a();
        return;
    L13:
        return;
    L6:
        if (FileType.IMAGE.name().equals(r4.name()) == false) goto L8;
        Toast.showFailureText(r3, 2131887173);
        goto L9
    L8:
        Toast.showFailureText(r3, 2131888966);
        goto L9
    }

    public FileSelectConfig.e getDefaultBuilder(FragmentActivity r6, boolean r7) {
        FileSelectConfig.e r0 = FileSelectConfig.ccmAlbumBuilder();
        FileSelectConfig r1 = r0.a;
        r1.columnCount = 4;
        r1.showGif = true;
        r1.adjustHeightByKeyboard = true;
        r1.showVideo = r7;
        r1.maxImageSize = IMAGE_MAX_SIZE;
        r1.maxVideoSize = VIDEO_MAX_SIZE;
        r1.enableImageCompress = true;
        r0.a.fileSelectListener = getImageSelectListener();
        r0.a.fileCheckListener = getImageSizeCheckListener(r6);
        r0.a.backToPickerViewListener = getBackToPickerViewListener();
        return r0;
    }

    public static /* synthetic */ SelectedMediaItem access$000(SelectMediaViewModel r0, VFSPath r1, FileBean r2) {
        return r0.files2MediaItems(r1, r2);
    }
}
