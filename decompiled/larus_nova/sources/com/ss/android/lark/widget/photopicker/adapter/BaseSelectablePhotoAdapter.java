package com.ss.android.lark.widget.photopicker.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.photopicker.entity.PhotoDirectory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public abstract class BaseSelectablePhotoAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<PhotoDirectory> f447456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Photo> f447457b;

    public final boolean A2() {
        Iterator r100 = ((ArrayList) this.f447457b).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (((Photo) r100.next()).isVideo() == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final List<Photo> y2() {
        if (this.f447456a.size() <= 0) goto L7;
        return ((PhotoDirectory) ListProtector.get(this.f447456a, 0)).getPhotos();
    L7:
        return new ArrayList();
    }

    public final boolean z2() {
        Iterator r100 = ((ArrayList) this.f447457b).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (((Photo) r100.next()).isVideo() == true) goto L4;
        return true;
    L9:
        return false;
    }

    public BaseSelectablePhotoAdapter() {
        this.f447456a = new ArrayList();
        this.f447457b = new ArrayList();
    }
}
