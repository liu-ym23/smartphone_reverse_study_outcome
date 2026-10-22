package com.ss.android.lark.widget.photopicker.gallery.callback;

import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/widget/photopicker/gallery/callback/OnImageSelectListener;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "selectPosition", "", "position", "", "previousKey", "", "exitListener", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OnImageSelectListener extends Parcelable, Serializable {
    void exitListener(String r100);

    void selectPosition(int r100, String r101);
}
