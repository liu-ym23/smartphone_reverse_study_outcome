package com.chad.library.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.animation.AlphaInAnimation;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.chad.library.adapter.base.animation.ScaleInAnimation;
import com.chad.library.adapter.base.animation.SlideInBottomAnimation;
import com.chad.library.adapter.base.animation.SlideInLeftAnimation;
import com.chad.library.adapter.base.animation.SlideInRightAnimation;
import com.chad.library.adapter.base.diff.BaseQuickAdapterListUpdateCallback;
import com.chad.library.adapter.base.diff.BaseQuickDiffCallback;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.chad.library.adapter.base.loadmore.SimpleLoadMoreView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public abstract class BaseQuickAdapter<T, K extends BaseViewHolder> extends RecyclerView.Adapter<K> {
    public static final int ALPHAIN = 1;
    public static final int EMPTY_VIEW = 1365;
    public static final int FOOTER_VIEW = 819;
    public static final int HEADER_VIEW = 273;
    public static final int LOADING_VIEW = 546;
    public static final int SCALEIN = 2;
    public static final int SLIDEIN_BOTTOM = 3;
    public static final int SLIDEIN_LEFT = 4;
    public static final int SLIDEIN_RIGHT = 5;
    protected static final String TAG = null;
    private boolean footerViewAsFlow;
    private boolean headerViewAsFlow;
    protected Context mContext;
    private BaseAnimation mCustomAnimation;
    protected List<T> mData;
    private int mDuration;
    private FrameLayout mEmptyLayout;
    private boolean mEnableLoadMoreEndClick;
    private boolean mFirstOnlyEnable;
    private boolean mFootAndEmptyEnable;
    private LinearLayout mFooterLayout;
    private boolean mHeadAndEmptyEnable;
    private LinearLayout mHeaderLayout;
    private Interpolator mInterpolator;
    private boolean mIsUseEmpty;
    private int mLastPosition;
    protected LayoutInflater mLayoutInflater;
    protected int mLayoutResId;
    private boolean mLoadMoreEnable;
    private LoadMoreView mLoadMoreView;
    private boolean mLoading;
    private boolean mNextLoadEnable;
    private OnItemChildClickListener mOnItemChildClickListener;
    private OnItemChildLongClickListener mOnItemChildLongClickListener;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private boolean mOpenAnimationEnable;
    private int mPreLoadNumber;
    private RecyclerView mRecyclerView;
    private RequestLoadMoreListener mRequestLoadMoreListener;
    private BaseAnimation mSelectAnimation;
    private SpanSizeLookup mSpanSizeLookup;
    private int mStartUpFetchPosition;
    private boolean mUpFetchEnable;
    private UpFetchListener mUpFetchListener;
    private boolean mUpFetching;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimationType {
    }

    public interface OnItemChildClickListener {
        void onItemChildClick(BaseQuickAdapter r100, View r101, int r102);
    }

    public interface OnItemChildLongClickListener {
        boolean onItemChildLongClick(BaseQuickAdapter r100, View r101, int r102);
    }

    public interface OnItemClickListener {
        void onItemClick(BaseQuickAdapter r100, View r101, int r102);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(BaseQuickAdapter r100, View r101, int r102);
    }

    public interface RequestLoadMoreListener {
        void onLoadMoreRequested();
    }

    public interface SpanSizeLookup {
        int getSpanSize(GridLayoutManager r100, int r101);
    }

    public interface UpFetchListener {
        void onUpFetch();
    }

    public void closeLoadAnimation() {
        this.mOpenAnimationEnable = false;
    }

    public abstract void convert(K r100, T r101);

    public void convertPayloads(K r100, T r101, List<Object> r102) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r100) {
        return r100;
    }

    public boolean isFixedViewType(int r100) {
        if (r100 != 1365) goto L5;
    L12:
        return true;
    L5:
        if (r100 == 273) goto L12;
        if (r100 == 819) goto L12;
        if (r100 == 546) goto L12;
        return false;
    }

    public void loadMoreEnd() {
        loadMoreEnd(false);
    }

    public void openLoadAnimation() {
        this.mOpenAnimationEnable = true;
    }

    static {
        TAG = "BaseQuickAdapter";
    }

    public void expandAll() {
        int r100 = (this.mData.size() - 1) + getHeaderLayoutCount();
    L4:
        if (r100 < getHeaderLayoutCount()) goto L6;
        expandAll(r100, false, false);
        r100 = r100 - 1;
        goto L4
    }

    public int getEmptyViewCount() {
        FrameLayout r100 = this.mEmptyLayout;
        if (r100 != null) goto L5;
    L15:
        return 0;
    L5:
        if (r100.getChildCount() == 0) goto L15;
        if (this.mIsUseEmpty == true) goto L11;
        return 0;
    L11:
        if (this.mData.size() == 0) goto L13;
        return 0;
    L13:
        return 1;
    }

    public int getFooterLayoutCount() {
        LinearLayout r100 = this.mFooterLayout;
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r100.getChildCount() == 0) goto L11;
        return 1;
    L11:
        return 0;
    }

    public int getHeaderLayoutCount() {
        LinearLayout r100 = this.mHeaderLayout;
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r100.getChildCount() == 0) goto L11;
        return 1;
    L11:
        return 0;
    }

    public int getLoadMoreViewCount() {
        if (this.mRequestLoadMoreListener != null) goto L5;
    L17:
        return 0;
    L5:
        if (this.mLoadMoreEnable == false) goto L17;
        if (this.mNextLoadEnable == true) goto L13;
        if (this.mLoadMoreView.isLoadEndMoreGone() == false) goto L13;
        return 0;
    L13:
        if (this.mData.size() != 0) goto L15;
        return 0;
    L15:
        return 1;
    }

    public void notifyLoadMoreToLoading() {
        if (this.mLoadMoreView.getLoadMoreStatus() != 2) goto L5;
        return;
    L5:
        this.mLoadMoreView.setLoadMoreStatus(1);
        notifyItemChanged(getLoadMoreViewPosition());
    }

    private void checkNotNull() {
        if (getRecyclerView() == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("please bind recyclerView first!");
    }

    private int getFooterViewPosition() {
        int r100 = 1;
        if (getEmptyViewCount() != 1) goto L15;
        if (this.mHeadAndEmptyEnable == false) goto L10;
        if (getHeaderLayoutCount() == 0) goto L10;
        r100 = 2;
    L10:
        if (this.mFootAndEmptyEnable == false) goto L12;
        return r100;
    L12:
        return -1;
    L15:
        return getHeaderLayoutCount() + this.mData.size();
    }

    private int getHeaderViewPosition() {
        if (getEmptyViewCount() == 1) goto L5;
        return 0;
    L5:
        if (this.mHeadAndEmptyEnable == false) goto L7;
        return 0;
    L7:
        return -1;
    }

    public void disableLoadMoreIfNotFullPage() {
        checkNotNull();
        disableLoadMoreIfNotFullPage(getRecyclerView());
    }

    public int getFooterViewsCount() {
        return getFooterLayoutCount();
    }

    public int getHeaderViewsCount() {
        return getHeaderLayoutCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int r100 = 1;
        if (1 == getEmptyViewCount()) goto L5;
        int r101 = (getHeaderLayoutCount() + this.mData.size()) + getFooterLayoutCount();
        return getLoadMoreViewCount() + r101;
    L5:
        if (this.mHeadAndEmptyEnable == false) goto L10;
        if (getHeaderLayoutCount() == 0) goto L10;
        r100 = 2;
    L10:
        if (this.mFootAndEmptyEnable == true) goto L12;
        return r100;
    L12:
        if (getFooterLayoutCount() != 0) goto L18;
        return r100;
    L18:
        return r100 + 1;
    }

    public int getLoadMoreViewPosition() {
        return (getHeaderLayoutCount() + this.mData.size()) + getFooterLayoutCount();
    }

    public void loadMoreComplete() {
        if (getLoadMoreViewCount() != 0) goto L5;
        return;
    L5:
        this.mLoading = false;
        this.mNextLoadEnable = true;
        this.mLoadMoreView.setLoadMoreStatus(1);
        notifyItemChanged(getLoadMoreViewPosition());
    }

    public void loadMoreFail() {
        if (getLoadMoreViewCount() != 0) goto L5;
        return;
    L5:
        this.mLoading = false;
        this.mLoadMoreView.setLoadMoreStatus(3);
        notifyItemChanged(getLoadMoreViewPosition());
    }

    public void removeAllFooterView() {
        if (getFooterLayoutCount() != 0) goto L5;
        return;
    L5:
        this.mFooterLayout.removeAllViews();
        int r100 = getFooterViewPosition();
        if (r100 == (-1)) goto L9;
        notifyItemRemoved(r100);
        return;
    }

    public void removeAllHeaderView() {
        if (getHeaderLayoutCount() != 0) goto L5;
        return;
    L5:
        this.mHeaderLayout.removeAllViews();
        int r100 = getHeaderViewPosition();
        if (r100 == (-1)) goto L9;
        notifyItemRemoved(r100);
        return;
    }

    public List<T> getData() {
        return this.mData;
    }

    public View getEmptyView() {
        return this.mEmptyLayout;
    }

    public LinearLayout getFooterLayout() {
        return this.mFooterLayout;
    }

    public LinearLayout getHeaderLayout() {
        return this.mHeaderLayout;
    }

    public final OnItemChildClickListener getOnItemChildClickListener() {
        return this.mOnItemChildClickListener;
    }

    public final OnItemChildLongClickListener getOnItemChildLongClickListener() {
        return this.mOnItemChildLongClickListener;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public boolean isFooterViewAsFlow() {
        return this.footerViewAsFlow;
    }

    public boolean isHeaderViewAsFlow() {
        return this.headerViewAsFlow;
    }

    public boolean isLoadMoreEnable() {
        return this.mLoadMoreEnable;
    }

    public boolean isLoading() {
        return this.mLoading;
    }

    public boolean isUpFetchEnable() {
        return this.mUpFetchEnable;
    }

    public boolean isUpFetching() {
        return this.mUpFetching;
    }

    public BaseQuickAdapter(int r100) {
        this(r100, null);
    }

    public static /* synthetic */ LoadMoreView access$200(BaseQuickAdapter r100) {
        return r100.mLoadMoreView;
    }

    public static /* synthetic */ boolean access$300(BaseQuickAdapter r100) {
        return r100.mEnableLoadMoreEndClick;
    }

    public static /* synthetic */ SpanSizeLookup access$400(BaseQuickAdapter r100) {
        return r100.mSpanSizeLookup;
    }

    public static /* synthetic */ RequestLoadMoreListener access$500(BaseQuickAdapter r100) {
        return r100.mRequestLoadMoreListener;
    }

    private void addAnimation(RecyclerView.ViewHolder r100) {
        if (this.mOpenAnimationEnable == true) goto L5;
        return;
    L5:
        if (this.mFirstOnlyEnable == true) goto L7;
    L8:
        BaseAnimation r101 = this.mCustomAnimation;
        if (r101 != null) goto L12;
        r101 = this.mSelectAnimation;
    L12:
        Animator[] r102 = r101.getAnimators(r100.itemView);
        int r103 = r102.length;
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L15;
        startAnim(r102[r104], r100.getLayoutPosition());
        r104 = r104 + 1;
        goto L13
    L15:
        this.mLastPosition = r100.getLayoutPosition();
        return;
    L7:
        if (r100.getLayoutPosition() > this.mLastPosition) goto L8;
    }

    private void autoLoadMore(int r100) {
        if (getLoadMoreViewCount() != 0) goto L6;
        return;
    L6:
        if (r100 >= (getItemCount() - this.mPreLoadNumber)) goto L9;
        return;
    L9:
        if (this.mLoadMoreView.getLoadMoreStatus() == 1) goto L11;
        return;
    L11:
        this.mLoadMoreView.setLoadMoreStatus(2);
        if (this.mLoading == true) goto L18;
        this.mLoading = true;
        if (getRecyclerView() == null) goto L16;
        getRecyclerView().post(new AnonymousClass7(this));
        return;
    L16:
        this.mRequestLoadMoreListener.onLoadMoreRequested();
        return;
    }

    private void autoUpFetch(int r100) {
        if (isUpFetchEnable() == true) goto L5;
        return;
    L5:
        if (isUpFetching() == false) goto L8;
        return;
    L8:
        if (r100 > this.mStartUpFetchPosition) goto L14;
        UpFetchListener r101 = this.mUpFetchListener;
        if (r101 == null) goto L15;
        r101.onUpFetch();
        return;
    L15:
        return;
    }

    private void compatibilityDataSizeChanged(int r100) {
        List<T> r101 = this.mData;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        if (r102 != r100) goto L9;
        notifyDataSetChanged();
        return;
    L9:
        return;
    L5:
        r102 = r101.size();
        goto L6
    }

    private IExpandable getExpandableItem(int r100) {
        T r101 = getItem(r100);
        if (isExpandable(r101) == true) goto L5;
        return null;
    L5:
        return (IExpandable) r101;
    }

    private Class getInstancedGenericKClass(Class r100) {
        Type r101 = r100.getGenericSuperclass();
        if ((r101 instanceof ParameterizedType) == false) goto L19;
        Type[] r102 = ((ParameterizedType) r101).getActualTypeArguments();
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L28;
        Type r105 = r102[r104];
        if ((r105 instanceof Class) == false) goto L12;
        Class r106 = (Class) r105;
        if (BaseViewHolder.class.isAssignableFrom(r106) == false) goto L18;
        return r106;
    L18:
        r104 = r104 + 1;
        goto L5
    L12:
        if ((r105 instanceof ParameterizedType) == false) goto L18;
        Type r107 = ((ParameterizedType) r105).getRawType();
        if ((r107 instanceof Class) == false) goto L18;
        Class r108 = (Class) r107;
        if (BaseViewHolder.class.isAssignableFrom(r108) == false) goto L18;
        return r108;
    L28:
        return null;
    L19:
        return null;
    }

    private int getItemPosition(T r100) {
        if (r100 == null) goto L8;
        List<T> r101 = this.mData;
        if (r101 == null) goto L8;
        if (r101.isEmpty() == true) goto L8;
        return this.mData.indexOf(r100);
    L8:
        return -1;
    }

    private K getLoadingView(ViewGroup r100) {
        K r101 = (K) createBaseViewHolder(getItemView(this.mLoadMoreView.getLayoutId(), r100));
        r101.itemView.setOnClickListener(new AnonymousClass3(this));
        return r101;
    }

    private int getTheBiggestNumber(int[] r100) {
        int r101 = -1;
        if (r100 != null) goto L5;
    L13:
        return r101;
    L5:
        if (r100.length == 0) goto L13;
        int r102 = r100.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L13;
        int r104 = r100[r103];
        if (r104 <= r101) goto L12;
        r101 = r104;
    L12:
        r103 = r103 + 1;
        goto L8
    }

    private boolean isFullScreen(LinearLayoutManager r100) {
        if ((r100.findLastCompletelyVisibleItemPosition() + 1) == getItemCount()) goto L5;
        return true;
    L5:
        if (r100.findFirstCompletelyVisibleItemPosition() != 0) goto L10;
        return false;
    L10:
        return true;
    }

    private void openLoadMore(RequestLoadMoreListener r100) {
        this.mRequestLoadMoreListener = r100;
        this.mNextLoadEnable = true;
        this.mLoadMoreEnable = true;
        this.mLoading = false;
    }

    private int recursiveCollapse(int r100) {
        T r101 = getItem(r100);
        if (r101 != null) goto L5;
    L20:
        return 0;
    L5:
        if (isExpandable(r101) == false) goto L20;
        IExpandable r102 = (IExpandable) r101;
        if (r102.isExpanded() == true) goto L10;
        return 0;
    L10:
        ArrayList r103 = new ArrayList();
        int r104 = r102.getLevel();
        int r105 = r100 + 1;
        int r106 = this.mData.size();
    L11:
        if (r105 >= r106) goto L18;
        Object r107 = ListProtector.get(this.mData, r105);
        if ((r107 instanceof IExpandable) == false) goto L17;
        if (((IExpandable) r107).getLevel() <= r104) goto L18;
    L17:
        r103.add(r107);
        r105 = r105 + 1;
    L18:
        this.mData.removeAll(r103);
        return r103.size();
    }

    private void setRecyclerView(RecyclerView r100) {
        this.mRecyclerView = r100;
    }

    public void addData(Collection<? extends T> r100) {
        this.mData.addAll(r100);
        notifyItemRangeInserted((this.mData.size() - r100.size()) + getHeaderLayoutCount(), r100.size());
        compatibilityDataSizeChanged(r100.size());
    }

    public int addFooterView(View r100) {
        return addFooterView(r100, -1, 1);
    }

    public int addHeaderView(View r100) {
        return addHeaderView(r100, -1);
    }

    public void bindToRecyclerView(RecyclerView r100) {
        if (getRecyclerView() == r100) goto L7;
        setRecyclerView(r100);
        getRecyclerView().setAdapter(this);
        return;
    L7:
        throw new IllegalStateException("Don't bind twice");
    }

    public void bindViewClickListener(final K r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        View r101 = r100.itemView;
        if (getOnItemClickListener() == null) goto L8;
        r101.setOnClickListener(new AnonymousClass5(this, r100));
    L8:
        if (getOnItemLongClickListener() == null) goto L11;
        r101.setOnLongClickListener(new AnonymousClass6(this, r100));
        return;
    }

    public int collapse(int r100) {
        return collapse(r100, true, true);
    }

    public K createBaseViewHolder(View r100) {
        Class<?> r101 = getClass();
        Class r102 = null;
    L3:
        if (r102 != null) goto L6;
        if (r101 == null) goto L6;
        r102 = getInstancedGenericKClass(r101);
        r101 = r101.getSuperclass();
    L6:
        if (r102 != null) goto L8;
        K r103 = (K) new BaseViewHolder(r100);
    L9:
        if (r103 == null) goto L12;
        return r103;
    L12:
        return (K) new BaseViewHolder(r100);
    L8:
        r103 = (K) createGenericKInstance(r102, r100);
        goto L9
    }

    public void disableLoadMoreIfNotFullPage(RecyclerView r100) {
        setEnableLoadMore(false);
        if (r100 != null) goto L5;
        return;
    L5:
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if (r101 != null) goto L9;
        return;
    L9:
        if ((r101 instanceof LinearLayoutManager) == false) goto L12;
        final LinearLayoutManager r102 = (LinearLayoutManager) r101;
        r100.postDelayed(new AnonymousClass1(this, r102), 50);
        return;
    L12:
        if ((r101 instanceof StaggeredGridLayoutManager) == false) goto L16;
        final StaggeredGridLayoutManager r103 = (StaggeredGridLayoutManager) r101;
        r100.postDelayed(new AnonymousClass2(this, r103), 50);
        return;
    }

    public void enableLoadMoreEndClick(boolean r100) {
        this.mEnableLoadMoreEndClick = r100;
    }

    public int expand(int r100) {
        return expand(r100, true, true);
    }

    public int getDefItemViewType(int r100) {
        return super.getItemViewType(r100);
    }

    public T getItem(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < this.mData.size()) goto L6;
        return null;
    L6:
        return (T) ListProtector.get(this.mData, r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        if (getEmptyViewCount() == 1) goto L5;
        int r101 = getHeaderLayoutCount();
        if (r100 >= r101) goto L26;
        return 273;
    L26:
        int r102 = r100 - r101;
        int r103 = this.mData.size();
        if (r102 >= r103) goto L31;
        return getDefItemViewType(r102);
    L31:
        if ((r102 - r103) >= getFooterLayoutCount()) goto L33;
        return 819;
    L33:
        return 546;
    L5:
        if (this.mHeadAndEmptyEnable == true) goto L7;
    L9:
        boolean r104 = false;
    L11:
        if (r100 == 0) goto L20;
        if (r100 != 1) goto L14;
        if (r104 == false) goto L19;
        return EMPTY_VIEW;
    L19:
        return 819;
    L14:
        if (r100 == 2) goto L16;
        return EMPTY_VIEW;
    L16:
        return 819;
    L20:
        if (r104 == false) goto L22;
        return 273;
    L22:
        return EMPTY_VIEW;
    L7:
        if (getHeaderLayoutCount() == 0) goto L9;
        r104 = true;
        goto L11
    }

    public int getParentPosition(T r100) {
        int r101 = getItemPosition(r100);
        if (r101 != (-1)) goto L6;
        return -1;
    L6:
        if ((r100 instanceof IExpandable) == false) goto L8;
        int r102 = ((IExpandable) r100).getLevel();
    L9:
        if (r102 != 0) goto L11;
        return r101;
    L11:
        if (r102 != (-1)) goto L13;
        return -1;
    L13:
        if (r101 < 0) goto L22;
        Object r103 = ListProtector.get(this.mData, r101);
        if ((r103 instanceof IExpandable) == false) goto L21;
        IExpandable r104 = (IExpandable) r103;
        if (r104.getLevel() < 0) goto L21;
        if (r104.getLevel() >= r102) goto L21;
        return r101;
    L21:
        r101 = r101 - 1;
        goto L13
    L22:
        return -1;
    L8:
        r102 = Integer.MAX_VALUE;
        goto L9
    }

    public boolean hasSubItems(IExpandable r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        List<T> r101 = r100.getSubItems();
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.size() <= 0) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean isExpandable(T r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if ((r100 instanceof IExpandable) == false) goto L6;
        return true;
    }

    public void isFirstOnly(boolean r100) {
        this.mFirstOnlyEnable = r100;
    }

    public void isUseEmpty(boolean r100) {
        this.mIsUseEmpty = r100;
    }

    public void loadMoreEnd(boolean r100) {
        if (getLoadMoreViewCount() != 0) goto L5;
        return;
    L5:
        this.mLoading = false;
        this.mNextLoadEnable = false;
        this.mLoadMoreView.setLoadMoreEndGone(r100);
        if (r100 == false) goto L8;
        notifyItemRemoved(getLoadMoreViewPosition());
        return;
    L8:
        this.mLoadMoreView.setLoadMoreStatus(4);
        notifyItemChanged(getLoadMoreViewPosition());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView r100) {
        super.onAttachedToRecyclerView(r100);
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof GridLayoutManager) == false) goto L6;
        final GridLayoutManager r102 = (GridLayoutManager) r101;
        final GridLayoutManager.SpanSizeLookup r103 = r102.getSpanSizeLookup();
        r102.setSpanSizeLookup(new AnonymousClass4(this, r102, r103));
        return;
    }

    public void onViewAttachedToWindow(K r100) {
        super.onViewAttachedToWindow(r100);
        int r101 = r100.getItemViewType();
        if (r101 != 1365) goto L5;
    L12:
        setFullSpan(r100);
        return;
    L5:
        if (r101 == 273) goto L12;
        if (r101 == 819) goto L12;
        if (r101 == 546) goto L12;
        addAnimation(r100);
    }

    public void openLoadAnimation(int r100) {
        this.mOpenAnimationEnable = true;
        this.mCustomAnimation = null;
        if (r100 != 1) goto L5;
        this.mSelectAnimation = new AlphaInAnimation();
        return;
    L5:
        if (r100 != 2) goto L7;
        this.mSelectAnimation = new ScaleInAnimation();
        return;
    L7:
        if (r100 != 3) goto L9;
        this.mSelectAnimation = new SlideInBottomAnimation();
        return;
    L9:
        if (r100 != 4) goto L11;
        this.mSelectAnimation = new SlideInLeftAnimation();
        return;
    L11:
        if (r100 != 5) goto L23;
        this.mSelectAnimation = new SlideInRightAnimation();
        return;
    }

    public final void refreshNotifyItemChanged(int r100) {
        notifyItemChanged(r100 + getHeaderLayoutCount());
    }

    public void remove(int r100) {
        ListProtector.remove(this.mData, r100);
        int r101 = r100 + getHeaderLayoutCount();
        notifyItemRemoved(r101);
        compatibilityDataSizeChanged(0);
        notifyItemRangeChanged(r101, this.mData.size() - r101);
    }

    public void removeFooterView(View r100) {
        if (getFooterLayoutCount() != 0) goto L5;
        return;
    L5:
        this.mFooterLayout.removeView(r100);
        if (this.mFooterLayout.getChildCount() != 0) goto L11;
        int r101 = getFooterViewPosition();
        if (r101 == (-1)) goto L12;
        notifyItemRemoved(r101);
        return;
    L12:
        return;
    }

    public void removeHeaderView(View r100) {
        if (getHeaderLayoutCount() != 0) goto L5;
        return;
    L5:
        this.mHeaderLayout.removeView(r100);
        if (this.mHeaderLayout.getChildCount() != 0) goto L11;
        int r101 = getHeaderViewPosition();
        if (r101 == (-1)) goto L12;
        notifyItemRemoved(r101);
        return;
    L12:
        return;
    }

    public void replaceData(Collection<? extends T> r100) {
        List<T> r101 = this.mData;
        if (r100 == r101) goto L5;
        r101.clear();
        this.mData.addAll(r100);
    L5:
        notifyDataSetChanged();
    }

    public void setAutoLoadMoreSize(int r100) {
        setPreLoadNumber(r100);
    }

    public void setDuration(int r100) {
        this.mDuration = r100;
    }

    public void setEmptyView(View r100) {
        int r101 = getItemCount();
        int r102 = 1;
        if (this.mEmptyLayout != null) goto L8;
        this.mEmptyLayout = new FrameLayout(r100.getContext());
        RecyclerView.LayoutParams r103 = new RecyclerView.LayoutParams(-1, -1);
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
        if (r104 == null) goto L7;
        ((ViewGroup.MarginLayoutParams) r103).width = r104.width;
        ((ViewGroup.MarginLayoutParams) r103).height = r104.height;
    L7:
        this.mEmptyLayout.setLayoutParams(r103);
        boolean r105 = true;
    L9:
        this.mEmptyLayout.removeAllViews();
        this.mEmptyLayout.addView(r100);
        this.mIsUseEmpty = true;
        if (r105 == true) goto L12;
        return;
    L12:
        if (getEmptyViewCount() == 1) goto L14;
        return;
    L14:
        if (this.mHeadAndEmptyEnable == true) goto L16;
    L18:
        r102 = 0;
    L20:
        if (getItemCount() <= r101) goto L22;
        notifyItemInserted(r102);
        return;
    L22:
        notifyDataSetChanged();
        return;
    L16:
        if (getHeaderLayoutCount() == 0) goto L18;
    L8:
        r105 = false;
        goto L9
    }

    public void setEnableLoadMore(boolean r100) {
        int r101 = getLoadMoreViewCount();
        this.mLoadMoreEnable = r100;
        int r102 = getLoadMoreViewCount();
        if (r101 != 1) goto L6;
        if (r102 != 0) goto L9;
        notifyItemRemoved(getLoadMoreViewPosition());
        return;
    L9:
        return;
    L6:
        if (r102 != 1) goto L11;
        this.mLoadMoreView.setLoadMoreStatus(1);
        notifyItemInserted(getLoadMoreViewPosition());
        return;
    }

    public int setFooterView(View r100) {
        return setFooterView(r100, 0, 1);
    }

    public void setFooterViewAsFlow(boolean r100) {
        this.footerViewAsFlow = r100;
    }

    public void setFullSpan(RecyclerView.ViewHolder r100) {
        if ((r100.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L6;
        ((StaggeredGridLayoutManager.LayoutParams) r100.itemView.getLayoutParams()).setFullSpan(true);
        return;
    }

    public void setHeaderAndEmpty(boolean r100) {
        setHeaderFooterEmpty(r100, false);
    }

    public int setHeaderView(View r100) {
        return setHeaderView(r100, 0, 1);
    }

    public void setHeaderViewAsFlow(boolean r100) {
        this.headerViewAsFlow = r100;
    }

    public void setLoadMoreView(LoadMoreView r100) {
        this.mLoadMoreView = r100;
    }

    public void setNewData(List<T> r100) {
        if (r100 != null) goto L4;
        r100 = new ArrayList();
    L4:
        this.mData = r100;
        if (this.mRequestLoadMoreListener == null) goto L7;
        this.mNextLoadEnable = true;
        this.mLoadMoreEnable = true;
        this.mLoading = false;
        this.mLoadMoreView.setLoadMoreStatus(1);
    L7:
        this.mLastPosition = -1;
        notifyDataSetChanged();
    }

    public void setNewDiffData(BaseQuickDiffCallback<T> r100) {
        setNewDiffData(r100, false);
    }

    public void setNotDoAnimationCount(int r100) {
        this.mLastPosition = r100;
    }

    public void setOnItemChildClickListener(OnItemChildClickListener r100) {
        this.mOnItemChildClickListener = r100;
    }

    public void setOnItemChildLongClickListener(OnItemChildLongClickListener r100) {
        this.mOnItemChildLongClickListener = r100;
    }

    public void setOnItemClickListener(OnItemClickListener r100) {
        this.mOnItemClickListener = r100;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener r100) {
        this.mOnItemLongClickListener = r100;
    }

    public void setOnLoadMoreListener(RequestLoadMoreListener r100) {
        openLoadMore(r100);
    }

    public void setPreLoadNumber(int r100) {
        if (r100 <= 1) goto L6;
        this.mPreLoadNumber = r100;
        return;
    }

    public void setSpanSizeLookup(SpanSizeLookup r100) {
        this.mSpanSizeLookup = r100;
    }

    public void setStartUpFetchPosition(int r100) {
        this.mStartUpFetchPosition = r100;
    }

    public void setUpFetchEnable(boolean r100) {
        this.mUpFetchEnable = r100;
    }

    public void setUpFetchListener(UpFetchListener r100) {
        this.mUpFetchListener = r100;
    }

    public void setUpFetching(boolean r100) {
        this.mUpFetching = r100;
    }

    public BaseQuickAdapter(List<T> r100) {
        this(0, r100);
    }

    public void addData(T r100) {
        this.mData.add(r100);
        notifyItemInserted(this.mData.size() + getHeaderLayoutCount());
        compatibilityDataSizeChanged(1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        onViewAttachedToWindow((BaseViewHolder) r100);
    }

    public void openLoadAnimation(BaseAnimation r100) {
        this.mOpenAnimationEnable = true;
        this.mCustomAnimation = r100;
    }

    public void setEmptyView(int r100) {
        checkNotNull();
        setEmptyView(r100, getRecyclerView());
    }

    public BaseQuickAdapter(int r100, List<T> r101) {
        this.mNextLoadEnable = false;
        this.mLoadMoreEnable = false;
        this.mLoading = false;
        this.mLoadMoreView = new SimpleLoadMoreView();
        this.mEnableLoadMoreEndClick = false;
        this.mFirstOnlyEnable = true;
        this.mOpenAnimationEnable = false;
        this.mInterpolator = new LinearInterpolator();
        this.mDuration = 300;
        this.mLastPosition = -1;
        this.mSelectAnimation = new AlphaInAnimation();
        this.mIsUseEmpty = true;
        this.mPreLoadNumber = 1;
        this.mStartUpFetchPosition = 1;
        if (r101 != null) goto L5;
        r101 = new ArrayList();
    L5:
        this.mData = r101;
        if (r100 == 0) goto L9;
        this.mLayoutResId = r100;
        return;
    }

    public static /* synthetic */ boolean access$000(BaseQuickAdapter r100, LinearLayoutManager r101) {
        return r100.isFullScreen(r101);
    }

    public static /* synthetic */ int access$100(BaseQuickAdapter r100, int[] r101) {
        return r100.getTheBiggestNumber(r101);
    }

    private K createGenericKInstance(Class r100, View r101) {
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L3:
        if (r100.isMemberClass() == true) goto L5;
    L8:
        Constructor<T> r102 = r100.getDeclaredConstructor(new Class[]{View.class});     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
        r102.setAccessible(true);     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
        return (K) r102.newInstance(new Object[]{r101});
    L5:
        if (Modifier.isStatic(r100.getModifiers()) == true) goto L8;
        Constructor<T> r103 = r100.getDeclaredConstructor(new Class[]{getClass(), View.class});     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
        r103.setAccessible(true);     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
        return (K) r103.newInstance(new Object[]{this, r101});
    }

    private int recursiveExpand(int r100, List r101) {
        int r102 = r101.size();
        int r103 = (r100 + r101.size()) - 1;
        int r104 = r101.size() - 1;
    L3:
        if (r104 < 0) goto L12;
        if ((ListProtector.get(r101, r104) instanceof IExpandable) == false) goto L11;
        IExpandable r105 = (IExpandable) ListProtector.get(r101, r104);
        if (r105.isExpanded() == false) goto L11;
        if (hasSubItems(r105) == false) goto L11;
        List<T> r106 = r105.getSubItems();
        int r107 = r103 + 1;
        this.mData.addAll(r107, r106);
        r102 = r102 + recursiveExpand(r107, r106);
    L11:
        r104 = r104 - 1;
        r103 = r103 - 1;
        goto L3
    L12:
        return r102;
    }

    public void add(int r100, T r101) {
        addData(r100, r101);
    }

    public void addData(int r100, Collection<? extends T> r101) {
        this.mData.addAll(r100, r101);
        notifyItemRangeInserted(r100 + getHeaderLayoutCount(), r101.size());
        compatibilityDataSizeChanged(r101.size());
    }

    public int addFooterView(View r100, int r101) {
        return addFooterView(r100, r101, 1);
    }

    public int addHeaderView(View r100, int r101) {
        return addHeaderView(r100, r101, 1);
    }

    public int collapse(int r100, boolean r101) {
        return collapse(r100, r101, true);
    }

    public K createBaseViewHolder(ViewGroup r100, int r101) {
        return (K) createBaseViewHolder(getItemView(r101, r100));
    }

    public int expand(int r100, boolean r101) {
        return expand(r100, r101, true);
    }

    public int expandAll(int r100, boolean r101) {
        return expandAll(r100, true, !r101);
    }

    public View getItemView(int r100, ViewGroup r101) {
        return this.mLayoutInflater.inflate(r100, r101, false);
    }

    public View getViewByPosition(int r100, int r101) {
        checkNotNull();
        return getViewByPosition(getRecyclerView(), r100, r101);
    }

    public void onBindViewHolder(K r100, int r101) {
        autoUpFetch(r101);
        autoLoadMore(r101);
        int r102 = r100.getItemViewType();
        if (r102 != 0) goto L5;
        convert(r100, getItem(r101 - getHeaderLayoutCount()));
        return;
    L5:
        if (r102 != 273) goto L7;
        return;
    L7:
        if (r102 != 546) goto L9;
        this.mLoadMoreView.convert(r100);
        return;
    L9:
        if (r102 != 819) goto L11;
        return;
    L11:
        if (r102 == 1365) goto L18;
        convert(r100, getItem(r101 - getHeaderLayoutCount()));
        return;
    }

    public K onCreateDefViewHolder(ViewGroup r100, int r101) {
        return (K) createBaseViewHolder(r100, this.mLayoutResId);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public K onCreateViewHolder(ViewGroup r100, int r101) {
        Context r102 = r100.getContext();
        this.mContext = r102;
        this.mLayoutInflater = LayoutInflater.from(r102);
        if (r101 != 273) goto L5;
        ViewParent r103 = this.mHeaderLayout.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L23;
        ((ViewGroup) r103).removeView(this.mHeaderLayout);
    L23:
        K r104 = (K) createBaseViewHolder(this.mHeaderLayout);
    L24:
        r104.setAdapter(this);
        return r104;
    L5:
        if (r101 != 546) goto L7;
        r104 = (K) getLoadingView(r100);
        goto L24
    L7:
        if (r101 != 819) goto L9;
        ViewParent r105 = this.mFooterLayout.getParent();
        if ((r105 instanceof ViewGroup) == false) goto L18;
        ((ViewGroup) r105).removeView(this.mFooterLayout);
    L18:
        r104 = (K) createBaseViewHolder(this.mFooterLayout);
        goto L24
    L9:
        if (r101 == 1365) goto L11;
        r104 = (K) onCreateDefViewHolder(r100, r101);
        bindViewClickListener(r104);
        goto L24
    L11:
        ViewParent r106 = this.mEmptyLayout.getParent();
        if ((r106 instanceof ViewGroup) == false) goto L14;
        ((ViewGroup) r106).removeView(this.mEmptyLayout);
    L14:
        r104 = (K) createBaseViewHolder(this.mEmptyLayout);
        goto L24
    }

    public final void refreshNotifyItemChanged(int r100, Object r101) {
        notifyItemChanged(r100 + getHeaderLayoutCount(), r101);
    }

    public void setData(int r100, T r101) {
        ListProtector.set(this.mData, r100, r101);
        notifyItemChanged(r100 + getHeaderLayoutCount());
    }

    public void setEmptyView(int r100, ViewGroup r101) {
        setEmptyView(LayoutInflater.from(r101.getContext()).inflate(r100, r101, false));
    }

    public int setFooterView(View r100, int r101) {
        return setFooterView(r100, r101, 1);
    }

    public void setHeaderFooterEmpty(boolean r100, boolean r101) {
        this.mHeadAndEmptyEnable = r100;
        this.mFootAndEmptyEnable = r101;
    }

    public int setHeaderView(View r100, int r101) {
        return setHeaderView(r100, r101, 1);
    }

    public void setNewDiffData(BaseQuickDiffCallback<T> r100, boolean r101) {
        if (getEmptyViewCount() != 1) goto L6;
        setNewData(r100.getNewList());
        return;
    L6:
        r100.setOldList(getData());
        DiffUtil.calculateDiff(r100, r101).dispatchUpdatesTo(new BaseQuickAdapterListUpdateCallback(this));
        this.mData = r100.getNewList();
    }

    public void setOnItemClick(View r100, int r101) {
        getOnItemClickListener().onItemClick(this, r100, r101);
    }

    public boolean setOnItemLongClick(View r100, int r101) {
        return getOnItemLongClickListener().onItemLongClick(this, r100, r101);
    }

    public void setOnLoadMoreListener(RequestLoadMoreListener r100, RecyclerView r101) {
        openLoadMore(r100);
        if (getRecyclerView() != null) goto L6;
        setRecyclerView(r101);
        return;
    }

    public void startAnim(Animator r100, int r101) {
        r100.setDuration(this.mDuration).start();
        r100.setInterpolator(this.mInterpolator);
    }

    public void addData(int r100, T r101) {
        ListProtector.add(this.mData, r100, r101);
        notifyItemInserted(r100 + getHeaderLayoutCount());
        compatibilityDataSizeChanged(1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        onBindViewHolder((BaseViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return onCreateViewHolder(r100, r101);
    }

    public void setNewDiffData(DiffUtil.DiffResult r100, List<T> r101) {
        if (getEmptyViewCount() != 1) goto L6;
        setNewData(r101);
        return;
    L6:
        r100.dispatchUpdatesTo(new BaseQuickAdapterListUpdateCallback(this));
        this.mData = r101;
    }

    public int addFooterView(View r100, int r101, int r102) {
        if (this.mFooterLayout != null) goto L8;
        LinearLayout r103 = new LinearLayout(r100.getContext());
        this.mFooterLayout = r103;
        if (r102 != 1) goto L7;
        r103.setOrientation(1);
        this.mFooterLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        goto L8
    L7:
        r103.setOrientation(0);
        this.mFooterLayout.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
    L8:
        int r104 = this.mFooterLayout.getChildCount();
        if (r101 < 0) goto L11;
        if (r101 > r104) goto L11;
    L12:
        this.mFooterLayout.addView(r100, r101);
        if (this.mFooterLayout.getChildCount() != 1) goto L17;
        int r105 = getFooterViewPosition();
        if (r105 == (-1)) goto L17;
        notifyItemInserted(r105);
    L17:
        return r101;
    L11:
        r101 = r104;
        goto L12
    }

    public int addHeaderView(View r100, int r101, int r102) {
        if (this.mHeaderLayout != null) goto L8;
        LinearLayout r103 = new LinearLayout(r100.getContext());
        this.mHeaderLayout = r103;
        if (r102 != 1) goto L7;
        r103.setOrientation(1);
        this.mHeaderLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        goto L8
    L7:
        r103.setOrientation(0);
        this.mHeaderLayout.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
    L8:
        int r104 = this.mHeaderLayout.getChildCount();
        if (r101 < 0) goto L11;
        if (r101 > r104) goto L11;
    L12:
        this.mHeaderLayout.addView(r100, r101);
        if (this.mHeaderLayout.getChildCount() != 1) goto L17;
        int r105 = getHeaderViewPosition();
        if (r105 == (-1)) goto L17;
        notifyItemInserted(r105);
    L17:
        return r101;
    L11:
        r101 = r104;
        goto L12
    }

    public int collapse(int r100, boolean r101, boolean r102) {
        int r103 = r100 - getHeaderLayoutCount();
        IExpandable r104 = getExpandableItem(r103);
        if (r104 != null) goto L5;
        return 0;
    L5:
        int r105 = recursiveCollapse(r103);
        r104.setExpanded(false);
        int r106 = r103 + getHeaderLayoutCount();
        if (r102 == false) goto L10;
        if (r101 == false) goto L9;
        notifyItemChanged(r106);
        notifyItemRangeRemoved(r106 + 1, r105);
        goto L10
    L9:
        notifyDataSetChanged();
    L10:
        return r105;
    }

    public int expand(int r100, boolean r101, boolean r102) {
        int r103 = r100 - getHeaderLayoutCount();
        IExpandable r104 = getExpandableItem(r103);
        int r105 = 0;
        if (r104 != null) goto L6;
        return 0;
    L6:
        if (hasSubItems(r104) == true) goto L10;
        r104.setExpanded(true);
        notifyItemChanged(r103);
        return 0;
    L10:
        if (r104.isExpanded() == true) goto L12;
        List<T> r106 = r104.getSubItems();
        int r107 = r103 + 1;
        this.mData.addAll(r107, r106);
        r105 = 0 + recursiveExpand(r107, r106);
        r104.setExpanded(true);
    L12:
        int r108 = r103 + getHeaderLayoutCount();
        if (r102 == false) goto L17;
        if (r101 == false) goto L16;
        notifyItemChanged(r108);
        notifyItemRangeInserted(r108 + 1, r105);
        goto L17
    L16:
        notifyDataSetChanged();
    L17:
        return r105;
    }

    public int expandAll(int r100, boolean r101, boolean r110) {
        int r102 = r100 - getHeaderLayoutCount();
        int r103 = r102 + 1;
        if (r103 >= this.mData.size()) goto L5;
        T r104 = getItem(r103);
    L6:
        IExpandable r105 = getExpandableItem(r102);
        if (r105 != null) goto L10;
        return 0;
    L10:
        if (hasSubItems(r105) == true) goto L13;
        r105.setExpanded(true);
        notifyItemChanged(r102);
        return 0;
    L13:
        int r106 = expand(getHeaderLayoutCount() + r102, false, false);
    L15:
        if (r103 >= this.mData.size()) goto L25;
        T r107 = getItem(r103);
        if (r107 == null) goto L22;
        if (r107.equals(r104) == true) goto L25;
    L22:
        if (isExpandable(r107) == false) goto L24;
        r106 = r106 + expand(getHeaderLayoutCount() + r103, false, false);
    L24:
        r103 = r103 + 1;
    L25:
        if (r110 == false) goto L29;
        if (r101 == false) goto L28;
        notifyItemRangeInserted((r102 + getHeaderLayoutCount()) + 1, r106);
        goto L29
    L28:
        notifyDataSetChanged();
    L29:
        return r106;
    L5:
        r104 = null;
        goto L6
    }

    public View getViewByPosition(RecyclerView r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        BaseViewHolder r103 = (BaseViewHolder) r100.findViewHolderForLayoutPosition(r101);
        if (r103 != null) goto L9;
        return null;
    L9:
        return r103.getView(r102);
    }

    public void onBindViewHolder(K r100, int r101, List<Object> r102) {
        if (r102.isEmpty() == false) goto L6;
        onBindViewHolder(r100, r101);
        return;
    L6:
        autoUpFetch(r101);
        autoLoadMore(r101);
        int r103 = r100.getItemViewType();
        if (r103 != 0) goto L9;
        convertPayloads(r100, getItem(r101 - getHeaderLayoutCount()), r102);
        return;
    L9:
        if (r103 != 273) goto L11;
        return;
    L11:
        if (r103 != 546) goto L13;
        this.mLoadMoreView.convert(r100);
        return;
    L13:
        if (r103 != 819) goto L15;
        return;
    L15:
        if (r103 == 1365) goto L22;
        convertPayloads(r100, getItem(r101 - getHeaderLayoutCount()), r102);
        return;
    }

    public int setFooterView(View r100, int r101, int r102) {
        LinearLayout r103 = this.mFooterLayout;
        if (r103 == null) goto L10;
        if (r103.getChildCount() <= r101) goto L10;
        this.mFooterLayout.removeViewAt(r101);
        this.mFooterLayout.addView(r100, r101);
        return r101;
    L10:
        return addFooterView(r100, r101, r102);
    }

    public int setHeaderView(View r100, int r101, int r102) {
        LinearLayout r103 = this.mHeaderLayout;
        if (r103 == null) goto L10;
        if (r103.getChildCount() <= r101) goto L10;
        this.mHeaderLayout.removeViewAt(r101);
        this.mHeaderLayout.addView(r100, r101);
        return r101;
    L10:
        return addHeaderView(r100, r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        onBindViewHolder((BaseViewHolder) r100, r101, r102);
    }
}
