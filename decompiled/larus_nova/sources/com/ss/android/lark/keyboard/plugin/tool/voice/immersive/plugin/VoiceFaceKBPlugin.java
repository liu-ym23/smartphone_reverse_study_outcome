package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.plugin;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.google.android.material.tabs.TabLayout;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.PanelMenuItem;
import com.ss.android.lark.keyboard.keyboard2.i;
import com.ss.android.lark.keyboard.plugin.tool.face.FacePagerNewAdapter;
import com.ss.android.lark.keyboard.plugin.tool.face.FaceViewPager;
import com.ss.android.lark.keyboard.plugin.tool.face.StickerTabItemView;
import com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.reaction.widget.emojipanel.EmojiPageNewFragment2;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import z5c.z0;

/* JADX INFO: loaded from: classes36.dex */
public final class VoiceFaceKBPlugin extends PanelMenuItem {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f430394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FragmentManager f430395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IVoiceFaceDependency f430396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f430397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FaceViewPager f430398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f430399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f430400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TabLayout f430401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public EmojiPageNewFragmentNoHitPoint f430402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FacePagerNewAdapter f430403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<Fragment> f430404n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<Fragment> f430405o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<Unit> f430406p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f430407q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final KeyboardMenuItemKey f430408r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PanelMenuItem.InitialStrategy f430409s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f430410t;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/plugin/VoiceFaceKBPlugin$EmojiPageNewFragmentNoHitPoint;", "Lcom/ss/android/lark/reaction/widget/emojipanel/EmojiPageNewFragment2;", "<init>", "()V", "notifyEmojiView", "", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EmojiPageNewFragmentNoHitPoint extends EmojiPageNewFragment2 {
        @Override // com.ss.android.lark.reaction.widget.emojipanel.EmojiPageNewFragment2
        public final void Z90() {
        }

        public EmojiPageNewFragmentNoHitPoint() {
        }
    }

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.reaction.widget.emojipanel.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceFaceKBPlugin f430411a;

        @Override // com.ss.android.lark.reaction.widget.emojipanel.c
        public final void c() {
            VoiceFaceKBPlugin.H(this.f430411a);
        }

        public b(VoiceFaceKBPlugin r100) {
            this.f430411a = r100;
        }

        @Override // com.ss.android.lark.reaction.widget.emojipanel.c
        public final void e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reactionKey");
            EditText r101 = this.f430411a.n().L().c();
            if (r101 == null) goto L31;
            String r102 = "[" + qsb.b.a().df(r100) + ']';
            qsb.a r103 = qsb.b.a().Yd(r100);
            if (r103 == null) goto L7;
            String r104 = r103.f534723a;
        L8:
            if (r104 != null) goto L10;
        L13:
            boolean r105 = true;
        L15:
            if (r105 == false) goto L18;
            Log.i("FaceKBPluginNew", "click reaction = " + r100 + " from emoji panel failed: emoji key is null");
            return;
        L18:
            Drawable r106 = EmojiHandler.c(r104, null, null);
            Intrinsics.checkNotNullParameter(r101, "<this>");
            if ((r101 instanceof FunctionEditText) == false) goto L22;
            if (r106 == null) goto L22;
            ExtensionEditTextCompatKt.a(r101, r101.getContext(), r106, r104, r102);
            Unit r107 = Unit.INSTANCE;
        L29:
            this.f430411a.f430396f.b(r104);
            return;
        L22:
            Log.i("FaceKBPluginNew", "click reaction = " + r100 + " from emoji panel failed: emoji drawable is null");
            int r108 = r101.getSelectionStart();
            Editable r109 = r101.getEditableText();
            if (r108 >= 0) goto L25;
        L28:
            r109.append(r102);
            goto L29
        L25:
            if (r108 >= r109.length()) goto L28;
            r109.insert(r108, r102);
            goto L29
        L10:
            if (r104.length() == 0) goto L13;
            r105 = false;
            goto L15
        L7:
            r104 = null;
            goto L8
        }
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return R.drawable.ud_icon_emoji_outlined;
    }

    public final void J() {
        if (this.f430397g == null) goto L5;
        return;
    L5:
        Activity r100 = n().l().getContext();
        RelativeLayout r101 = new RelativeLayout(r100);
        r101.setId(R.id.toolbox_layout_face_voice);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        RelativeLayout r102 = new RelativeLayout(r100);
        r102.setId(R.id.bottom_tab_voice);
        RelativeLayout.LayoutParams r103 = new RelativeLayout.LayoutParams(-1, UIUtils.dp2px(r100, 40.0f));
        r102.setBackgroundColor(UIUtils.getColor(r100, R.color.bg_body));
        r103.addRule(12, -1);
        r101.addView(r102, r103);
        FaceViewPager r104 = null;
        View r105 = LayoutInflater.from(r100).inflate(R.layout.kb_plugin_face_new_tablayout, null);
        r105.setId(R.id.emotion_tabs_voice);
        RelativeLayout.LayoutParams r110 = new RelativeLayout.LayoutParams(-2, UIUtils.dp2px(r100, 40.0f));
        r110.addRule(0, R.id.bottom_setting_panel_voice);
        r110.addRule(9, -1);
        r102.addView(r105, r110);
        FrameLayout r106 = new FrameLayout(r100);
        r106.setId(R.id.bottom_setting_panel_voice);
        RelativeLayout.LayoutParams r111 = new RelativeLayout.LayoutParams(-2, -1);
        r111.addRule(11, -1);
        r111.addRule(15, -1);
        r102.addView(r106, r111);
        ImageView r107 = new ImageView(r100);
        r107.setId(R.id.back_emoji_voice);
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(UIUtils.dp2px(r100, 49.5f), UIUtils.dp2px(r100, 40.0f));
        r112.gravity = 17;
        r107.setBackground(UIUtils.getDrawable(r100, R.drawable.ic_icon_sticker_setting_bg));
        r107.setPadding(UIUtils.dp2px(r100, 14.5f), UIUtils.dp2px(r100, 8.5f), UIUtils.dp2px(r100, 14.5f), UIUtils.dp2px(r100, 8.0f));
        r107.setImageDrawable(UDIconUtils.getIconDrawable(r100, R.drawable.ud_icon_delete_outlined, UIUtils.getColor(r100, R.color.icon_n3)));
        r107.setVisibility(0);
        r106.addView(r107, r112);
        FaceViewPager r108 = new FaceViewPager(r100, null);
        r108.setId(R.id.toolbox_pagers_face_voice);
        RelativeLayout.LayoutParams r109 = new RelativeLayout.LayoutParams(-1, -1);
        r109.addRule(2, R.id.bottom_tab_voice);
        r108.setBackgroundColor(UIUtils.getColor(r100, R.color.bg_base));
        r101.addView(r108, r109);
        this.f430397g = r101;
        FaceViewPager r113 = (FaceViewPager) r101.findViewById(R.id.toolbox_pagers_face_voice);
        this.f430398h = r113;
        if (r113 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
        r113 = null;
    L8:
        r113.setOffscreenPageLimit(1);
        View r114 = this.f430397g;
        if (r114 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        r114 = null;
    L11:
        this.f430401k = (TabLayout) r114.findViewById(R.id.emotion_tabs_voice);
        View r115 = this.f430397g;
        if (r115 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        r115 = null;
    L14:
        View r116 = r115.findViewById(R.id.back_emoji_voice);
        this.f430400j = r116;
        if (r116 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDeleteEmojiBtn");
        r116 = null;
    L17:
        r116.setOnClickListener(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.plugin.b(this));
        TabLayout r117 = this.f430401k;
        if (r117 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mEmoticonTabs");
        r117 = null;
    L20:
        FaceViewPager r118 = this.f430398h;
        if (r118 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
        r118 = null;
    L23:
        r117.addOnTabSelectedListener(new c(this, r118));
        FacePagerNewAdapter r119 = new FacePagerNewAdapter(this.f430395e, this.f430404n);
        this.f430403m = r119;
        b r120 = this.f430410t;
        Intrinsics.checkNotNullParameter(r120, "onEmojiOperationListener");
        r119.f429638b = r120;
        FaceViewPager r121 = this.f430398h;
        if (r121 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
        r121 = null;
    L26:
        FacePagerNewAdapter r122 = this.f430403m;
        if (r122 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("newAdapter");
        r122 = null;
    L29:
        r121.setAdapter(r122);
        TabLayout r123 = this.f430401k;
        if (r123 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mEmoticonTabs");
        r123 = null;
    L32:
        FaceViewPager r124 = this.f430398h;
        if (r124 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
        r124 = null;
    L35:
        r123.setupWithViewPager(r124);
        FaceViewPager r125 = this.f430398h;
        if (r125 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
    L39:
        r104.addOnPageChangeListener(new VoiceFaceKBPlugin$initAdapter$1(this));
        return;
    L38:
        r104 = r125;
        goto L39
    }

    public final void K() {
        ((ArrayList) this.f430405o).clear();
        int r100 = com.ss.android.lark.reaction.widget.emojipanel.a.f439363a;
        d r101 = this.f430396f.d().getValue();
        if (this.f430396f.a().c() == false) goto L5;
        s5c.a r102 = z0.f570427c;
    L6:
        d r103 = r101.plus(r102);
        Intrinsics.checkNotNullParameter(r103, "extraParam");
        Statistics.sendEvent("public_emoji_panel_select_view", r103.toJson());
        EmojiPageNewFragmentNoHitPoint r104 = this.f430402l;
        if (r104 != null) goto L9;
        r104 = new EmojiPageNewFragmentNoHitPoint();
        r104.Y90();
        d r105 = this.f430396f.d().getValue();
        Intrinsics.checkNotNullParameter(r105, "scene");
        r104.f439348h = r105;
        this.f430396f.c();
        Intrinsics.checkNotNullParameter("", "chatId");
        r104.f439349i = "";
        this.f430402l = r104;
    L9:
        r104.Y90();
        ((ArrayList) this.f430405o).add(r104);
        Log.d("FaceKBPluginNew", "initSticker: Preparing to update adapter with " + ((ArrayList) this.f430405o).size() + " fragments.");
        ((ArrayList) this.f430404n).clear();
        ((ArrayList) this.f430404n).addAll(this.f430405o);
        TabLayout r106 = this.f430401k;
        TabLayout r107 = null;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mEmoticonTabs");
        r106 = null;
    L12:
        r106.removeAllTabs();
        FacePagerNewAdapter r108 = this.f430403m;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("newAdapter");
        r108 = null;
    L15:
        r108.notifyDataSetChanged();
        TabLayout r109 = this.f430401k;
        if (r109 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mEmoticonTabs");
        r109 = null;
    L18:
        int r110 = r109.getTabCount();
        int r111 = 0;
    L19:
        if (r111 >= r110) goto L37;
        TabLayout r112 = this.f430401k;
        if (r112 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mEmoticonTabs");
        r112 = null;
    L23:
        TabLayout.Tab r113 = r112.getTabAt(r111);
        if (r113 == null) goto L37;
        TabLayout r114 = this.f430401k;
        if (r114 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mEmoticonTabs");
        r114 = null;
    L29:
        StickerTabItemView r115 = new StickerTabItemView(r114.getContext(), null, 6, 0);
        if (r113.getCustomView() != null) goto L32;
    L34:
        if (r111 != 0) goto L36;
        r115.setTabIcon(R.drawable.tab_bottom_emoji);
    L36:
        r113.setCustomView(r115);
        r111 = r111 + 1;
        goto L19
    L32:
        if ((r113.getCustomView() instanceof StickerTabItemView) == false) goto L34;
        r113.setCustomView(null);
    L37:
        TabLayout r116 = this.f430401k;
        if (r116 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mEmoticonTabs");
    L41:
        r107.setTabMode(0);
        return;
    L40:
        r107 = r116;
        goto L41
    L5:
        r102 = z0.f570428d;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int b() {
        if (this.f430394d == false) goto L5;
        return R.color.icon_n1;
    L5:
        return R.color.icon_n2;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.PanelMenuItem
    public final PanelMenuItem.InitialStrategy C() {
        return this.f430409s;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return this.f430408r;
    }

    public static final void H(VoiceFaceKBPlugin r110) {
        r110.getClass();
        KeyEvent r111 = new KeyEvent(0, 0, 0, 67, 0, 0, 0, 0, 6);
        r110.n().L().c().dispatchKeyEvent(r111);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.o
    public final void A(boolean r100) {
        Log.i("FaceKBPluginNew", "onSelectChange: " + r100);
        View r101 = null;
        FaceViewPager r102 = null;
        FaceViewPager r103 = null;
        if (r100 == false) goto L58;
        this.f430406p.invoke();
        if (this.f430407q == true) goto L35;
        this.f430396f.e();
        View r104 = this.f430399i;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceIcon");
        r104 = null;
    L10:
        if ((r104 instanceof ImageView) == false) goto L12;
        ImageView r105 = (ImageView) r104;
    L13:
        if (r105 == null) goto L15;
        r105.setImageResource(R.drawable.ud_icon_emoji_keyboard_outlined);
    L15:
        View r106 = this.f430399i;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceIcon");
        r106 = null;
    L18:
        r106.setSelected(false);
        View r107 = this.f430397g;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        r107 = null;
    L21:
        r107.setVisibility(0);
        View r108 = this.f430397g;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        r108 = null;
    L24:
        View r109 = this.f430397g;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        r109 = null;
    L27:
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        r110.height = -2;
        r108.setLayoutParams(r110);
        K();
        FaceViewPager r111 = this.f430398h;
        if (r111 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
        r111 = null;
    L30:
        r111.setCurrentItem(0, false);
        FaceViewPager r112 = this.f430398h;
        if (r112 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
    L34:
        r102.setEnableScroll(false);
        int r113 = com.ss.android.lark.reaction.widget.emojipanel.a.f439363a;
        Statistics.sendEvent("public_emoji_panel_widget_view");
        this.f430407q = true;
        return;
    L33:
        r102 = r112;
        goto L34
    L12:
        r105 = null;
        goto L13
    L35:
        this.f430396f.e();
        View r114 = this.f430399i;
        if (r114 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceIcon");
        r114 = null;
    L39:
        if ((r114 instanceof ImageView) == false) goto L41;
        ImageView r115 = (ImageView) r114;
    L42:
        if (r115 == null) goto L44;
        r115.setImageResource(R.drawable.ud_icon_emoji_keyboard_outlined);
    L44:
        View r116 = this.f430399i;
        if (r116 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceIcon");
        r116 = null;
    L47:
        r116.setSelected(false);
        View r117 = this.f430397g;
        if (r117 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        r117 = null;
    L50:
        r117.setVisibility(0);
        K();
        FaceViewPager r118 = this.f430398h;
        if (r118 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
        r118 = null;
    L53:
        r118.setCurrentItem(0, false);
        FaceViewPager r119 = this.f430398h;
        if (r119 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
    L57:
        r103.setEnableScroll(false);
        return;
    L56:
        r103 = r119;
        goto L57
    L41:
        r115 = null;
        goto L42
    L58:
        View r120 = this.f430399i;
        if (r120 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceIcon");
        r120 = null;
    L62:
        if ((r120 instanceof ImageView) == false) goto L64;
        ImageView r121 = (ImageView) r120;
    L65:
        if (r121 == null) goto L67;
        r121.setImageResource(R.drawable.ud_icon_emoji_outlined);
    L67:
        View r122 = this.f430399i;
        if (r122 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceIcon");
        r122 = null;
    L70:
        r122.setSelected(false);
        View r123 = this.f430397g;
        if (r123 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
    L74:
        r101.setVisibility(8);
        return;
    L73:
        r101 = r123;
        goto L74
    L64:
        r121 = null;
        goto L65
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.PanelMenuItem
    public final View G(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Log.i("FaceKBPluginNew", "onCreatePluginPanel initPanelView");
        if (this.f430397g != null) goto L9;
        J();
        View r101 = this.f430397g;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        r101 = null;
    L8:
        r100.addView(r101);
        K();
    L9:
        View r102 = this.f430397g;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        return null;
    L13:
        return r102;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(i r100) {
        Intrinsics.checkNotNullParameter(r100, "iconHolder");
        Intrinsics.checkNotNullParameter(r100, "iconHolder");
        View r101 = r100.f429551a;
        this.f430399i = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceIcon");
        r101 = null;
    L5:
        r101.setActivated(this.f430394d);
    }

    public VoiceFaceKBPlugin(boolean r100, FragmentManager r101, IVoiceFaceDependency r102) {
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        Intrinsics.checkNotNullParameter(r102, "faceDependency");
        this.f430394d = r100;
        this.f430395e = r101;
        this.f430396f = r102;
        this.f430404n = new ArrayList();
        this.f430405o = new ArrayList();
        this.f430406p = VoiceFaceKBPlugin$mPluginClickListener$1.INSTANCE;
        this.f430408r = KeyboardMenuItemKey.Emoji;
        this.f430409s = PanelMenuItem.InitialStrategy.Idle;
        this.f430410t = new b(this);
    }
}
