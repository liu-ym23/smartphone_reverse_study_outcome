package com.ss.android.lark.widget.photo.preview.adapter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photo.preview.EnterSource;
import com.ss.android.lark.widget.photo.preview.PhotoPagerInitData;
import com.ss.android.lark.widget.photo.preview.callback.OperateListener;
import com.ss.android.lark.widget.photo.preview.d;
import com.ss.android.lark.widget.photo.preview.image.LargeImageFragment;
import com.ss.android.lark.widget.photo.preview.video.local.VideoGalleryFragment;
import com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFragment;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.f;
import com.ss.android.lark.widget.photopicker.gallery.NoPermissionFragment;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u000223B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013J \u0010\u001a\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020 H\u0016J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cJ\u0016\u0010%\u001a\u00020\u00182\u0006\u0010#\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020 H\u0016J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020 H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000fH\u0016J\u0016\u0010,\u001a\u00020\u00182\u0006\u0010#\u001a\u00020 2\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020\u0018J\u000e\u00100\u001a\u00020\u00182\u0006\u0010#\u001a\u00020 J\u0010\u00101\u001a\u00020 2\u0006\u0010#\u001a\u00020 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00160\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/adapter/PhotoPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "activity", "Landroidx/fragment/app/FragmentActivity;", "photoPagerInitData", "Lcom/ss/android/lark/widget/photo/preview/PhotoPagerInitData;", "iItemDependency", "Lcom/ss/android/lark/widget/photo/preview/adapter/PhotoPagerAdapter$IItemDependency;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/ss/android/lark/widget/photo/preview/PhotoPagerInitData;Lcom/ss/android/lark/widget/photo/preview/adapter/PhotoPagerAdapter$IItemDependency;)V", "mRequestCreator", "Lcom/ss/android/lark/image/api/IRequestCreator;", "kotlin.jvm.PlatformType", "mOuterEventListener", "Ljava/util/HashMap;", "", "Lcom/ss/android/lark/widget/photopicker/fragment/OnOuterEventListener;", "Lkotlin/collections/HashMap;", "mInfoView", "Landroid/view/View;", "mDiffer", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "setInfoView", "", "infoView", "setData", "list", "", "commitCallback", "Ljava/lang/Runnable;", "getItemCount", "", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "getCurrentList", "updatePageItem", "photoItem", "getItemId", "getItemIdV2", "containsItem", "", "itemId", "onPageScrolled", "positionOffsetPixels", "", "onGotoPhotoEdit", "onActivityFinish", "getItemViewType", "Companion", "IItemDependency", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoPagerAdapter extends FragmentStateAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PhotoPagerInitData f446586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f446587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IRequestCreator f446588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Long, hdc.a> f446589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f446590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AsyncListDiffer<PhotoItem> f446591f;

    public static final class a {
    }

    public interface b {
        void a();

        void b(PhotoItem r100);

        boolean onClick(View r100);
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f446591f.getCurrentList().size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final boolean containsItem(long r100) {
        Iterator<T> r101 = this.f446591f.getCurrentList().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L13;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        PhotoItem r105 = (PhotoItem) r103;
        if (getItemId(r102) == r100) goto L10;
        r102 = r104;
        goto L4
    L10:
        return true;
    L13:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final Fragment createFragment(int r110) {
        PhotoPagerAdapter r100 = this;
        PhotoItem r101 = (PhotoItem) ListProtector.get(r100.f446591f.getCurrentList(), r110);
        if (r101.isHasPreviewPermission() == true) goto L5;
    L23:
        Intrinsics.checkNotNull(r101);
        Fragment r102 = new NoPermissionFragment(r101);
    L24:
        r100.f446589d.put(Long.valueOf(getItemId(r110)), (hdc.a) r102);
        Log.i("PhotoPagerAdapter", "createFragment, position:" + r110 + ", itemId:" + getItemId(r110));
        return r102;
    L5:
        if (r101.hasReceivePermission() == false) goto L23;
        Intrinsics.checkNotNull(r101);
        if (fdc.a.a(r101) == true) goto L23;
        if (r101.isVideo() == true) goto L12;
        int r103 = LargeImageFragment.A;
        r100 = this;
        r102 = LargeImageFragment.a.a(r101, r100.f446586a, r100.f446587b, r100.f446590e);
        goto L24
    L12:
        if (r101.getPhoto() == null) goto L15;
        IRequestCreator r104 = r100.f446588c;
        VideoGalleryFragment r105 = new VideoGalleryFragment();
        r105.setArguments(new Bundle());
        r105.f447265d = r104;
        r105.f447266e = r101;
        r102 = r105;
        goto L24
    L15:
        if (r100.f446586a.isMute() == false) goto L17;
        int r106 = r100.f446586a.getCurrentItem();
    L18:
        if (r106 != r110) goto L20;
        boolean r107 = true;
    L21:
        boolean r108 = r100.f446586a.getShowJumpChatBtn();
        boolean r109 = r100.f446586a.getShowCopyImageButton();
        boolean r111 = r100.f446586a.getShowSaveButton();
        boolean r112 = r100.f446586a.getShowSaveToDriver();
        boolean r113 = r100.f446586a.getEnableLongClick();
        boolean r114 = r100.f446586a.getShowViewChatImage();
        boolean r115 = r100.f446586a.getAutoPlay();
        boolean r116 = r100.f446586a.getShowForwardButton();
        EnterSource r117 = r100.f446586a.getEnterSource();
        OperateListener r118 = r100.f446586a.getOperateListener();
        String r119 = r100.f446586a.getPreviewId();
        String r120 = r100.f446586a.getMsgLinkToken();
        OnlineVideoGalleryFragment r121 = new OnlineVideoGalleryFragment();
        Bundle r122 = new Bundle();
        r122.putBoolean("isMute", r107);
        r122.putBoolean("showViewChatImage", r114);
        r122.putBoolean("show_jump_chat", r108);
        r122.putBoolean("show_copy_video", r109);
        r122.putBoolean("show_save_video", r111);
        r122.putBoolean("show_save_to_driver", r112);
        r122.putSerializable("enable_long_click", Boolean.valueOf(r113));
        r122.putSerializable("operate_listener", r118);
        r122.putBoolean("auto_play", r115);
        r122.putString("preview_id", r119);
        r122.putString("msg_link_token", r120);
        r122.putBoolean("show_forward_btn", r116);
        r122.putSerializable(com.bytedance.android.ec.core.event.a.KEY_ENTER_SOURCE, r117);
        r121.setArguments(r122);
        r121.f447284p = r101;
        r100 = this;
        r102 = r121;
        goto L24
    L20:
        r107 = false;
        goto L21
    L17:
        r106 = -1;
        goto L18
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        if (f.a().t() == false) goto L13;
        PhotoItem r101 = (PhotoItem) CollectionsKt.getOrNull(this.f446591f.getCurrentList(), r100);
        if (r101 == null) goto L7;
        Long r102 = Long.valueOf(r101.f447478id);
    L8:
        Log.d("PhotoPagerAdapter", "getItem id:" + r102 + ", for " + r100);
        if (r102 == null) goto L12;
        return r102.longValue();
    L12:
        return super.getItemId(r100);
    L7:
        r102 = null;
        goto L8
    L13:
        PhotoItem r103 = (PhotoItem) CollectionsKt.getOrNull(this.f446591f.getCurrentList(), r100);
        if (r103 == null) goto L43;
        Serializable r104 = r103.getLoadModel();
        if (r104 == null) goto L43;
        String r105 = r103.getMessageId();
        if (TextUtils.isEmpty(r105) == false) goto L21;
        Iterator<T> r106 = this.f446591f.getCurrentList().iterator();
        int r107 = 0;
    L24:
        if (r106.hasNext() == false) goto L41;
        Object r108 = r106.next();
        int r109 = r107 + 1;
        if (r107 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        PhotoItem r110 = (PhotoItem) r108;
        if (r107 == r100) goto L39;
        Serializable r111 = r110.getLoadModel();
        if (r111 != null) goto L33;
    L35:
        boolean r112 = false;
    L36:
        if (r112 == false) goto L39;
        return ((long) r104.hashCode()) + ((long) r100);
    L33:
        if (r111.hashCode() != r104.hashCode()) goto L35;
        r112 = true;
    L39:
        r107 = r109;
        goto L24
    L41:
        return r104.hashCode();
    L21:
        return r104.hashCode() + r105.hashCode();
    L43:
        return super.getItemId(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        PhotoItem r101 = (PhotoItem) ListProtector.get(this.f446591f.getCurrentList(), r100);
        if (r101.isHasPreviewPermission() == false) goto L14;
        Intrinsics.checkNotNull(r101);
        if (fdc.a.a(r101) == true) goto L14;
        if (r101.isVideo() == true) goto L10;
        return 3;
    L10:
        if (r101.getPhoto() == null) goto L12;
        return 1;
    L12:
        return 2;
    L14:
        return 0;
    }

    public PhotoPagerAdapter(FragmentActivity r100, PhotoPagerInitData r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "photoPagerInitData");
        super(r100);
        this.f446586a = r101;
        this.f446587b = r102;
        this.f446588c = ImageLoader.with(r100);
        this.f446589d = new HashMap();
        this.f446591f = new AsyncListDiffer(this, new PhotoPagerAdapter$mDiffer$1());
    }
}
