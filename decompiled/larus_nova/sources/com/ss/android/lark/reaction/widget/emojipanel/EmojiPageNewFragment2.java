package com.ss.android.lark.reaction.widget.emojipanel;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.CallbackManager;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_list.EmojiListView;
import com.ss.android.lark.newemoji.emoji_list.adapter.EmojiListAdapter;
import com.ss.android.lark.newemoji.emoji_list.adapter.f;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qsb.i;
import s5c.d;
import z5c.n3;
import z5c.z2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b)*\u00013\b\u0016\u0018\u0000 a2\u00020\u0001:\u0001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020-H\u0014J\u001a\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u00101\u001a\u00020/H\u0014J\b\u00108\u001a\u000209H\u0002J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u000209J\b\u0010<\u001a\u000209H\u0002J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u000209J\n\u0010?\u001a\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u0011J\u0010\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001bH\u0002J\u0014\u0010C\u001a\u00020\u00002\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00110\u001bJ\n\u0010E\u001a\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u0011J\b\u0010G\u001a\u000209H\u0002J\u000e\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u000209J\b\u0010J\u001a\u000209H\u0002J\u000e\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u000209J\b\u0010M\u001a\u000209H\u0002J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010O\u001a\u000209J\u0010\u0010P\u001a\u00020\u00002\b\u0010Q\u001a\u0004\u0018\u00010\u0006J\b\u0010R\u001a\u00020/H\u0002J\u0006\u0010S\u001a\u00020/J\b\u0010T\u001a\u00020/H\u0002J\b\u0010U\u001a\u00020/H\u0002J\b\u0010V\u001a\u00020/H\u0002J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020/H\u0002J\b\u0010Y\u001a\u00020/H\u0002J\u000e\u0010\u000e\u001a\u00020/2\u0006\u0010Z\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020/2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010[\u001a\u00020'H\u0002J\u0010\u0010\\\u001a\u00020/2\u0006\u0010]\u001a\u00020'H\u0002J\b\u0010^\u001a\u00020\u000fH\u0002J\b\u0010_\u001a\u00020\rH\u0014J\b\u0010`\u001a\u00020\rH\u0014R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b4\u00105¨\u0006b"}, d2 = {"Lcom/ss/android/lark/reaction/widget/emojipanel/EmojiPageNewFragment2;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "refListener", "Ljava/lang/ref/WeakReference;", "Lcom/ss/android/lark/reaction/widget/emojipanel/OnEmojiOperationListener;", "deleteView", "Landroid/view/View;", "rootView", "contentView", "Lcom/ss/android/lark/newemoji/emoji_list/EmojiListView;", "defaultColumn", "", "emojiScene", "Lcom/ss/android/lark/statistics/extensions/IParam;", "chatId", "", "rootWidth", "showColumn", "emojiContainerWidth", "emojiLeftMargin", "rvLeftPadding", "rvRightPadding", "localCallbackManager", "Lcom/larksuite/framework/callback/CallbackManager;", "mruEmojis", "", "Lcom/ss/android/lark/newemoji/larkemoji/LarkEmoji;", "emojiPanelData", "Lcom/ss/android/lark/newemoji/emoji_panel/DefaultEmojiPanelData;", "rootViewTreeObserver", "Landroid/view/ViewTreeObserver;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "createRootView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "createDeleteIcon", "parent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onViewCreated", "", "view", "notifyEmojiView", "globalLayoutListener", "com/ss/android/lark/reaction/widget/emojipanel/EmojiPageNewFragment2$globalLayoutListener$2$1", "getGlobalLayoutListener", "()Lcom/ss/android/lark/reaction/widget/emojipanel/EmojiPageNewFragment2$globalLayoutListener$2$1;", "globalLayoutListener$delegate", "Lkotlin/Lazy;", "isEnableEmojiSkinTone", "", "setEnableEmojiSkinTone", "enableEmojiSkinTones", "isEnableRecentUsed", "setEnableRecentUsed", "enableRecentUse", "getRecentTitle", "setRecentTitle", "title", "getRecentEmojis", "setRecentEmojis", "emojis", "getDefaultTitle", "setDefaultTitle", "isDeleteIconEnable", "setDeleteIconEnable", "enable", "isEnableCustomEmoji", "setEnableCustomEmoji", "value", "isShowOnDialog", "setShowOnDialog", "showOnDialog", "setOnOperationListener", "onOperationListener", "bindView", "initList", "setEmojiListData", "compute", "initListener", "onDestroyView", "resetEmojiParams", "unRegisterListener", "scene", "getArgumentsNotNull", "setArgumentsSafely", "bundle", "getHaveOrganizationEmojis", "getFirstEmojiCenterToParent", "getEmojiHeight", "Companion", "reaction-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class EmojiPageNewFragment2 extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<c> f439344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f439345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EmojiListView f439346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f439347g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f439348h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f439349i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f439350j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f439351k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f439352l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f439353m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f439354n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f439355o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final CallbackManager f439356p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<? extends com.ss.android.lark.newemoji.larkemoji.a> f439357q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DefaultEmojiPanelData f439358r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewTreeObserver f439359s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f439360t;

    public static final class a {
    }

    static {
    }

    public final void S90() {
        Log.i("EmojiPageNewFragment2", "bindView");
        if (this.f439351k != 0) goto L6;
        T90();
    L6:
        if (isActive() == true) goto L9;
        Log.w("EmojiPageNewFragment2", "bindView cancel because not active");
        return;
    L9:
        int r100 = this.f439350j;
        if (r100 > 0) goto L13;
        Log.w("EmojiPageNewFragment2", "bindView cancel because rootWidth <= 0");
        return;
    L13:
        int r101 = W90();
        int r102 = r101 + (i.a(8, UIHelper.getContext()) * 2);
        int r103 = (r100 - this.f439354n) - this.f439355o;
        Log.i("EmojiPageNewFragment2", "bindView, bind_view_window_width: " + r100);
        ssb.a r104 = new ssb.a(this.f439352l, r102, this.f439353m, r101, r103, this.f439354n, this.f439355o, this.f439351k);
        EmojiListView r105 = this.f439346f;
        if (r105 == null) goto L16;
        r105.d(r104);
        r105.setShowOnDialog(V90().getBoolean("SHOW_ON_DIALOG", false));
    L16:
        Log.i("EmojiPageNewFragment2", "bindView, item_params: " + r104);
    }

    public final void T90() {
        Log.i("EmojiPageNewFragment2", "compute");
        if (this.f439352l == 0) goto L6;
        return;
    L6:
        if (isActive() == true) goto L9;
        Log.w("EmojiPageNewFragment2", "compute cancel because not active");
        return;
    L9:
        int r100 = this.f439350j;
        if (r100 > 0) goto L13;
        Log.w("EmojiPageNewFragment2", "compute cancel because rootWidth <= 0");
        return;
    L13:
        int r101 = X90();
        if (this.f439351k != 0) goto L23;
        int r102 = r100 - (r101 * 2);
        if ((r102 / (this.f439347g - 1)) <= UIHelper.dp2px(64.0f)) goto L19;
        int r103 = this.f439347g + 1;
    L22:
        this.f439351k = r103;
        goto L23
    L19:
        if ((r102 / (this.f439347g - 1)) >= UIHelper.dp2px(48.0f)) goto L21;
        r103 = this.f439347g - 1;
        goto L22
    L21:
        r103 = this.f439347g;
    L23:
        int r104 = r101 * 2;
        int r105 = this.f439351k;
        int r106 = (r100 - r104) / (r105 - 1);
        if (r106 <= r104) goto L26;
        this.f439352l = r104;
    L27:
        int r107 = this.f439352l;
        int r108 = r106 - r107;
        this.f439353m = r108;
        this.f439355o = (r100 - (r105 * (r107 + r108))) - this.f439354n;
        Log.i("EmojiPageNewFragment2", "compute, emoji info: showColumn: " + this.f439351k + ", windowWidth: " + r100 + ", emojiLeftMargin: " + this.f439353m + ", marginFirstEmoji: " + r101);
        return;
    L26:
        this.f439352l = r106;
        this.f439354n = r101 - (r106 / 2);
        goto L27
    }

    public int W90() {
        return UIHelper.dp2px(32.0f);
    }

    public int X90() {
        return UIHelper.dp2px(30.0f);
    }

    public final void Y90() {
        Log.i("EmojiPageNewFragment2", "initList");
        List<String> r100 = k2c.a.a().h();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        com.ss.android.lark.newemoji.larkemoji.b r103 = com.ss.android.lark.newemoji.larkemoji.c.d((String) r102.next());
        if (r103 == null) goto L4;
        r101.add(r103);
        goto L4
    L8:
        DefaultEmojiPanelData r104 = k2c.a.a().a();
        if (r104.d() == false) goto L11;
        return;
    L11:
        this.f439357q = r101;
        Intrinsics.checkNotNull(r104);
        this.f439358r = r104;
        aa0();
    }

    public void Z90() {
        int r100 = com.ss.android.lark.reaction.widget.emojipanel.a.f439363a;
        Statistics.sendEvent("public_emoji_panel_widget_view");
    }

    public final void aa0() {
        Log.i("EmojiPageNewFragment2", "setEmojiListData");
        if (isActive() == true) goto L7;
        Log.w("EmojiPageNewFragment2", "setEmojiListData cancel because not active");
        return;
    L7:
        if (this.f439350j > 0) goto L11;
        Log.w("EmojiPageNewFragment2", "setEmojiListData cancel because rootWidth <= 0");
        return;
    L11:
        if (this.f439358r.d() == false) goto L14;
        return;
    L14:
        if (this.f439351k != 0) goto L16;
        T90();
    L16:
        ArrayList r100 = new ArrayList();
        r100.add(new ssb.b.C7650b(8));
        boolean r101 = false;
        if (V90().getBoolean("ENABLE_RECENT_USE", true) == false) goto L75;
        ArrayList<String> r102 = V90().getStringArrayList("RECENT_EMOJIS");
        if (r102 == null) goto L26;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L22:
        if (r104.hasNext() == false) goto L27;
        com.ss.android.lark.newemoji.larkemoji.b r110 = com.ss.android.lark.newemoji.larkemoji.c.d((String) r104.next());
        if (r110 == null) goto L22;
        r103.add(r110);
    L27:
        if (r103 != null) goto L29;
    L32:
        boolean r105 = true;
    L33:
        if (r105 == false) goto L35;
        List<? extends com.ss.android.lark.newemoji.larkemoji.a> r106 = this.f439357q;
        int r107 = usb.a.a();
        List<? extends com.ss.android.lark.newemoji.larkemoji.a> r108 = r106;
    L37:
        if ((!r108.isEmpty()) == false) goto L75;
        String r111 = V90().getString("RECENT_TITLE");
        if (r111 != null) goto L42;
        r111 = "";
    L42:
        if (r111.length() != 0) goto L44;
        boolean r112 = true;
    L45:
        if (r112 == false) goto L47;
        r111 = UIHelper.getString(R.string.Lark_IM_FrequentlyUsedEmojis_Title);
    L47:
        Intrinsics.checkNotNull(r111);
        r100.add(new ssb.b.d(r111, null));
        ArrayList r109 = new ArrayList();
        Iterator r113 = r108.iterator();
    L49:
        if (r113.hasNext() == false) goto L55;
        Object r114 = r113.next();
        com.ss.android.lark.newemoji.larkemoji.a r115 = (com.ss.android.lark.newemoji.larkemoji.a) r114;
        boolean r116 = r115.c(false);
        if (r116 == true) goto L53;
        Log.w("EmojiPageNewFragment2", "set mru emojis, emoji [" + r115.getId() + "] is not prepared");
    L53:
        if (r116 == false) goto L49;
        r109.add(r114);
        goto L49
    L55:
        ArrayList r117 = new ArrayList();
        Iterator r118 = r109.iterator();
    L57:
        if (r118.hasNext() == false) goto L67;
        Object r119 = r118.next();
        com.ss.android.lark.newemoji.larkemoji.a r120 = (com.ss.android.lark.newemoji.larkemoji.a) r119;
        if (V90().getBoolean("ENABLE_CUSTOM_EMOJI", true) == false) goto L61;
    L64:
        boolean r121 = true;
    L65:
        if (r121 == false) goto L57;
        r117.add(r119);
        goto L57
    L61:
        if (k2c.a.a().j5(r120.b()) == false) goto L64;
        r121 = false;
        goto L65
    L67:
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator r123 = r117.iterator();
        int r124 = 0;
    L69:
        if (r123.hasNext() == false) goto L74;
        Object r125 = r123.next();
        int r126 = r124 + 1;
        if (r124 >= 0) goto L73;
        CollectionsKt.throwIndexOverflow();
    L73:
        r122.add(new ssb.b.c((com.ss.android.lark.newemoji.larkemoji.a) r125, false, n3.f570266e, Integer.valueOf(r126)));
        r124 = r126;
        goto L69
    L74:
        r100.add(new ssb.b.a(r122, r107));
        goto L75
    L44:
        r112 = false;
        goto L45
    L35:
        r107 = -1;
        r108 = r103;
        goto L37
    L29:
        if (r103.isEmpty() == true) goto L32;
        r105 = false;
        goto L33
    L26:
        r103 = null;
    L75:
        Iterator r127 = ((ArrayList) this.f439358r.f432955a).iterator();
    L77:
        if (r127.hasNext() == false) goto L119;
        DefaultEmojiPanelData.a r128 = (DefaultEmojiPanelData.a) r127.next();
        if (r128.getType() == DefaultEmojiPanelData.Type.UNKNOWN) goto L77;
        if (V90().getBoolean("ENABLE_CUSTOM_EMOJI", true) == true) goto L87;
        if (r128.getType() == DefaultEmojiPanelData.Type.CUSTOM) goto L77;
    L87:
        if (r128.getType() != DefaultEmojiPanelData.Type.DEFAULT) goto L103;
        String r129 = V90().getString("DEFAULT_TITLE");
        if (r129 != null) goto L92;
        r129 = "";
    L92:
        if (r129.length() != 0) goto L94;
        boolean r130 = true;
    L95:
        if (r130 == false) goto L98;
        r129 = r128.f432960c;
    L98:
        if (r129.length() != 0) goto L100;
        boolean r131 = true;
    L101:
        if (r131 == false) goto L104;
        r129 = UIHelper.getString(R.string.Lark_General_All);
    L104:
        Intrinsics.checkNotNull(r129);
        r100.add(new ssb.b.d(r129, r128.f432959b));
        ArrayList r132 = new ArrayList();
        Iterator r133 = ((ArrayList) r128.b()).iterator();
        int r134 = 0;
    L106:
        if (r133.hasNext() == false) goto L113;
        com.ss.android.lark.newemoji.larkemoji.a r135 = (com.ss.android.lark.newemoji.larkemoji.a) r133.next();
        if (r135.c(r101) == false) goto L106;
        r134 = r134 + 1;
        r100.add(new ssb.b.c(r135, V90().getBoolean("ENABLE_EMOJI_SKIN_TONES", true), n3.f570265d, Integer.valueOf(r134)));
        if (V90().getBoolean("ENABLE_EMOJI_SKIN_TONES", true) == false) goto L112;
        r132.add(r135.getId());
    L112:
        r101 = false;
        goto L106
    L113:
        if (r134 != 0) goto L116;
        ListProtector.remove(r100, CollectionsKt.getLastIndex(r100));
    L116:
        if ((!r132.isEmpty()) == false) goto L118;
        Log.i("EmojiPageNewFragment2", "setEmojiListData, enabled skin tones change key is: " + r132);
    L118:
        r101 = false;
        goto L77
    L100:
        r131 = false;
        goto L101
    L94:
        r130 = false;
        goto L95
    L103:
        r129 = r128.f432960c;
        goto L104
    L119:
        r100.add(new ssb.b.C7650b(56));
        EmojiListView r136 = this.f439346f;
        if (r136 == null) goto L154;
        r136.setData(r100);
        return;
    }

    public EmojiPageNewFragment2() {
        this.f439347g = 7;
        this.f439348h = z2.f570430c;
        this.f439349i = "";
        this.f439356p = new CallbackManager();
        List<String> r100 = k2c.a.a().h();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        com.ss.android.lark.newemoji.larkemoji.b r103 = com.ss.android.lark.newemoji.larkemoji.c.d((String) r102.next());
        if (r103 == null) goto L4;
        r101.add(r103);
        goto L4
    L8:
        this.f439357q = r101;
        this.f439358r = k2c.a.a().a();
        this.f439360t = LazyKt.lazy(new EmojiPageNewFragment2$globalLayoutListener$2(this));
    }

    public final Bundle V90() {
        Bundle r100 = getArguments();
        if (r100 != null) goto L7;
        r100 = BundleKt.bundleOf();
        if (isStateSaved() == true) goto L7;
        super.setArguments(r100);
    L7:
        return r100;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Log.i("EmojiPageNewFragment2", "onDestroyView");
        this.f439356p.cancelCallbacks();
        EmojiListView r100 = this.f439346f;
        if (r100 == null) goto L5;
        r100.f432932c = null;
    L5:
        if (r100 == null) goto L7;
        com.ss.android.lark.newemoji.larkemoji.c.e(r100);
    L7:
        ViewTreeObserver r101 = this.f439359s;
        if (r101 == null) goto L12;
        boolean r102 = true;
        if (r101.isAlive() != true) goto L12;
    L13:
        if (r102 == false) goto L17;
        ViewTreeObserver r103 = this.f439359s;
        if (r103 == null) goto L17;
        r103.removeOnGlobalLayoutListener((EmojiPageNewFragment2$globalLayoutListener$2.a) this.f439360t.getValue());
    L17:
        this.f439359s = null;
        this.f439350j = 0;
        this.f439351k = 0;
        this.f439352l = 0;
        this.f439353m = 0;
        this.f439354n = 0;
        this.f439355o = 0;
        return;
    L12:
        r102 = false;
        goto L13
    }

    public View U90(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        ImageView r101 = new ImageView(r100.getContext());
        r101.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ConstraintLayout.LayoutParams r102 = new ConstraintLayout.LayoutParams(UIHelper.dp2px(56.0f), UIHelper.dp2px(56.0f));
        r101.setLayoutParams(r102);
        r102.bottomToBottom = 0;
        r102.endToEnd = 0;
        r101.setImageResource(R.drawable.icon_delete);
        r101.setBackgroundColor(UIHelper.getColor(R.color.lkui_transparent));
        return r101;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Log.i("EmojiPageNewFragment2", "onViewCreated");
        this.f439350j = r100.getWidth();
        S90();
        aa0();
        EmojiListView r102 = this.f439346f;
        if (r102 == null) goto L9;
        EmojiListAdapter r103 = r102.f432931b;
        if (r103 == null) goto L9;
        RecyclerView r104 = r102.f432930a;
        Intrinsics.checkNotNullParameter(r104, "rv");
        f r105 = (f) r103.f432936d.get(1);
        if (r105 == null) goto L9;
        Intrinsics.checkNotNullParameter(r104, "rv");
        r105.f432945a = r104;
    L9:
        EmojiListView r106 = this.f439346f;
        if (r106 == null) goto L12;
        com.ss.android.lark.newemoji.larkemoji.c.c(r106);
    L12:
        EmojiListView r107 = this.f439346f;
        if (r107 == null) goto L15;
        r107.setOnEmojiSelectListener(new EmojiPageNewFragment2$initListener$1(this));
    L15:
        ViewTreeObserver r108 = r100.getViewTreeObserver();
        this.f439359s = r108;
        if (r108 == null) goto L18;
        r108.addOnGlobalLayoutListener((EmojiPageNewFragment2$globalLayoutListener$2.a) this.f439360t.getValue());
    L18:
        Z90();
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Log.i("EmojiPageNewFragment2", "onCreateView");
        Context r103 = getLayoutInflater().getContext();
        Intrinsics.checkNotNull(r103);
        ConstraintLayout r104 = new ConstraintLayout(r103);
        r104.setId(R.id.container_id);
        r104.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        EmojiListView r105 = new EmojiListView(r103);
        r105.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        r104.addView(r105);
        View r106 = U90(r104);
        r106.setId(R.id.delete_id);
        r106.setOnClickListener(new b(this));
        r104.addView(r106);
        this.f439346f = r105;
        this.f439345e = r106;
        int r107 = 0;
        if (V90().getBoolean("DELETE_ICON_VISIBLE", false) == true) goto L6;
        r107 = 8;
    L6:
        r106.setVisibility(r107);
        return r104;
    }
}
