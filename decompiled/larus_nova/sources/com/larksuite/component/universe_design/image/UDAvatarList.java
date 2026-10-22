package com.larksuite.component.universe_design.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0003'()B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010 \u001a\u00020!2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0003J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010\u0011\u001a\u00020!2\u0006\u0010#\u001a\u00020\nH\u0002J\u0012\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00060\u0019R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006*"}, d2 = {"Lcom/larksuite/component/universe_design/image/UDAvatarList;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "overlapWidth", "getOverlapWidth", "()Lcom/larksuite/component/universe_design/dimension/UDDimension;", "setOverlapWidth", "(Lcom/larksuite/component/universe_design/dimension/UDDimension;)V", "maxCount", "getMaxCount", "()I", "setMaxCount", "(I)V", "observer", "Lcom/larksuite/component/universe_design/image/UDAvatarList$DataObserver;", "Lcom/larksuite/component/universe_design/image/UDAvatarList$AvatarAdapter;", "adapter", "getAdapter", "()Lcom/larksuite/component/universe_design/image/UDAvatarList$AvatarAdapter;", "setAdapter", "(Lcom/larksuite/component/universe_design/image/UDAvatarList$AvatarAdapter;)V", "init", "", "onDataChanged", "avatarSize", "addAvatar", "avatar", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "Companion", "AvatarAdapter", "DataObserver", "universe-ui-avatar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDAvatarList extends LinearLayout {
    public static final a Companion = null;
    public static final int MAX_COUNT = 6;
    private AvatarAdapter<?> adapter;
    private int maxCount;
    private b observer;
    private UDDimension overlapWidth;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H&J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0017\u0010\"\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR4\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/larksuite/component/universe_design/image/UDAvatarList$AvatarAdapter;", "DATA", "Landroid/widget/BaseAdapter;", "avatarSize", "", "data", "", "<init>", "(ILjava/util/List;)V", "getAvatarSize", "()I", "value", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "maxCount", "getMaxCount", "setMaxCount", "(I)V", "onItemCreated", "", "avatar", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "position", "getAvatar", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getMoreAvatar", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "getItem", "(I)Ljava/lang/Object;", "getItemId", "", "getCount", "universe-ui-avatar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class AvatarAdapter<DATA> extends BaseAdapter {
        private final int avatarSize;
        private List<? extends DATA> data;
        private int maxCount;

        /* JADX WARN: Multi-variable type inference failed */
        public AvatarAdapter() {
            int r100 = 0;
            this(r100, null, 3, 0 == true ? 1 : 0);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r100) {
            return r100;
        }

        @Override // android.widget.Adapter
        public View getView(int r100, View r101, ViewGroup r102) {
            return null;
        }

        public abstract void onItemCreated(UDAvatar r100, int r101);

        @Override // android.widget.Adapter
        public int getCount() {
            List<? extends DATA> r100 = this.data;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        public final int getAvatarSize() {
            return this.avatarSize;
        }

        public final List<DATA> getData() {
            return this.data;
        }

        public final int getMaxCount() {
            return this.maxCount;
        }

        @Override // android.widget.Adapter
        public DATA getItem(int r100) {
            List<? extends DATA> r101 = this.data;
            if (r101 != null) goto L7;
            return null;
        L7:
            return (DATA) ListProtector.get(r101, r100);
        }

        public UDAvatar getMoreAvatar(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            List<? extends DATA> r101 = this.data;
            if (r101 == null) goto L5;
            Integer r102 = Integer.valueOf(r101.size() - (this.maxCount - 1));
        L6:
            UDTextAvatar r103 = new UDTextAvatar(r100);
            r103.setBorderStyle(0);
            r103.setAvatarText(Marker.ANY_NON_NULL_MARKER + r102);
            r103.setTextColor(Integer.valueOf(UDColorUtils.getColor(r100, R.color.text_caption)));
            r103.setAvatarBgColor(UDColorUtils.getColor(r100, R.color.bg_filler));
            r103.setBorderColor(UDColorUtils.getColor(r100, R.color.bg_body));
            r103.setAvatarSize(this.avatarSize);
            return r103;
        L5:
            r102 = null;
            goto L6
        }

        public final void setData(List<? extends DATA> r100) {
            this.data = r100;
            notifyDataSetChanged();
        }

        public final void setMaxCount(int r100) {
            this.maxCount = r100;
        }

        public AvatarAdapter(int r100, List<? extends DATA> r101) {
            this.avatarSize = r100;
            this.data = r101;
            this.maxCount = 6;
        }

        public UDAvatar getAvatar(Context r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (getItem(r101) == null) goto L6;
            UDAvatar r102 = new UDAvatar(r100);
            r102.setBorderColor(UDColorUtils.getColor(r100, R.color.bg_body));
            r102.setAvatarSize(this.avatarSize);
            r102.setBackgroundColor(UDColorUtils.getColor(r100, R.color.bg_filler));
            onItemCreated(r102, r101);
            return r102;
        L6:
            return null;
        }

        public /* synthetic */ AvatarAdapter(int r100, List r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = -1;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDAvatarList f285051a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            UDAvatarList.access$onDataChanged(this.f285051a);
        }

        public b(UDAvatarList r100) {
            this.f285051a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDAvatarList f285052a;

        public c(UDAvatarList r100) {
            this.f285052a = r100;
        }

        public final void a() {
            this.f285052a.removeAllViews();
            AvatarAdapter<?> r100 = this.f285052a.getAdapter();
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.getCount();
        L6:
            int r103 = Math.min(r102, this.f285052a.getMaxCount() - 1);
            int r104 = 0;
        L7:
            UDAvatar r105 = null;
            if (r104 >= r103) goto L13;
            UDAvatarList r106 = this.f285052a;
            AvatarAdapter<?> r107 = r106.getAdapter();
            if (r107 == null) goto L12;
            r105 = r107.getAvatar(this.f285052a.getContext(), r104);
        L12:
            UDAvatarList.access$addAvatar(r106, r105);
            r104 = r104 + 1;
            goto L7
        L13:
            AvatarAdapter<?> r108 = this.f285052a.getAdapter();
            if (r108 == null) goto L16;
            int r109 = r108.getCount();
        L18:
            if (r109 != this.f285052a.getMaxCount()) goto L23;
            UDAvatarList r110 = this.f285052a;
            AvatarAdapter<?> r111 = r110.getAdapter();
            if (r111 == null) goto L22;
            r105 = r111.getAvatar(this.f285052a.getContext(), this.f285052a.getMaxCount() - 1);
        L22:
            UDAvatarList.access$addAvatar(r110, r105);
            return;
        L23:
            AvatarAdapter<?> r112 = this.f285052a.getAdapter();
            if (r112 == null) goto L27;
            r101 = r112.getCount();
        L27:
            if (r101 <= this.f285052a.getMaxCount()) goto L37;
            UDAvatarList r113 = this.f285052a;
            AvatarAdapter<?> r114 = r113.getAdapter();
            if (r114 == null) goto L31;
            r105 = r114.getMoreAvatar(this.f285052a.getContext());
        L31:
            UDAvatarList.access$addAvatar(r113, r105);
            return;
        L37:
            return;
        L16:
            r109 = 0;
            goto L18
        L5:
            r102 = 0;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    private final void onDataChanged() {
        new Handler(Looper.getMainLooper()).post(new c(this));
    }

    public final AvatarAdapter<?> getAdapter() {
        return this.adapter;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final UDDimension getOverlapWidth() {
        return this.overlapWidth;
    }

    public UDAvatarList(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final /* synthetic */ void access$onDataChanged(UDAvatarList r100) {
        r100.onDataChanged();
    }

    private final void addAvatar(UDAvatar r100) {
        int r101 = (int) this.overlapWidth.toPixels(getContext());
        if (r100 == null) goto L38;
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-2, -2);
        if (getChildCount() <= 0) goto L15;
        int r103 = 0;
        if (getOrientation() != 0) goto L9;
        int r104 = -r101;
    L10:
        r102.leftMargin = r104;
        if (getOrientation() != 1) goto L13;
        r103 = -r101;
    L13:
        r102.topMargin = r103;
        goto L15
    L9:
        r104 = 0;
    L15:
        if (r100.getBorderColor() != 0) goto L17;
    L36:
        addView(r100.drawBorderDelegate$universe_ui_avatar_release(), r102);
        return;
    L17:
        if (r100.getBorderWidth() != null) goto L19;
    L20:
        int r105 = r100.getAvatarSize();
        if (r105 != (-5)) goto L23;
        int r106 = d.d(getContext(), R.dimen.ud_avatar_border_width_extra_small);
    L35:
        r100.setBorderWidth(Float.valueOf(r106));
        goto L36
    L23:
        if (r105 != (-4)) goto L25;
        r106 = d.d(getContext(), R.dimen.ud_avatar_border_width_mini);
        goto L35
    L25:
        if (r105 == (-3)) goto L32;
        if (r105 != (-2)) goto L28;
        r106 = d.d(getContext(), R.dimen.ud_avatar_border_width_middle);
        goto L35
    L28:
        if (r105 == (-1)) goto L30;
        r106 = d.d(getContext(), R.dimen.ud_avatar_border_width_large);
        goto L35
    L30:
        r106 = d.d(getContext(), R.dimen.ud_avatar_border_width_large);
        goto L35
    L32:
        r106 = d.d(getContext(), R.dimen.ud_avatar_border_width_small);
        goto L35
    L19:
        if (Intrinsics.areEqual(r100.getBorderWidth(), 0.0f) == false) goto L36;
    }

    private final void setOverlapWidth(int r100) {
        if (r100 != (-5)) goto L5;
        int r101 = d.d(getContext(), R.dimen.ud_avatar_overlap_width_extra_small);
    L18:
        setOverlapWidth(new UDDimension.a(r101));
        return;
    L5:
        if (r100 != (-4)) goto L7;
        r101 = d.d(getContext(), R.dimen.ud_avatar_overlap_width_mini);
        goto L18
    L7:
        if (r100 != (-3)) goto L9;
        r101 = d.d(getContext(), R.dimen.ud_avatar_overlap_width_small);
        goto L18
    L9:
        if (r100 != (-2)) goto L11;
        r101 = d.d(getContext(), R.dimen.ud_avatar_overlap_width_middle);
        goto L18
    L11:
        if (r100 == (-1)) goto L13;
        r101 = d.d(getContext(), R.dimen.ud_avatar_overlap_width_large);
        goto L18
    L13:
        r101 = d.d(getContext(), R.dimen.ud_avatar_overlap_width_large);
        goto L18
    }

    public final void setAdapter(AvatarAdapter<?> r100) {
        AvatarAdapter<?> r101 = this.adapter;
        if (r101 == null) goto L5;
        r101.unregisterDataSetObserver(this.observer);
    L5:
        this.adapter = r100;
        if (r100 == null) goto L8;
        r100.registerDataSetObserver(this.observer);
    L8:
        AvatarAdapter<?> r102 = this.adapter;
        if (r102 == null) goto L11;
        setOverlapWidth(r102.getAvatarSize());
        r102.setMaxCount(this.maxCount);
    L11:
        this.observer.onChanged();
    }

    public final void setMaxCount(int r100) {
        this.maxCount = r100;
        AvatarAdapter<?> r101 = this.adapter;
        if (r101 == null) goto L5;
        r101.setMaxCount(r100);
    L5:
        AvatarAdapter<?> r102 = this.adapter;
        if (r102 == null) goto L9;
        r102.notifyDataSetChanged();
        return;
    }

    public final void setOverlapWidth(UDDimension r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (r100.toPixels(getContext()) != this.overlapWidth.toPixels(getContext())) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L11;
        this.overlapWidth = r100;
        AvatarAdapter<?> r102 = this.adapter;
        if (r102 == null) goto L12;
        r102.notifyDataSetChanged();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public UDAvatarList(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public static final /* synthetic */ void access$addAvatar(UDAvatarList r100, UDAvatar r101) {
        r100.addAvatar(r101);
    }

    private final void init(AttributeSet r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        TypedArray r102 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.ud_avatarList_maxCount}, r101, 0);
        setMaxCount(r102.getInt(0, 6));
        r102.recycle();
    }

    public UDAvatarList(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.overlapWidth = new UDDimension.a(0);
        this.maxCount = 6;
        this.observer = new b(this);
        init(r101, r102);
    }
}
