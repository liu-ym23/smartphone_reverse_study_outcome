package com.bytedance.ee.bear.drive.view.preview.block;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.drive.biz.preview.block.DriveBlockTitleView;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import h95.a;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0007J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0007J\b\u0010\u0016\u001a\u00020\u0013H\u0007J\u0006\u0010\u0017\u001a\u00020\u0010J\b\u0010#\u001a\u00020\u0013H\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/block/DriveBlockPreviewVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "liveBlockState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/drive/view/preview/block/DriveBlockPreviewVM$BlockState;", "getLiveBlockState", "()Landroidx/lifecycle/MutableLiveData;", "blockClickInterceptors", "Ljava/util/HashSet;", "Lcom/bytedance/ee/bear/drive/view/preview/block/IBlockClickInterceptor;", "Lkotlin/collections/HashSet;", "getBlockClickInterceptors", "()Ljava/util/HashSet;", "isCompactStyle", "", "()Z", "addBlockClickInterceptor", "", "interceptor", "removeBlockClickInterceptor", "removeAllBlockClickInterceptor", "isFromBlockPreview", "enterFullScreen", "", "getEnterFullScreen", "blockTitleView", "Lcom/bytedance/ee/bear/drive/biz/preview/block/DriveBlockTitleView;", "getBlockTitleView", "()Lcom/bytedance/ee/bear/drive/biz/preview/block/DriveBlockTitleView;", "setBlockTitleView", "(Lcom/bytedance/ee/bear/drive/biz/preview/block/DriveBlockTitleView;)V", "blockTitleViewVisibility", "getBlockTitleViewVisibility", "onCleared", "BlockState", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveBlockPreviewVM extends ViewModel {
    private final HashSet<a> blockClickInterceptors;
    private DriveBlockTitleView blockTitleView;
    private final MutableLiveData<Boolean> blockTitleViewVisibility;
    private final MutableLiveData<Object> enterFullScreen;
    private final boolean isCompactStyle;
    private final MutableLiveData<BlockState> liveBlockState;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/block/DriveBlockPreviewVM$BlockState;", "", "<init>", "(Ljava/lang/String;I)V", "BLOCK", "FULLSCREEN", "ANIMATING", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BlockState extends Enum<BlockState> {
        public static final BlockState ANIMATING = null;
        public static final BlockState BLOCK = null;
        public static final BlockState FULLSCREEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BlockState[] f224775a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f224776b = null;

        public static EnumEntries<BlockState> getEntries() {
            return f224776b;
        }

        static {
            BlockState r100 = new BlockState("BLOCK", 0);
            BLOCK = r100;
            BlockState r101 = new BlockState("FULLSCREEN", 1);
            FULLSCREEN = r101;
            BlockState r102 = new BlockState("ANIMATING", 2);
            ANIMATING = r102;
            BlockState[] r103 = {r100, r101, r102};
            f224775a = r103;
            f224776b = EnumEntriesKt.enumEntries(r103);
        }

        public static BlockState[] values() {
            return (BlockState[]) f224775a.clone();
        }

        public static BlockState valueOf(String r100) {
            return (BlockState) r27.a.a(BlockState.class, r100);
        }

        public BlockState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean isFromBlockPreview() {
        if (this.liveBlockState.getValue() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void removeAllBlockClickInterceptor() {
        this.blockClickInterceptors.clear();
    }

    public DriveBlockPreviewVM() {
        this.liveBlockState = new MutableLiveData();
        this.blockClickInterceptors = new HashSet();
        this.isCompactStyle = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.doc.mobile.video_block_auto_fullscreen_play");
        this.enterFullScreen = new MutableLiveData();
        this.blockTitleViewVisibility = new MutableLiveData();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.blockTitleView = null;
        this.blockClickInterceptors.clear();
    }

    public final HashSet<a> getBlockClickInterceptors() {
        return this.blockClickInterceptors;
    }

    public final DriveBlockTitleView getBlockTitleView() {
        return this.blockTitleView;
    }

    public final MutableLiveData<Boolean> getBlockTitleViewVisibility() {
        return this.blockTitleViewVisibility;
    }

    public final MutableLiveData<Object> getEnterFullScreen() {
        return this.enterFullScreen;
    }

    public final MutableLiveData<BlockState> getLiveBlockState() {
        return this.liveBlockState;
    }

    public final boolean isCompactStyle() {
        return this.isCompactStyle;
    }

    public final void addBlockClickInterceptor(a r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.blockClickInterceptors.add(r100);
    }

    public final void removeBlockClickInterceptor(a r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.blockClickInterceptors.remove(r100);
    }

    public final void setBlockTitleView(DriveBlockTitleView r100) {
        this.blockTitleView = r100;
    }
}
