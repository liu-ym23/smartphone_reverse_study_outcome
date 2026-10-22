package com.ss.android.lark.todo.impl.features.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u0003012B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010&\u001a\u00020'2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0003J\b\u0010(\u001a\u00020'H\u0002J\u0010\u0010\u0011\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0012\u0010)\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0018\u0010,\u001a\u00020'2\u0006\u0010*\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u0012\u0010\u001e\u001a\u00060\u001fR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010 2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010 @FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00063"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/common/widget/TaskUDAvatarList;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "overlapWidth", "getOverlapWidth", "()Lcom/larksuite/component/universe_design/dimension/UDDimension;", "setOverlapWidth", "(Lcom/larksuite/component/universe_design/dimension/UDDimension;)V", "maxCount", "getMaxCount", "()I", "setMaxCount", "(I)V", "avatarSize", "getAvatarSize", "setAvatarSize", "avatarTextSize", "getAvatarTextSize", "setAvatarTextSize", "observer", "Lcom/ss/android/lark/todo/impl/features/common/widget/TaskUDAvatarList$DataObserver;", "Lcom/ss/android/lark/todo/impl/features/common/widget/TaskUDAvatarList$AvatarAdapter;", "adapter", "getAdapter", "()Lcom/ss/android/lark/todo/impl/features/common/widget/TaskUDAvatarList$AvatarAdapter;", "setAdapter", "(Lcom/ss/android/lark/todo/impl/features/common/widget/TaskUDAvatarList$AvatarAdapter;)V", "init", "", "onDataChanged", "addAvatar", "avatar", "Lcom/ss/android/lark/todo/impl/features/common/widget/TaskUDAvatar;", "drawBorderDelegate", "Lcom/larksuite/component/universe_design/image/UDAvatar;", KtvSubElement.CONTAINER, "Landroid/widget/FrameLayout;", "Companion", "AvatarAdapter", "DataObserver", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskUDAvatarList extends LinearLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f442497g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UDDimension f442498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f442499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f442500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f442501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f442502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a<?> f442503f;

    public static abstract class a<DATA> extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<? extends DATA> f442504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f442505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f442506c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f442507d;

        public abstract void a(TaskUDAvatar r100, int r101);

        public abstract void b(TaskUDTextAvatar r100);

        @Override // android.widget.Adapter
        public final long getItemId(int r100) {
            return r100;
        }

        @Override // android.widget.Adapter
        public final View getView(int r100, View r101, ViewGroup r102) {
            return null;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            List<? extends DATA> r100 = this.f442504a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        public a(List<? extends DATA> r100) {
            this.f442504a = r100;
            this.f442505b = -1;
            this.f442506c = -1;
            this.f442507d = 6;
        }

        @Override // android.widget.Adapter
        public final DATA getItem(int r100) {
            List<? extends DATA> r101 = this.f442504a;
            if (r101 != null) goto L7;
            return null;
        L7:
            return (DATA) ListProtector.get(r101, r100);
        }
    }

    public static final class b {
    }

    public final class c extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskUDAvatarList f442508a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            TaskUDAvatarList r100 = this.f442508a;
            int r101 = TaskUDAvatarList.f442497g;
            r100.getClass();
            new Handler(Looper.getMainLooper()).post(new com.ss.android.lark.todo.impl.features.common.widget.a(r100));
        }

        public c(TaskUDAvatarList r100) {
            this.f442508a = r100;
        }
    }

    static {
    }

    public final a<?> getAdapter() {
        return this.f442503f;
    }

    public final int getAvatarSize() {
        return this.f442500c;
    }

    public final int getAvatarTextSize() {
        return this.f442501d;
    }

    public final int getMaxCount() {
        return this.f442499b;
    }

    public final UDDimension getOverlapWidth() {
        return this.f442498a;
    }

    public TaskUDAvatarList(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setOverlapWidth(int r100) {
        if (r100 != (-5)) goto L5;
        float r101 = UIHelper.sp2px(6.0f);
    L18:
        setOverlapWidth(new UDDimension.a(r101));
        return;
    L5:
        if (r100 != (-4)) goto L7;
        r101 = UIHelper.sp2px(6.0f);
        goto L18
    L7:
        if (r100 != (-3)) goto L9;
        r101 = UIHelper.sp2px(11.0f);
        goto L18
    L9:
        if (r100 != (-2)) goto L11;
        r101 = UIHelper.sp2px(11.0f);
        goto L18
    L11:
        if (r100 == (-1)) goto L13;
        r101 = UIHelper.sp2px(16.0f);
        goto L18
    L13:
        r101 = UIHelper.sp2px(16.0f);
        goto L18
    }

    public final void setAdapter(a<?> r100) {
        a<?> r101 = this.f442503f;
        if (r101 == null) goto L5;
        r101.unregisterDataSetObserver(this.f442502e);
    L5:
        this.f442503f = r100;
        if (r100 == null) goto L8;
        r100.registerDataSetObserver(this.f442502e);
    L8:
        a<?> r102 = this.f442503f;
        if (r102 == null) goto L11;
        r102.f442507d = this.f442499b;
        r102.f442505b = this.f442500c;
        r102.f442506c = this.f442501d;
    L11:
        this.f442502e.onChanged();
    }

    public final void setAvatarSize(int r100) {
        this.f442500c = r100;
        a<?> r101 = this.f442503f;
        if (r101 == null) goto L5;
        r101.f442505b = r100;
    L5:
        if (r101 == null) goto L8;
        r101.notifyDataSetChanged();
        return;
    }

    public final void setAvatarTextSize(int r100) {
        this.f442501d = r100;
        a<?> r101 = this.f442503f;
        if (r101 == null) goto L5;
        r101.f442506c = r100;
    L5:
        if (r101 == null) goto L8;
        r101.notifyDataSetChanged();
        return;
    }

    public final void setMaxCount(int r100) {
        this.f442499b = r100;
        a<?> r101 = this.f442503f;
        if (r101 == null) goto L5;
        r101.f442507d = r100;
    L5:
        if (r101 == null) goto L8;
        r101.notifyDataSetChanged();
        return;
    }

    public final void setOverlapWidth(UDDimension r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (r100.toPixels(getContext()) != this.f442498a.toPixels(getContext())) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L11;
        this.f442498a = r100;
        a<?> r102 = this.f442503f;
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

    public TaskUDAvatarList(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public static final void a(TaskUDAvatarList r100, TaskUDAvatar r101) {
        int r102 = (int) r100.f442498a.toPixels(r100.getContext());
        if (r101 == null) goto L58;
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        if (r100.getChildCount() <= 0) goto L16;
        if (r100.getOrientation() != 0) goto L9;
        int r104 = -r102;
    L10:
        r103.leftMargin = r104;
        if (r100.getOrientation() != 1) goto L13;
        int r105 = -r102;
    L14:
        r103.topMargin = r105;
        goto L16
    L13:
        r105 = 0;
        goto L14
    L9:
        r104 = 0;
    L16:
        if (r101.getBorderColor() == 0) goto L38;
        if (r101.getBorderWidth() != null) goto L20;
    L21:
        int r106 = r101.getAvatarSize();
        if (r106 != (-5)) goto L24;
        int r107 = d.d(r100.getContext(), R.dimen.ud_avatar_border_width_extra_small);
    L36:
        r101.setBorderWidth(Float.valueOf(r107));
        goto L38
    L24:
        if (r106 != (-4)) goto L26;
        r107 = d.d(r100.getContext(), R.dimen.ud_avatar_border_width_mini);
        goto L36
    L26:
        if (r106 == (-3)) goto L33;
        if (r106 != (-2)) goto L29;
        r107 = d.d(r100.getContext(), R.dimen.ud_avatar_border_width_middle);
        goto L36
    L29:
        if (r106 == (-1)) goto L31;
        r107 = d.d(r100.getContext(), R.dimen.ud_avatar_border_width_large);
        goto L36
    L31:
        r107 = d.d(r100.getContext(), R.dimen.ud_avatar_border_width_large);
        goto L36
    L33:
        r107 = d.d(r100.getContext(), R.dimen.ud_avatar_border_width_small);
        goto L36
    L20:
        if (Intrinsics.areEqual(r101.getBorderWidth(), 0.0f) == true) goto L21;
    L38:
        if (r101.f442491f == true) goto L48;
        r101.f442491f = true;
        FrameLayout r108 = new FrameLayout(r101.getContext());
        GradientDrawable r109 = new GradientDrawable();
        Float r110 = r101.f442488c;
        if (r110 == null) goto L42;
        int r111 = (int) r110.floatValue();
    L43:
        r109.setStroke(r111, r101.f442487b);
        r109.setCornerRadius(r101.f442493h / 2.0f);
        r108.setBackground(r109);
        Float r112 = r101.f442488c;
        if (r112 == null) goto L46;
        int r113 = (int) r112.floatValue();
    L47:
        int r114 = r113 - 0;
        r108.setPadding(r114, r114, r114, r114);
        r108.addView(r101, new FrameLayout.LayoutParams(-2, -2));
        r101.f442493h -= r114;
    L49:
        Object r115 = r101.getTag(R.id.tag_key_avatar_status_show);
        if ((r115 instanceof Boolean) == false) goto L52;
        Boolean r116 = (Boolean) r115;
    L54:
        if (Intrinsics.areEqual(r116, Boolean.TRUE) == false) goto L56;
        AppCompatImageView r117 = new AppCompatImageView(r100.getContext());
        r117.setImageDrawable(UDIconUtils.getIconDrawable(r100.getContext(), R.drawable.ud_icon_check_outlined, UDColorUtils.getColor(r100.getContext(), R.color.static_white)));
        r117.setBackgroundResource(R.drawable.todo_detail_assignee_status_bg_new);
        int r118 = d.f(r100.getContext(), 10.0f);
        FrameLayout.LayoutParams r119 = new FrameLayout.LayoutParams(r118, r118);
        r119.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        Unit r120 = Unit.INSTANCE;
        r108.addView(r117, r119);
    L56:
        r100.addView(r108, r103);
        return;
    L52:
        r116 = null;
        goto L54
    L46:
        r113 = 0;
        goto L47
    L42:
        r111 = 0;
        goto L43
    L48:
        ViewParent r121 = r101.getParent();
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type android.widget.FrameLayout");
        r108 = (FrameLayout) r121;
        goto L49
    }

    public TaskUDAvatarList(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f442498a = new UDDimension.a(0);
        this.f442499b = 6;
        this.f442500c = -1;
        this.f442501d = -1;
        this.f442502e = new c(this);
        if (r101 == null) goto L7;
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.task_ud_avatarList_avatarSize, R.attr.task_ud_avatarList_maxCount, R.attr.task_ud_avatarList_overlapSize, R.attr.task_ud_avatarList_text_size}, r102, 0);
        setMaxCount(r103.getInt(1, 6));
        setAvatarSize(r103.getDimensionPixelSize(0, -1));
        setAvatarTextSize(r103.getDimensionPixelSize(3, -1));
        setOverlapWidth(new UDDimension.a(r103.getDimensionPixelSize(2, 0)));
        r103.recycle();
        return;
    }
}
