package com.ss.android.lark.filedetail.impl.folder.manage.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.log.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\u0019\u001a\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\tR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/FileInfoAdapter;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FilePreviewInfo;", "<init>", "()V", "listener", "Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/FileInfoAdapter$OnItemSelectListener;", "layoutType", "", "binderFactory", "Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/AdapterBinderFactory;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "position", "onBindViewHolder", "", "holder", "setListener", "setLayoutViewType", "type", "getLayoutViewType", "Companion", "FileItemViewHolder", "ListFileItemViewHolder", "OnItemSelectListener", "FileLayoutType", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileInfoAdapter extends LarkRecyclerViewBaseAdapter<RecyclerView.ViewHolder, nfb.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f421660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f421661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AdapterBinderFactory f421662c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/FileInfoAdapter$FileItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "fileIcon", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "getFileIcon", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "fileTitle", "Landroid/widget/TextView;", "getFileTitle", "()Landroid/widget/TextView;", "fileSubtitle", "getFileSubtitle", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class FileItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LKUIRoundedImageView2 f421663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f421664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f421665c;

        public FileItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f421663a = (LKUIRoundedImageView2) r100.findViewById(R.id.file_icon_iv);
            this.f421664b = (TextView) r100.findViewById(R.id.file_title_tv);
            this.f421665c = (TextView) r100.findViewById(R.id.file_subtitle_tv);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/FileInfoAdapter$FileLayoutType;", "", "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface FileLayoutType {
        public static final a Companion = null;
        public static final int GRID_VIEW = 1;
        public static final int LIST_VIEW = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f421666a = null;

            static {
                f421666a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f421666a;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/FileInfoAdapter$ListFileItemViewHolder;", "Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/FileInfoAdapter$FileItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "videoPlayIcon", "Landroid/widget/ImageView;", "getVideoPlayIcon", "()Landroid/widget/ImageView;", "videoBg", "getVideoBg", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ListFileItemViewHolder extends FileItemViewHolder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f421667d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f421668e;

        public ListFileItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f421667d = (ImageView) r100.findViewById(R.id.preview_video_play_icon);
            this.f421668e = (ImageView) r100.findViewById(R.id.preview_video_bg);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(nfb.a r100);
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileInfoAdapter f421669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ nfb.a f421670b;

        public c(FileInfoAdapter r100, nfb.a r101) {
            this.f421669a = r100;
            this.f421670b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f421669a.f421660a;
            if (r101 == null) goto L5;
            nfb.a r102 = this.f421670b;
            Intrinsics.checkNotNull(r102);
            r101.a(r102);
            return;
        L5:
            Log.i("FileInfoAdapter", "listener is null");
        }
    }

    static {
    }

    public FileInfoAdapter() {
        this.f421662c = new AdapterBinderFactory();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return this.f421661b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        nfb.a r102 = getItem(r101);
        int r103 = this.f421661b;
        Object r104 = (com.ss.android.lark.filedetail.impl.folder.manage.adapter.b) ((Map) this.f421662c.f421659a.getValue()).get(Integer.valueOf(r103));
        if (r104 != null) goto L6;
        r104 = new jfb.c();
    L6:
        if ((r104 instanceof jfb.c) == false) goto L11;
        if ((r100 instanceof ListFileItemViewHolder) == false) goto L11;
        Intrinsics.checkNotNull(r102);
        ((jfb.c) r104).e((FileItemViewHolder) r100, r102);
    L15:
        r100.itemView.setOnClickListener(new c(this, r102));
        return;
    L11:
        if ((r104 instanceof jfb.b) == false) goto L15;
        if ((r100 instanceof FileItemViewHolder) == false) goto L15;
        Intrinsics.checkNotNull(r102);
        ((jfb.b) r104).e((FileItemViewHolder) r100, r102);
        goto L15
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        com.ss.android.lark.filedetail.impl.folder.manage.adapter.b r102 = (com.ss.android.lark.filedetail.impl.folder.manage.adapter.b) ((Map) this.f421662c.f421659a.getValue()).get(Integer.valueOf(r101));
        if (r102 != null) goto L6;
        r102 = new jfb.c();
    L6:
        return r102.a(r100);
    }
}
