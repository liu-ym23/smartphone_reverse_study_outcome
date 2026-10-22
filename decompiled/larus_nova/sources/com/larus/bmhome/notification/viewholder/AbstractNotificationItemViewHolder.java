package com.larus.bmhome.notification.viewholder;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.resp.Button;
import com.larus.bmhome.chat.resp.CommonNoticeData;
import com.larus.bmhome.chat.resp.Notice;
import com.larus.bmhome.chat.resp.Range;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.common_ui.widget.roundlayout.CircleFrameLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.image.loader.b0;
import com.larus.notify.impl.databinding.LarusItemNotificationDefaultBinding;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import or8.b;
import or8.c;
import or8.d;
import or8.e;
import or8.f;
import or8.g;
import or8.h;
import or8.i;
import or8.j;
import or8.k;
import or8.l;
import r27.a;
import v19.b7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010/\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J/\u00100\u001a\u00020!2%\u00101\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!\u0018\u00010\u001dH\u0016JD\u00102\u001a\u00020!2:\u00101\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020!\u0018\u00010#H\u0016J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020\u001bH\u0004J\u0010\u00105\u001a\u00020!2\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020!H\u0003Jp\u00109\u001a\u00020!2f\u0010)\u001ab\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(,\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020!\u0018\u00010*H\u0016J\b\u0010:\u001a\u00020!H\u0002J\b\u0010;\u001a\u00020!H\u0002J\u0012\u0010<\u001a\u00020!2\b\u0010\u0014\u001a\u0004\u0018\u00010=H\u0002J\u0012\u0010>\u001a\u00020!2\b\u0010\u0014\u001a\u0004\u0018\u00010=H\u0003J\b\u0010?\u001a\u00020!H\u0003J\b\u0010@\u001a\u00020!H\u0002J\b\u0010A\u001a\u00020!H\u0002J\u0010\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020!H\u0002J\n\u0010F\u001a\u0004\u0018\u00010+H&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u001c\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000RN\u0010\"\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020!\u0018\u00010#X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(Rn\u0010)\u001ab\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(,\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020!\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/larus/bmhome/notification/viewholder/AbstractNotificationItemViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "Lcom/larus/bmhome/notification/viewholder/INotificationItemViewHolder;", "viewBinding", "Lcom/larus/notify/impl/databinding/LarusItemNotificationDefaultBinding;", "<init>", "(Lcom/larus/notify/impl/databinding/LarusItemNotificationDefaultBinding;)V", "TAG", "", "clickX", "", "clickY", "screenPos", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "data", "Lcom/larus/bmhome/chat/resp/Notice;", "getData", "()Lcom/larus/bmhome/chat/resp/Notice;", "setData", "(Lcom/larus/bmhome/chat/resp/Notice;)V", "readStatus", "Lcom/larus/bmhome/notification/viewholder/AbstractNotificationItemViewHolder$Companion$ReadStatus;", "unreadChangeListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "notice", "", "itemClickListener", "Lkotlin/Function2;", "clickFrom", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "itemLongClickListener", "Lkotlin/Function4;", "Landroid/view/View;", "anchor", "x", "y", "bindViewHolder", "setOnUnreadChangeListener", "listener", "setOnItemClickListener", "changeNotificationUnreadStatus", "newReadStatus", "changeUnreadStyle", "hasRead", "", "setupRootView", "setOnItemLongClickListener", "setupUnreadDot", "setupLeftButton", "setupAvatar", "Lcom/larus/bmhome/chat/resp/Button;", "setupLeftButtonClickListener", "setupContent", "setupAccessibilityContent", "setupBodyText", "formatCreateTime", "createTime", "", "setupRightButton", "getRightButton", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractNotificationItemViewHolder extends ViewBindingHolder implements l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f313499k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemNotificationDefaultBinding f313500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f313501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f313502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f313503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f313504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Notice f313505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Companion.ReadStatus f313506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super Notice, Unit> f313507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function2<? super Notice, ? super String, Unit> f313508i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function4<? super View, ? super Notice, ? super Float, ? super Float, Unit> f313509j;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/notification/viewholder/AbstractNotificationItemViewHolder$Companion$ReadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "READ", "UNREAD", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum ReadStatus extends Enum<ReadStatus> {
            public static final ReadStatus READ = null;
            public static final ReadStatus UNREAD = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ReadStatus[] f313510a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f313511b = null;

            public static EnumEntries<ReadStatus> getEntries() {
                return f313511b;
            }

            static {
                ReadStatus r100 = new ReadStatus("READ", 0);
                READ = r100;
                ReadStatus r101 = new ReadStatus("UNREAD", 1);
                UNREAD = r101;
                ReadStatus[] r102 = {r100, r101};
                f313510a = r102;
                f313511b = EnumEntriesKt.enumEntries(r102);
            }

            public static ReadStatus[] values() {
                return (ReadStatus[]) f313510a.clone();
            }

            public static ReadStatus valueOf(String r100) {
                return (ReadStatus) a.a(ReadStatus.class, r100);
            }

            public ReadStatus(String r100, int r101) {
                super(r100, r101);
            }
        }
    }

    static {
    }

    public abstract View V3();

    public final Context getContext() {
        return (Context) this.f313504e.getValue();
    }

    public AbstractNotificationItemViewHolder(LarusItemNotificationDefaultBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "viewBinding");
        super(r100);
        this.f313500a = r100;
        this.f313503d = new int[2];
        this.f313504e = LazyKt.lazy(new or8.a(this));
        this.f313506g = Companion.ReadStatus.READ;
    }

    @Override // or8.l
    public final void K1(Function2<? super Notice, ? super String, Unit> r100) {
        this.f313508i = r100;
    }

    @Override // or8.l
    public final void T0(Function1<? super Notice, Unit> r100) {
        this.f313507h = r100;
    }

    public final void T3(Companion.ReadStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "newReadStatus");
        if (this.f313506g != Companion.ReadStatus.UNREAD) goto L10;
        if (r100 != Companion.ReadStatus.READ) goto L10;
        Function1<? super Notice, Unit> r101 = this.f313507h;
        if (r101 == null) goto L10;
        r101.invoke(this.f313505f);
    L10:
        if (this.f313506g == r100) goto L13;
        this.f313506g = r100;
    L13:
        if (this.f313506g != Companion.ReadStatus.READ) goto L15;
        boolean r102 = true;
    L16:
        Notice r103 = this.f313505f;
        if (r103 == null) goto L19;
        r103.setHasRead(r102);
    L19:
        U3(r102);
        return;
    L15:
        r102 = false;
        goto L16
    }

    public final void U3(boolean r100) {
        if (z2.f365865a.P3() != 1) goto L9;
        View r101 = this.f313500a.f360266h;
        if (r100 == false) goto L7;
        int r102 = 4;
    L8:
        r101.setVisibility(r102);
        e1.u(this.f313500a.f360259a, 0.0f, R.color.larus_base_1, R.color.larus_press);
        return;
    L7:
        r102 = 0;
        goto L8
    L9:
        this.f313500a.f360266h.setVisibility(8);
        if (r100 == false) goto L12;
        e1.u(this.f313500a.f360259a, 0.0f, R.color.larus_base_1, R.color.larus_press);
        return;
    L12:
        e1.u(this.f313500a.f360259a, 0.0f, R.color.larus_primary_transparent_1, R.color.larus_press);
    }

    @Override // or8.l
    public final void a3(Function4<? super View, ? super Notice, ? super Float, ? super Float, Unit> r100) {
        this.f313509j = r100;
    }

    @Override // or8.l
    public final void g2(Notice r210) {
        Intrinsics.checkNotNullParameter(r210, "data");
        this.f313505f = r210;
        e1.d(this.f313500a.f360259a, new i(this));
        this.f313500a.f360259a.setOnLongClickListener(new j(this));
        this.f313500a.f360259a.setOnTouchListener(new k(this));
        Notice r100 = this.f313505f;
        long r101 = 0;
        if (r100 != null) goto L5;
    L17:
        Companion.ReadStatus r102 = Companion.ReadStatus.READ;
    L18:
        this.f313506g = r102;
        if (r102 != Companion.ReadStatus.READ) goto L21;
        boolean r103 = true;
    L22:
        U3(r103);
        Notice r104 = this.f313505f;
        String r105 = null;
        if (r104 == null) goto L27;
        CommonNoticeData r106 = r104.getCommonNoticeData();
        if (r106 == null) goto L27;
        Button r107 = r106.getLeftButton();
    L28:
        if (r107 == null) goto L30;
        String r108 = r107.getContent();
    L31:
        if (r108 != null) goto L33;
    L36:
        boolean r109 = true;
    L37:
        if (r109 == false) goto L39;
        Uri r110 = new Uri.Builder().scheme("res").path(String.valueOf(R.drawable.larus_common_ui_avatar_placeholder)).build();
    L40:
        Uri r111 = r110;
        CircleFrameLayout r112 = this.f313500a.f360263e;
        if (r107 == null) goto L43;
        boolean r113 = Intrinsics.areEqual(r107.getDisableClip(), Boolean.FALSE);
    L44:
        r112.a(r113);
        ImageLoaderKt.x(this.f313500a.f360260b, r111, null, null, new b(), 6);
        Notice r114 = this.f313505f;
        if (r114 == null) goto L49;
        CommonNoticeData r115 = r114.getCommonNoticeData();
        if (r115 == null) goto L49;
        r115.getLeftButton();
    L49:
        e1.d(this.f313500a.f360263e, new f(this));
        this.f313500a.f360263e.setOnLongClickListener(new g(this));
        this.f313500a.f360263e.setOnTouchListener(new h(this));
        TextView r116 = this.f313500a.f360265g;
        Notice r117 = this.f313505f;
        String r118 = "";
        if (r117 == null) goto L56;
        CommonNoticeData r119 = r117.getCommonNoticeData();
        if (r119 == null) goto L56;
        String r120 = r119.getTitle();
        if (r120 == null) goto L56;
    L57:
        r116.setText(r120);
        e1.d(r116, new c(this));
        r116.setOnLongClickListener(new d(this));
        r116.setOnTouchListener(new e(this));
        TextView r121 = this.f313500a.f360261c;
        Notice r122 = this.f313505f;
        if (r122 == null) goto L62;
        CommonNoticeData r123 = r122.getCommonNoticeData();
        if (r123 == null) goto L62;
        String r124 = r123.getBody();
    L63:
        if (r124 != null) goto L65;
        r124 = "";
    L65:
        SpannableString r125 = new SpannableString(r124);
        Notice r126 = this.f313505f;
        if (r126 == null) goto L72;
        CommonNoticeData r127 = r126.getCommonNoticeData();
        if (r127 == null) goto L72;
        String r128 = r127.getBody();
        if (r128 == null) goto L72;
        int r129 = r128.length();
    L73:
        Notice r130 = this.f313505f;
        if (r130 == null) goto L94;
        CommonNoticeData r131 = r130.getCommonNoticeData();
        if (r131 == null) goto L94;
        List<Range> r132 = r131.getBoldBodyRangeList();
        if (r132 == null) goto L94;
        Iterator<T> r133 = r132.iterator();
    L81:
        if (r133.hasNext() == false) goto L94;
        Range r134 = (Range) r133.next();
        if (r134 == null) goto L85;
        Integer r135 = r134.getStart();
    L86:
        if (r134 == null) goto L88;
        Integer r136 = r134.getLength();
    L89:
        if (r135 == null) goto L81;
        if (r136 == null) goto L81;
        Integer r137 = Integer.valueOf(RangesKt.coerceIn(r135.intValue(), 0, r129));
        int r138 = RangesKt.coerceIn(r137.intValue() + r136.intValue(), 0, r129);
        if (r137.intValue() >= r138) goto L81;
        r125.setSpan(new StyleSpan(1), r137.intValue(), r138, 33);
        goto L81
    L88:
        r136 = null;
        goto L89
    L85:
        r135 = null;
    L94:
        r121.setText(r125);
        if (StringsKt.isBlank(r121.getText()) == false) goto L97;
        int r139 = 8;
    L98:
        r121.setVisibility(r139);
        TextView r140 = this.f313500a.f360262d;
        Notice r141 = this.f313505f;
        if (r141 == null) goto L101;
        r101 = r141.getCreateTime();
    L101:
        r140.setText(b7.a(r101));
        CharSequence r142 = this.f313500a.f360265g.getText();
        if (r142 == null) goto L106;
        String r143 = r142.toString();
        if (r143 == null) goto L106;
        String r144 = StringsKt.trim(r143).toString();
    L107:
        if (r144 != null) goto L109;
        r144 = "";
    L109:
        CharSequence r145 = this.f313500a.f360261c.getText();
        if (r145 == null) goto L114;
        String r146 = r145.toString();
        if (r146 == null) goto L114;
        String r147 = StringsKt.trim(r146).toString();
    L115:
        if (r147 != null) goto L117;
        r147 = "";
    L117:
        CharSequence r148 = this.f313500a.f360262d.getText();
        if (r148 == null) goto L122;
        String r149 = r148.toString();
        if (r149 == null) goto L122;
        String r150 = StringsKt.trim(r149).toString();
    L123:
        if (r150 == null) goto L126;
        r118 = r150;
    L126:
        List r151 = CollectionsKt.listOf(new String[]{r144, r147, r118});
        ArrayList r152 = new ArrayList();
        Iterator r153 = r151.iterator();
    L128:
        if (r153.hasNext() == false) goto L132;
        Object r154 = r153.next();
        if ((!StringsKt.isBlank((String) r154)) == false) goto L128;
        r152.add(r154);
        goto L128
    L132:
        ConstraintLayout r155 = this.f313500a.f360259a;
        String r156 = CollectionsKt.joinToString$default(r152, "\n", null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank(r156)) == false) goto L135;
        r105 = r156;
    L135:
        r155.setContentDescription(r105);
        View r157 = V3();
        if (r157 != null) goto L138;
        this.f313500a.f360264f.setVisibility(8);
        return;
    L138:
        this.f313500a.f360264f.removeAllViews();
        this.f313500a.f360264f.addView(r157);
        return;
    L122:
        r150 = null;
    L114:
        r147 = null;
    L106:
        r144 = null;
        goto L107
    L97:
        r139 = 0;
    L72:
        r129 = 0;
    L62:
        r124 = null;
    L56:
        r120 = "";
        goto L57
    L43:
        r113 = false;
        goto L44
    L39:
        r110 = b0.a(r108, "notice.left_avatar", false, false, 6);
        goto L40
    L33:
        if (r108.length() == 0) goto L36;
        r109 = false;
        goto L37
    L30:
        r108 = null;
    L27:
        r107 = null;
        goto L28
    L21:
        r103 = false;
        goto L22
    L5:
        if (r100.getHasRead() != true) goto L7;
        boolean r158 = true;
    L8:
        if (r158 == true) goto L17;
        Notice r159 = this.f313505f;
        if (r159 == null) goto L12;
        long r160 = r159.getNoticeId();
    L14:
        if (r160 <= 0) goto L17;
        r102 = Companion.ReadStatus.UNREAD;
        goto L18
    L12:
        r160 = 0;
        goto L14
    L7:
        r158 = false;
        goto L8
    }
}
