package com.ss.android.lark.picker.base.view.avataritem;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b08.a;
import b08.c;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.common.utility.UIUtils;
import com.larksuite.component.decoration.avatar.DecoratedAvatar;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel4;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.ui.PriorityLayout;
import com.larksuite.framework.ui.SpareLayout;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chat.entity.chatter.AvatarMedal;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.utils.SearchCommonFgUtils;
import com.ss.android.lark.picker.base.view.avataritem.checkbox.CheckBoxBinder;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.search.dto.info.ExtraInfoSummary;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusLinearLayout;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import w3c.b;
import w3c.e;
import w3c.f;
import w3c.g;
import w3c.h;
import w3c.j;
import y9c.d;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 È\u00012\u00020\u00012\u00020\u0002:\u0004È\u0001É\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010E\u001a\u00020F2\u0006\u00101\u001a\u000202J\u000e\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020IJ\u000e\u0010J\u001a\u00020F2\u0006\u0010K\u001a\u00020LJ\u000e\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u00020OJ\u000e\u0010P\u001a\u00020F2\u0006\u0010N\u001a\u00020OJ\u0006\u0010Q\u001a\u00020FJ7\u0010R\u001a\u00020F2\b\u0010S\u001a\u0004\u0018\u00010T2\b\u0010U\u001a\u0004\u0018\u00010V2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010X2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010X¢\u0006\u0002\u0010ZJ\u001c\u0010R\u001a\u00020F2\b\u0010S\u001a\u0004\u0018\u00010T2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010TJ\u000e\u0010\\\u001a\u00020F2\u0006\u0010]\u001a\u00020\bJ\u0006\u0010^\u001a\u00020FJ\u000e\u0010_\u001a\u00020F2\u0006\u0010`\u001a\u00020aJ\u0010\u0010b\u001a\u00020F2\b\u0010c\u001a\u0004\u0018\u00010dJ\u0012\u0010e\u001a\u00020F2\n\u0010f\u001a\u0006\u0012\u0002\b\u00030gJ\u0012\u0010h\u001a\u00020F2\n\u0010f\u001a\u0006\u0012\u0002\b\u00030gJ\u0006\u0010i\u001a\u00020FJ\u0006\u0010j\u001a\u00020\u0000J\u000e\u0010[\u001a\u00020F2\u0006\u0010k\u001a\u00020lJ\u000e\u0010m\u001a\u00020F2\u0006\u0010n\u001a\u00020oJ\u0006\u0010p\u001a\u00020FJ\u000e\u0010q\u001a\u00020F2\u0006\u0010r\u001a\u00020sJ\u000e\u0010!\u001a\u00020F2\u0006\u0010t\u001a\u00020uJ\"\u0010v\u001a\u00020F2\u0006\u0010w\u001a\u0002002\b\b\u0002\u0010x\u001a\u00020I2\b\b\u0002\u0010y\u001a\u00020IJ\u0006\u0010z\u001a\u00020FJ\u000e\u0010{\u001a\u00020F2\u0006\u0010|\u001a\u00020}J\u000e\u0010~\u001a\u00020F2\u0006\u0010\u007f\u001a\u00020\bJ\u0007\u0010\u0080\u0001\u001a\u00020FJ\u0010\u0010\u0081\u0001\u001a\u00020F2\u0007\u0010\u0082\u0001\u001a\u00020}J\u0010\u0010\u0083\u0001\u001a\u00020F2\u0007\u0010\u0084\u0001\u001a\u00020\bJ\u001a\u0010\u0085\u0001\u001a\u00020F2\u0007\u0010\u0086\u0001\u001a\u00020\u001c2\u0006\u0010|\u001a\u00020}H\u0002J\t\u0010\u008a\u0001\u001a\u00020FH\u0002J\t\u0010\u008b\u0001\u001a\u00020\bH\u0002J\u0011\u0010\u008c\u0001\u001a\u00020F2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001J\u0011\u0010\u008e\u0001\u001a\u00020F2\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001J\u0012\u0010\u0091\u0001\u001a\u00020F2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010VJ\u0010\u0010\u0093\u0001\u001a\u00020F2\u0007\u0010\u0094\u0001\u001a\u000200J\u000f\u0010\u0095\u0001\u001a\u00020F2\u0006\u0010>\u001a\u000200J\u0011\u0010\u0096\u0001\u001a\u00020F2\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001J\u001a\u0010\u0096\u0001\u001a\u00020F2\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u0099\u0001\u001a\u00020\bJ\u0010\u0010\u009a\u0001\u001a\u00020F2\u0007\u0010\u009b\u0001\u001a\u00020IJ\u001a\u0010\u009c\u0001\u001a\u00020F2\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\bJ\u0015\u0010 \u0001\u001a\u00020F2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001H\u0016J\t\u0010£\u0001\u001a\u000200H\u0014J\t\u0010¤\u0001\u001a\u000200H\u0002J\u0010\u0010¥\u0001\u001a\u00020\u00002\u0007\u0010¦\u0001\u001a\u00020\bJ\t\u0010§\u0001\u001a\u00020FH\u0002J\t\u0010¨\u0001\u001a\u00020FH\u0014J\u0007\u0010©\u0001\u001a\u00020FJ\t\u0010ª\u0001\u001a\u00020FH\u0002J\u0012\u0010«\u0001\u001a\u00020F2\u0007\u0010¬\u0001\u001a\u00020XH\u0002J\u001b\u0010\u00ad\u0001\u001a\u00020F2\u0007\u0010®\u0001\u001a\u00020\b2\u0007\u0010¯\u0001\u001a\u00020\bH\u0014J\u0015\u0010°\u0001\u001a\u00020\b*\u00020\u001c2\u0006\u0010W\u001a\u00020\bH\u0002J\u0007\u0010±\u0001\u001a\u00020XJ\u0010\u0010²\u0001\u001a\u00020F2\u0007\u0010³\u0001\u001a\u00020\bJ\u0010\u0010´\u0001\u001a\u00020F2\u0007\u0010³\u0001\u001a\u00020\bJ\u0010\u0010µ\u0001\u001a\u00020F2\u0007\u0010³\u0001\u001a\u00020\bJ\u0010\u0010¶\u0001\u001a\u00020F2\u0007\u0010³\u0001\u001a\u00020\bJ\u0012\u0010·\u0001\u001a\u00020F2\u0007\u0010³\u0001\u001a\u00020\bH\u0002J\u0010\u0010¸\u0001\u001a\u00020F2\u0007\u0010¬\u0001\u001a\u00020XJ\u0010\u0010¹\u0001\u001a\u00020F2\u0007\u0010º\u0001\u001a\u00020IJ\t\u0010»\u0001\u001a\u00020\bH\u0002J\t\u0010¼\u0001\u001a\u00020\bH\u0002J\u000b\u0010½\u0001\u001a\u00020\b*\u00020\bJ\u000b\u0010½\u0001\u001a\u00020\b*\u00020XJ\u000b\u0010¾\u0001\u001a\u00020X*\u00020XJü\u0001\u0010¿\u0001\u001a\u00020F\"\u0014\b\u0000\u0010À\u0001*\r Â\u0001*\u0005\u0018\u00010Á\u00010Á\u0001\"\u0012\b\u0001\u0010Ã\u0001*\u000b Â\u0001*\u0004\u0018\u0001000022\u0010Ä\u0001\u001a-\u0012\u000f\u0012\r Â\u0001*\u0005\u0018\u0001HÀ\u0001HÀ\u0001 Â\u0001*\u0015\u0012\u000f\u0012\r Â\u0001*\u0005\u0018\u0001HÀ\u0001HÀ\u0001\u0018\u00010g0g22\u0010Å\u0001\u001a-\u0012\u000f\u0012\r Â\u0001*\u0005\u0018\u0001HÃ\u0001HÃ\u0001 Â\u0001*\u0015\u0012\u000f\u0012\r Â\u0001*\u0005\u0018\u0001HÃ\u0001HÃ\u0001\u0018\u00010g0g2^\u0010Æ\u0001\u001aY\u0012\u0011\b\u0000\u0012\r Â\u0001*\u0005\u0018\u0001HÃ\u0001HÃ\u0001\u0012\u0011\b\u0000\u0012\r Â\u0001*\u0005\u0018\u0001HÀ\u0001HÀ\u0001 Â\u0001*+\u0012\u0011\b\u0000\u0012\r Â\u0001*\u0005\u0018\u0001HÃ\u0001HÃ\u0001\u0012\u0011\b\u0000\u0012\r Â\u0001*\u0005\u0018\u0001HÀ\u0001HÀ\u0001\u0018\u00010Ç\u00010Ç\u0001H\u0096\u0001R\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b:\u0010;R\u001b\u0010>\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010=\u001a\u0004\b?\u0010;R\u000e\u0010A\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0089\u0001\u001a\u00030\u0088\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ê\u0001"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView;", "Landroid/widget/LinearLayout;", "Lcom/larksuite/component/ui/list/ICompositeComponent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "compositeComponentDelegate", "Lcom/larksuite/component/ui/list/CompositeComponentDelegate;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/larksuite/component/ui/list/CompositeComponentDelegate;)V", "getCompositeComponentDelegate", "()Lcom/larksuite/component/ui/list/CompositeComponentDelegate;", "dslRenderContainer", "checkBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "decoratedAvatarView", "Lcom/larksuite/component/decoration/avatar/DecoratedAvatar;", "avatarView", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "getAvatarView", "()Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "setAvatarView", "(Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;)V", "miniAvatarView", "titleView", "Landroid/widget/TextView;", "personalStatusView", "Landroid/widget/ImageView;", "titleTailView", "Lcom/ss/android/lark/widget/EllipsizedEmojiconTextView;", "userStatus", "Lcom/suite/lark/platform/component/widget_biz_userstatus/UserStatusLinearLayout;", "subTitleView", "localTimeView", "assignTimeView", "summaryView", "getSummaryView", "()Landroid/widget/TextView;", "setSummaryView", "(Landroid/widget/TextView;)V", "extraInfoView", "Lcom/ss/android/lark/picker/base/view/avataritem/ExtraInfoView;", "bottomFrameLayout", "Landroid/widget/FrameLayout;", ItemStyle.ITEM_STYLE_DIVIDER, "Landroid/view/View;", "checkBoxModel", "Lcom/ss/android/lark/search/dto/bindermodel/CheckBoxModel;", "contentLayout", "avatarItemSubtitleContainer", "rightItemWrapper", "Landroid/view/ViewGroup;", "rightTagWrapper", "rightViewHolder", "contentView", "getContentView", "()Landroid/view/View;", "contentView$delegate", "Lkotlin/Lazy;", "bottomView", "getBottomView", "bottomView$delegate", "mOldWidthMeasureSpec", "mOldHeightMeasureSpec", "fgUtils", "Lcom/ss/android/lark/picker/base/utils/SearchCommonFgUtils;", "checkState", "", "updateCheckState", "isChecked", "", "medal", "medalModel", "Lcom/ss/android/lark/chat/entity/chatter/AvatarMedal;", "avatar", "avatarModel", "Lcom/larksuite/component/ui/avatar/AvatarModel;", "miniAvatar", "userTeamBadge", "bindAvatarWithUrl", "url", "", "placeHolder", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/Float;Ljava/lang/Float;)V", "title", "bindAvatarWithResourceID", "resourceID", "adjustAlign", IAllianceService.CONTENT_TYPE_BADGE, "badgeModel", "Lcom/larksuite/component/ui/badge/BadgeModel;", "miniIcon", "miniIconModel", "Lcom/larksuite/component/ui/badge/miniicon/MiniIconModel;", "unBindAvatar", "modelClass", "Ljava/lang/Class;", "unBindMiniAvatar", "unBindMedal", "resetTags", "titleModel", "Lcom/ss/android/lark/search/dto/bindermodel/TitleModel;", "personalStatus", "status", "Lcom/ss/android/lark/search/dto/bindermodel/PersonalStatus;", "unbindPersonalStatus", "titleTail", "tailModel", "Lcom/ss/android/lark/search/dto/bindermodel/TitleTailModel;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/ss/android/lark/search/dto/bindermodel/UserStatusModel;", "attachRightView", BaseSwitches.V, "just2Center", "isExpandClickArea", "removeRightView", "subTitle", "subtitleModel", "Lcom/ss/android/lark/search/dto/bindermodel/SubtitleModel;", "setSubTitleLines", "maxLines", "justCheckBoxToCenter", "summary", "summaryModel", "setSubTitleMaxLines", "maxLine", "bindTextViewWithModel", "view", "subTitleState", "Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView$UiState;", "summaryState", "adjustAvatarTopMargin", "adjustCheckboxTopMargin", "localTime", "Lcom/ss/android/lark/search/dto/bindermodel/LocalTimeModel;", "assignTime", "time", "Lcom/ss/android/lark/search/dto/bindermodel/AssignTimeModel;", "setSubtitleTag", "drawable", "addViewToRender", "renderView", "addBottomView", "setTag", "builder", "Lcom/larksuite/component/ui/tag/LarkNameTag$Builder;", "tagMode", "showDivider", "isShow", "setExtraInfoSummary", "extraInfoSummary", "Lcom/ss/android/lark/search/dto/info/ExtraInfoSummary;", "type", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "createContentView", "createBottomView", "applyStyle", "style", "layoutSelf", "registerBinder", "resetAllViews", "resetMiniAvatarStyle", "setMiniAvatarSize", "size", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "numOfCharsByHanziOne", "subTitleTextSize", "avatarTopMargin", GXTemplateKey.FLEXBOX_MARGIN, "checkBoxStartMargin", "avatarStartMargin", "titleBottomMargin", "avatarMarginStart", "avatarSizeAdjust", "avatarShape", "isOval", "getTitleHeightWithZoom", "getSubTitleHeightWithZoom", "dp", "dpF", "registerModelBinder", "M", "", "kotlin.jvm.PlatformType", "V", "p0", "p1", "p2", "Lcom/larksuite/component/ui/list/IComponentBinder;", "Companion", "UiState", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AvatarItemView extends LinearLayout implements c {
    private static final float AVATAR_ITEM_HEIGHT = 76.0f;
    public static final float AVATAR_SIZE = 48.0f;
    private static final float CHECKBOX_LAYOUT_SIZE = 20.0f;
    private static final float CHECK_BOX_TOP_MARGIN = 26.0f;
    public static final Companion Companion = null;
    private static final float DIVIDER_HEIGHT = 0.5f;
    private static final float DRAWABLE_PADDING_4 = 4.0f;
    public static final int FIRST_VIEW_MIN_WIDTH = 86;
    public static final float LAYOUT_MARGIN_12 = 12.0f;
    public static final float LAYOUT_MARGIN_16 = 16.0f;
    private static final float LAYOUT_MARGIN_4 = 4.0f;
    public static final float LAYOUT_MARGIN_8 = 8.0f;
    public static final float MIN_AVATAR_SIZE = 22.0f;
    private static final float SUBTITLE_HEIGHT = 22.0f;
    private static final String TAG = "LarkSearch.Common.AvatarItemView";
    public static final int TAG_MODE_ALIGN_RIGHT = 2;
    public static final int TAG_MODE_TEXT_END = 1;
    private static final float TEXT_SIZE_12 = 12.0f;
    private static final float TEXT_SIZE_14 = 14.0f;
    private static final float TEXT_SIZE_17 = 17.0f;
    private static final float TITLE_HEIGHT = 24.0f;
    private static final float USER_TEAM_BADGE_ICON_SIZE = 12.0f;
    private static final float USER_TEAM_BADGE_SIZE = 24.0f;
    private TextView assignTimeView;
    private LinearLayout avatarItemSubtitleContainer;
    public LarkAvatarView avatarView;
    private FrameLayout bottomFrameLayout;
    private final Lazy bottomView$delegate;
    private UDCheckBox checkBox;
    private b checkBoxModel;
    private final a compositeComponentDelegate;
    private FrameLayout contentLayout;
    private final Lazy contentView$delegate;
    private DecoratedAvatar decoratedAvatarView;
    private View divider;
    private LinearLayout dslRenderContainer;
    private ExtraInfoView extraInfoView;
    private SearchCommonFgUtils fgUtils;
    private TextView localTimeView;
    private int mOldHeightMeasureSpec;
    private int mOldWidthMeasureSpec;
    private LarkAvatarView miniAvatarView;
    private ImageView personalStatusView;
    private ViewGroup rightItemWrapper;
    private ImageView rightTagWrapper;
    private FrameLayout rightViewHolder;
    private UiState subTitleState;
    private TextView subTitleView;
    private UiState summaryState;
    public TextView summaryView;
    private EllipsizedEmojiconTextView titleTailView;
    private TextView titleView;
    private UserStatusLinearLayout userStatus;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView$Companion;", "", "<init>", "()V", "AVATAR_ITEM_HEIGHT", "", "CHECKBOX_LAYOUT_SIZE", "AVATAR_SIZE", "MIN_AVATAR_SIZE", "USER_TEAM_BADGE_SIZE", "USER_TEAM_BADGE_ICON_SIZE", "LAYOUT_MARGIN_16", "LAYOUT_MARGIN_12", "LAYOUT_MARGIN_8", "LAYOUT_MARGIN_4", "TEXT_SIZE_17", "TEXT_SIZE_14", "TEXT_SIZE_12", "DRAWABLE_PADDING_4", "DIVIDER_HEIGHT", "CHECK_BOX_TOP_MARGIN", "TAG_MODE_TEXT_END", "", "TAG_MODE_ALIGN_RIGHT", "FIRST_VIEW_MIN_WIDTH", "TAG", "", "TITLE_HEIGHT", "SUBTITLE_HEIGHT", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView$UiState;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "SHOW", "HIDE", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UiState extends Enum<UiState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ UiState[] $VALUES = null;
        public static final UiState HIDE = null;
        public static final UiState NONE = null;
        public static final UiState SHOW = null;

        private static final /* synthetic */ UiState[] $values() {
            return new UiState[]{NONE, SHOW, HIDE};
        }

        public static EnumEntries<UiState> getEntries() {
            return $ENTRIES;
        }

        static {
            NONE = new UiState(UserProfileEvent.POSITION_NONE, 0);
            SHOW = new UiState("SHOW", 1);
            HIDE = new UiState("HIDE", 2);
            UiState[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static UiState[] values() {
            return (UiState[]) $VALUES.clone();
        }

        public static UiState valueOf(String r100) {
            return (UiState) r27.a.a(UiState.class, r100);
        }

        private UiState(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AvatarItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, null, 14, null);
    }

    public AvatarItemView(Context r100, AttributeSet r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r110, 0, null, 12, null);
    }

    public AvatarItemView(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r110, r111, null, 8, null);
    }

    @Override // b08.c
    public <M, V extends View> void registerModelBinder(Class<M> r100, Class<V> r101, b08.b<? super V, ? super M> r102) {
        this.compositeComponentDelegate.registerModelBinder(r100, r101, r102);
    }

    private final void adjustAvatarTopMargin() {
        UiState r100 = this.subTitleState;
        UiState r101 = UiState.NONE;
        if (r100 == r101) goto L12;
        UiState r102 = this.summaryState;
        if (r102 == r101) goto L13;
        UiState r103 = UiState.SHOW;
        if (r100 != r103) goto L10;
        if (r102 != r103) goto L10;
        avatarTopMargin(16);
        return;
    L10:
        avatarTopMargin(12);
        return;
    L13:
        return;
    }

    private final int adjustCheckboxTopMargin() {
        UiState r100 = this.subTitleState;
        UiState r101 = UiState.NONE;
        if (r100 == r101) goto L13;
        UiState r102 = this.summaryState;
        if (r102 == r101) goto L13;
        UiState r103 = UiState.SHOW;
        if (r100 != r103) goto L11;
        if (r102 != r103) goto L11;
        return dp(14.0f) + 16;
    L11:
        return dp(14.0f) + 12;
    L13:
        return dp(CHECK_BOX_TOP_MARGIN);
    }

    private final View createBottomView() {
        FrameLayout r100 = new FrameLayout(getContext());
        r100.setId(R.id.avatar_item_bottom_frameLayout);
        r100.setVisibility(8);
        r100.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.bottomFrameLayout = r100;
        return r100;
    }

    private final View getBottomView() {
        return (View) this.bottomView$delegate.getValue();
    }

    private final View getContentView() {
        return (View) this.contentView$delegate.getValue();
    }

    private final int getSubTitleHeightWithZoom() {
        return (int) a08.b.a(dpF(22.0f), getContext());
    }

    private final int getTitleHeightWithZoom() {
        return (int) a08.b.a(dpF(24.0f), getContext());
    }

    private final void resetMiniAvatarStyle() {
        LarkAvatarView r100 = this.miniAvatarView;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r100 = null;
    L5:
        r100.setBackground(null);
        LarkAvatarView r101 = this.miniAvatarView;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r101 = null;
    L8:
        r101.setPadding(0, 0, 0, 0);
        LarkAvatarView r102 = this.miniAvatarView;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r102 = null;
    L11:
        r102.setImageDrawable(null);
        setMiniAvatarSize(22.0f);
    }

    public final void adjustAlign() {
        ViewGroup r100 = this.rightItemWrapper;
        DecoratedAvatar r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
        r100 = null;
    L5:
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof RelativeLayout.LayoutParams) == false) goto L8;
        RelativeLayout.LayoutParams r103 = (RelativeLayout.LayoutParams) r102;
    L10:
        if (r103 == null) goto L15;
        r103.topMargin = 0;
        r103.removeRule(15);
        ViewGroup r104 = this.rightItemWrapper;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
        r104 = null;
    L14:
        r104.setLayoutParams(r103);
    L15:
        DecoratedAvatar r105 = this.decoratedAvatarView;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r105 = null;
    L18:
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof RelativeLayout.LayoutParams) == false) goto L21;
        RelativeLayout.LayoutParams r107 = (RelativeLayout.LayoutParams) r106;
    L22:
        if (r107 == null) goto L29;
        r107.removeRule(15);
        DecoratedAvatar r108 = this.decoratedAvatarView;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
    L27:
        r101.setLayoutParams(r107);
        return;
    L26:
        r101 = r108;
        goto L27
    L29:
        return;
    L21:
        r107 = null;
        goto L22
    L8:
        r103 = null;
        goto L10
    }

    public View createContentView() {
        RelativeLayout r100 = new RelativeLayout(getContext());
        r100.setId(R.id.avatar_item_parent_container);
        r100.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        r100.setMinimumHeight(dp(AVATAR_ITEM_HEIGHT));
        r100.setPadding(0, 0, dp(16.0f), 0);
        UDCheckBox r101 = new UDCheckBox(getContext());
        r101.setId(R.id.avatar_item_checkbox);
        r101.setVisibility(8);
        r101.setPadding(0, 0, 0, 0);
        r101.setSize(UDCheckBox.CheckBoxSize.SMALL_SIZE);
        RelativeLayout.LayoutParams r102 = new RelativeLayout.LayoutParams(dp(20.0f), dp(20.0f));
        r102.setMarginStart(dp(16.0f));
        r102.addRule(15);
        setGravity(16);
        r101.setLayoutParams(r102);
        r100.addView(r101);
        r101.setClickable(false);
        this.checkBox = r101;
        DecoratedAvatar r103 = new DecoratedAvatar(getContext(), null, 6, 0);
        r103.setId(R.id.avatar_item_decoration);
        RelativeLayout.LayoutParams r110 = new RelativeLayout.LayoutParams(dp(48.0f), dp(48.0f));
        r110.addRule(17, R.id.avatar_item_checkbox);
        r110.addRule(1, R.id.avatar_item_checkbox);
        r110.addRule(15);
        r110.topMargin = dp(12.0f);
        r110.setMarginStart(dp(16.0f));
        r110.setMarginEnd(dp(12.0f));
        r103.setLayoutParams(r110);
        r100.addView(r103);
        this.decoratedAvatarView = r103;
        LarkAvatarView r104 = new LarkAvatarView(getContext());
        r104.setId(R.id.avatar_item_avatar);
        r104.setScaleType(ImageView.ScaleType.CENTER_CROP);
        DecoratedAvatar r105 = this.decoratedAvatarView;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r105 = null;
    L5:
        r105.a(r104);
        setAvatarView(r104);
        LarkAvatarView r106 = new LarkAvatarView(getContext());
        r106.setId(R.id.avatar_item_mini_avatar);
        RelativeLayout.LayoutParams r107 = new RelativeLayout.LayoutParams(dp(22.0f), dp(22.0f));
        r107.addRule(19, R.id.avatar_item_decoration);
        r106.setLayoutParams(r107);
        r106.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r106.setVisibility(8);
        if (yz7.a.f569550b == true) goto L8;
    L10:
        boolean r108 = false;
    L12:
        if (r108 == false) goto L14;
        ViewGroup.LayoutParams r109 = r106.getLayoutParams();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r109).addRule(15);
        r106.setTranslationY(dpF(13.0f));
    L15:
        r100.addView(r106);
        this.miniAvatarView = r106;
        FrameLayout r111 = new FrameLayout(getContext());
        r111.setId(R.id.avatar_item_middle_frameLayout);
        RelativeLayout.LayoutParams r112 = new RelativeLayout.LayoutParams(-1, -2);
        r112.addRule(17, R.id.avatar_item_decoration);
        r112.addRule(1, R.id.avatar_item_decoration);
        r112.addRule(0, R.id.avatar_item_rightItemWrapper);
        r112.addRule(16, R.id.avatar_item_rightItemWrapper);
        r112.addRule(15);
        r111.setLayoutParams(r112);
        r100.addView(r111);
        this.contentLayout = r111;
        LinearLayout r113 = new LinearLayout(getContext());
        r113.setOrientation(0);
        r113.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r111.addView(r113);
        LinearLayout r114 = new LinearLayout(getContext());
        this.avatarItemSubtitleContainer = r114;
        r114.setId(R.id.avatar_item_subtitle_container);
        r114.setOrientation(1);
        r114.setGravity(16);
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        r115.topMargin = dp(12.0f);
        r115.bottomMargin = dp(12.0f);
        r114.setLayoutParams(r115);
        r113.addView(r114);
        LinearLayout r116 = new LinearLayout(getContext());
        r116.setId(R.id.avatar_item_rightItemWrapper);
        r116.setOrientation(0);
        RelativeLayout.LayoutParams r117 = new RelativeLayout.LayoutParams(-2, -2);
        r117.addRule(6, R.id.avatar_item_decoration);
        r117.addRule(21);
        r117.addRule(15);
        r117.topMargin = dp(12.0f);
        r117.setMarginStart(dp(12.0f));
        this.rightItemWrapper = r116;
        r116.setVisibility(8);
        r100.addView(r116, r117);
        FrameLayout r118 = new FrameLayout(getContext());
        LinearLayout.LayoutParams r119 = new LinearLayout.LayoutParams(-2, -2);
        this.rightViewHolder = r118;
        r116.addView(r118, r119);
        RelativeLayout r120 = new RelativeLayout(getContext());
        r120.setId(R.id.avatar_item_title_container);
        r120.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r114.addView(r120);
        PriorityLayout r121 = new PriorityLayout(getContext(), null, 6, 0);
        r121.setId(R.id.avatar_item_spare_container);
        RelativeLayout.LayoutParams r122 = new RelativeLayout.LayoutParams(-1, getTitleHeightWithZoom());
        r122.addRule(16, R.id.avatar_item_assign_time);
        r122.addRule(0, R.id.avatar_item_assign_time);
        r122.addRule(9);
        r122.addRule(15);
        r121.setLayoutParams(r122);
        r120.addView(r121);
        TextView r123 = new TextView(getContext());
        r123.setId(R.id.avatar_item_assign_time);
        r123.setTextSize(2, 12.0f);
        r123.setTextColor(getContext().getResources().getColor(R.color.lkui_N500));
        r123.setGravity(16);
        r123.setVisibility(8);
        RelativeLayout.LayoutParams r124 = new RelativeLayout.LayoutParams(-2, getTitleHeightWithZoom());
        r124.addRule(16, R.id.avatar_item_end_tag);
        r124.addRule(15);
        r124.setMarginStart(dp(12.0f));
        r124.setMarginStart(dp(8.0f));
        r124.addRule(11);
        r120.addView(r123, r124);
        this.assignTimeView = r123;
        ImageView r125 = new ImageView(getContext());
        r125.setId(R.id.avatar_item_end_tag);
        RelativeLayout.LayoutParams r126 = new RelativeLayout.LayoutParams(-2, -2);
        r126.addRule(11);
        r126.addRule(15);
        r126.setMarginStart(dp(12.0f));
        this.rightTagWrapper = r125;
        r120.addView(r125, r126);
        SpareLayout r127 = new SpareLayout(getContext());
        if (this.fgUtils.enableFirstMinSize() == false) goto L18;
        r127.setFirstViewMinWidth(zz7.b.g(getContext(), 86));
    L18:
        PriorityLayout.LayoutParams r128 = new PriorityLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams) r128).gravity = 16;
        r128.f285827a = 10;
        r127.setLayoutParams(r128);
        r121.addView(r127);
        UserStatusLinearLayout r129 = new UserStatusLinearLayout(getContext());
        PriorityLayout.LayoutParams r130 = new PriorityLayout.LayoutParams(-1, getTitleHeightWithZoom());
        ((FrameLayout.LayoutParams) r130).gravity = 16;
        r130.f285827a = 1;
        r130.setMarginStart(dp(8.0f));
        r129.setLayoutParams(r130);
        r129.setMaxLines(1);
        r129.setVisibility(8);
        r121.addView(r129);
        this.userStatus = r129;
        EllipsizedEmojiconTextView r131 = new EllipsizedEmojiconTextView(getContext());
        r131.setId(R.id.avatar_item_title);
        r131.setLayoutParams(new LinearLayout.LayoutParams(-2, getTitleHeightWithZoom()));
        r131.setEllipsize(TextUtils.TruncateAt.END);
        r131.setIncludeFontPadding(false);
        r131.setGravity(16);
        r131.setMaxLines(1);
        r131.setSingleLine(true);
        r131.setTextSize(2, 17.0f);
        r131.setTextColor(getContext().getResources().getColor(R.color.text_title));
        r127.addView(r131);
        this.titleView = r131;
        ImageView r132 = new ImageView(getContext());
        FrameLayout.LayoutParams r133 = new FrameLayout.LayoutParams(-2, -2);
        r133.leftMargin = dp(8.0f);
        r133.gravity = 16;
        r132.setLayoutParams(r133);
        r132.setVisibility(8);
        r127.addView(r132);
        this.personalStatusView = r132;
        EllipsizedEmojiconTextView r134 = new EllipsizedEmojiconTextView(getContext());
        r134.setId(R.id.avatar_item_title_tail);
        r134.setLayoutParams(new LinearLayout.LayoutParams(-2, getTitleHeightWithZoom()));
        r134.setGravity(16);
        r134.setMaxLines(1);
        r134.setSingleLine(true);
        r134.setTextSize(2, 17.0f);
        r134.setTextColor(getContext().getResources().getColor(R.color.text_placeholder));
        r127.addView(r134);
        this.titleTailView = r134;
        TextView r135 = new TextView(getContext());
        r135.setId(R.id.avatar_item_localtime);
        r135.setTextSize(2, 12.0f);
        r135.setTextColor(getContext().getResources().getColor(R.color.lkui_N500));
        r135.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(R.drawable.icon_local_time), null, null, null);
        r135.setCompoundDrawablePadding(dp(4.0f));
        r135.setIncludeFontPadding(false);
        r135.setGravity(16);
        r135.setVisibility(8);
        LinearLayout.LayoutParams r136 = new LinearLayout.LayoutParams(-2, -1);
        r136.setMarginStart(dp(8.0f));
        r127.addView(r135, r136);
        this.localTimeView = r135;
        EllipsizedEmojiconTextView r137 = new EllipsizedEmojiconTextView(getContext());
        r137.setId(R.id.avatar_item_subtitle);
        r137.setLayoutParams(new LinearLayout.LayoutParams(-2, getSubTitleHeightWithZoom()));
        ViewGroup.LayoutParams r138 = r137.getLayoutParams();
        Intrinsics.checkNotNull(r138, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r138).topMargin = dp(4.0f);
        r137.setIncludeFontPadding(false);
        r137.setGravity(16);
        if (this.fgUtils.enableSearchDepartment() == false) goto L21;
        r137.f445616j = TextUtils.TruncateAt.START;
    L22:
        r137.setMaxLines(1);
        r137.setSingleLine(true);
        r137.setTextSize(2, 14.0f);
        r137.setTextColor(getContext().getResources().getColor(R.color.text_placeholder));
        r137.setVisibility(8);
        r114.addView(r137);
        this.subTitleView = r137;
        EllipsizedEmojiconTextView r139 = new EllipsizedEmojiconTextView(getContext());
        r139.setId(R.id.avatar_item_summary);
        r139.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams r140 = r139.getLayoutParams();
        Intrinsics.checkNotNull(r140, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r140).topMargin = dp(4.0f);
        r139.setIncludeFontPadding(false);
        r139.setGravity(16);
        r139.setEllipsize(TextUtils.TruncateAt.END);
        r139.setMaxLines(1);
        r139.setSingleLine(true);
        r139.setTextSize(2, 14.0f);
        r139.setTextColor(getContext().getResources().getColor(R.color.text_placeholder));
        r139.setVisibility(8);
        r114.addView(r139);
        setSummaryView(r139);
        ExtraInfoView r141 = new ExtraInfoView(getContext());
        r141.setId(R.id.avatar_item_extra_info);
        r141.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams r142 = r141.getLayoutParams();
        Intrinsics.checkNotNull(r142, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r142).topMargin = dp(4.0f);
        r141.setVisibility(8);
        r114.addView(r141);
        this.extraInfoView = r141;
        LinearLayout r143 = new LinearLayout(getContext());
        this.dslRenderContainer = r143;
        r143.setVisibility(8);
        LinearLayout r144 = this.dslRenderContainer;
        if (r144 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("dslRenderContainer");
        r144 = null;
    L25:
        r144.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        View r145 = this.dslRenderContainer;
        if (r145 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("dslRenderContainer");
        View r146 = null;
    L29:
        r114.addView(r146);
        View r147 = new View(getContext());
        r147.setId(R.id.avatar_item_divider);
        RelativeLayout.LayoutParams r148 = new RelativeLayout.LayoutParams(-1, dp(0.5f));
        r148.addRule(12);
        r148.addRule(18, R.id.avatar_item_middle_frameLayout);
        r148.addRule(7, R.id.avatar_item_middle_frameLayout);
        r147.setLayoutParams(r148);
        r147.setBackgroundColor(getContext().getResources().getColor(R.color.line_divider_default));
        r100.addView(r147);
        this.divider = r147;
        registerBinder();
        return r100;
    L28:
        r146 = r145;
        goto L29
    L21:
        r137.setEllipsize(TextUtils.TruncateAt.END);
        r137.f445616j = TextUtils.TruncateAt.END;
        goto L22
    L14:
        ViewGroup.LayoutParams r149 = r106.getLayoutParams();
        Intrinsics.checkNotNull(r149, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r149).addRule(8, R.id.avatar_item_decoration);
        goto L15
    L8:
        if (yz7.a.f569549a == false) goto L10;
        r108 = true;
        goto L12
    }

    public final LarkAvatarView getAvatarView() {
        LarkAvatarView r100 = this.avatarView;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        return null;
    }

    public final TextView getSummaryView() {
        TextView r100 = this.summaryView;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("summaryView");
        return null;
    }

    public final void justCheckBoxToCenter() {
        UDCheckBox r100 = this.checkBox;
        RelativeLayout.LayoutParams r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r100 = null;
    L6:
        if (r100.getLayoutParams() == null) goto L16;
        UDCheckBox r102 = this.checkBox;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r102 = null;
    L10:
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof RelativeLayout.LayoutParams) == false) goto L13;
        r101 = (RelativeLayout.LayoutParams) r103;
    L13:
        if (r101 == null) goto L17;
        r101.addRule(15);
        setGravity(16);
        return;
    L17:
        return;
    }

    public final void removeRightView() {
        FrameLayout r100 = this.rightViewHolder;
        ViewGroup r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rightViewHolder");
        r100 = null;
    L5:
        r100.removeAllViews();
        ViewGroup r102 = this.rightItemWrapper;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
    L9:
        r101.setVisibility(8);
        return;
    L8:
        r101 = r102;
        goto L9
    }

    public final void resetAllViews() {
        a r100 = this.compositeComponentDelegate;
        Iterator r101 = ((HashMap) r100.f16891c).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry r102 = (Map.Entry) r101.next();
        ((b08.b) r102.getKey()).unbind((View) r102.getValue());
        goto L4
    L6:
        ((HashMap) r100.f16891c).clear();
        removeRightView();
        unBindAvatar(getClass());
        unBindMiniAvatar(getClass());
        unBindMedal();
        TextView r103 = this.subTitleView;
        FrameLayout r104 = null;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r103 = null;
    L9:
        r103.setVisibility(0);
        getSummaryView().setVisibility(8);
        ExtraInfoView r105 = this.extraInfoView;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("extraInfoView");
        r105 = null;
    L12:
        r105.setVisibility(8);
        LinearLayout r106 = this.dslRenderContainer;
        if (r106 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("dslRenderContainer");
        r106 = null;
    L15:
        r106.removeAllViews();
        LinearLayout r107 = this.dslRenderContainer;
        if (r107 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("dslRenderContainer");
        r107 = null;
    L18:
        r107.setVisibility(8);
        DecoratedAvatar r108 = this.decoratedAvatarView;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r108 = null;
    L21:
        r108.setVisibility(0);
        getAvatarView().setVisibility(0);
        FrameLayout r109 = this.contentLayout;
        if (r109 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        r109 = null;
    L24:
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r110).setMarginStart(0);
        FrameLayout r111 = this.bottomFrameLayout;
        if (r111 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFrameLayout");
        r111 = null;
    L27:
        r111.removeAllViews();
        FrameLayout r112 = this.bottomFrameLayout;
        if (r112 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFrameLayout");
    L31:
        r104.setVisibility(8);
        return;
    L30:
        r104 = r112;
        goto L31
    }

    public final AvatarItemView resetTags() {
        EllipsizedEmojiconTextView r100 = this.titleTailView;
        ImageView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleTailView");
        r100 = null;
    L5:
        r100.setCompoundDrawables(null, null, null, null);
        ImageView r102 = this.rightTagWrapper;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rightTagWrapper");
        r102 = null;
    L8:
        r102.setBackground(null);
        ImageView r103 = this.rightTagWrapper;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rightTagWrapper");
    L12:
        r101.setVisibility(8);
        return this;
    L11:
        r101 = r103;
        goto L12
    }

    public final float subTitleTextSize() {
        TextView r100 = this.subTitleView;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r100 = null;
    L6:
        return r100.getTextSize();
    }

    public final void unBindMedal() {
        DecoratedAvatar r100 = this.decoratedAvatarView;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r100 = null;
    L5:
        ImageView r101 = r100.f283986a;
        if (r101 == null) goto L9;
        r101.setImageDrawable(null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void unbindPersonalStatus() {
        a r100 = this.compositeComponentDelegate;
        Class<?> r101 = getClass();
        ImageView r102 = this.personalStatusView;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("personalStatusView");
        r102 = null;
    L5:
        r100.getClass();
        b08.b r103 = r100.b(r101, r102.getClass(), e.class);
        if (r103 == null) goto L9;
        r103.unbind(r102);
        return;
    }

    private final void layoutSelf() {
        if (getParent() == null) goto L11;
        int r100 = this.mOldWidthMeasureSpec;
        if (r100 == Integer.MIN_VALUE) goto L12;
        int r101 = this.mOldHeightMeasureSpec;
        if (r101 == Integer.MIN_VALUE) goto L13;
        measure(r100, r101);
        layout(getLeft(), getTop(), getRight(), getBottom());
        invalidate();
        return;
    L13:
        return;
    L12:
        return;
    }

    public void registerBinder() {
        PickerBaseModuleDependency.getDependency().registerModelBinder(this.compositeComponentDelegate);
        UDCheckBox r100 = this.checkBox;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r100 = null;
    L5:
        registerModelBinder(b.class, r100.getClass(), CheckBoxBinder.Companion.getInstance());
    }

    public final void userTeamBadge() {
        resetMiniAvatarStyle();
        setMiniAvatarSize(24.0f);
        int r100 = dp(6.0f);
        LarkAvatarView r101 = this.miniAvatarView;
        LarkAvatarView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r101 = null;
    L5:
        r101.setVisibility(0);
        LarkAvatarView r103 = this.miniAvatarView;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r103 = null;
    L8:
        r103.setBackgroundResource(R.drawable.picker_user_team_badge_bg);
        LarkAvatarView r104 = this.miniAvatarView;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r104 = null;
    L11:
        r104.setPadding(r100, r100, r100, r100);
        LarkAvatarView r105 = this.miniAvatarView;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
    L15:
        r102.setImageDrawable(UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_group_filled, d.c(getContext(), R.color.static_white)));
        return;
    L14:
        r102 = r105;
        goto L15
    }

    public final a getCompositeComponentDelegate() {
        return this.compositeComponentDelegate;
    }

    public static final /* synthetic */ View access$createBottomView(AvatarItemView r100) {
        return r100.createBottomView();
    }

    public static final /* synthetic */ LinearLayout access$getAvatarItemSubtitleContainer$p(AvatarItemView r100) {
        return r100.avatarItemSubtitleContainer;
    }

    public static final /* synthetic */ ViewGroup access$getRightItemWrapper$p(AvatarItemView r100) {
        return r100.rightItemWrapper;
    }

    public static final /* synthetic */ TextView access$getSubTitleView$p(AvatarItemView r100) {
        return r100.subTitleView;
    }

    private final void avatarMarginStart(int r100) {
        DecoratedAvatar r101 = this.decoratedAvatarView;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r101 = null;
    L5:
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof RelativeLayout.LayoutParams) == false) goto L9;
        ((RelativeLayout.LayoutParams) r102).setMarginStart(dp(r100));
        return;
    }

    private final void setMiniAvatarSize(float r100) {
        LarkAvatarView r101 = this.miniAvatarView;
        LarkAvatarView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r101 = null;
    L5:
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        if (r103 == null) goto L17;
        int r104 = dp(r100);
        if (r103.width == r104) goto L10;
    L11:
        r103.width = r104;
        r103.height = r104;
        LarkAvatarView r105 = this.miniAvatarView;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
    L15:
        r102.setLayoutParams(r103);
        return;
    L14:
        r102 = r105;
        goto L15
    L10:
        if (r103.height != r104) goto L11;
        return;
    }

    public final void addBottomView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "bottomView");
        FrameLayout r101 = this.bottomFrameLayout;
        FrameLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFrameLayout");
        r101 = null;
    L5:
        r101.addView(r100);
        FrameLayout r103 = this.bottomFrameLayout;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFrameLayout");
    L9:
        r102.setVisibility(0);
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void addViewToRender(View r100) {
        Intrinsics.checkNotNullParameter(r100, "renderView");
        LinearLayout r101 = this.dslRenderContainer;
        TextView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dslRenderContainer");
        r101 = null;
    L5:
        r101.addView(r100);
        LinearLayout r103 = this.dslRenderContainer;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dslRenderContainer");
        r103 = null;
    L8:
        r103.setVisibility(0);
        TextView r104 = this.subTitleView;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
    L12:
        r102.setVisibility(8);
        getSummaryView().setVisibility(8);
        return;
    L11:
        r102 = r104;
        goto L12
    }

    public final AvatarItemView applyStyle(int r110) {
        TypedArray r100 = getContext().obtainStyledAttributes(r110, new int[]{R.attr.avatar_size, R.attr.check_box_size, R.attr.space_left, R.attr.space_mid, R.attr.space_right, R.attr.subtitle_height, R.attr.subtitle_text_size, R.attr.summary_height, R.attr.summary_text_size, R.attr.title_height, R.attr.title_text_size});
        int r101 = r100.getDimensionPixelSize(1, dp(20.0f));
        int r102 = r100.getDimensionPixelSize(0, dp(48.0f));
        int r103 = r100.getDimensionPixelSize(9, dp(24.0f));
        int r104 = r100.getDimensionPixelSize(5, dp(22.0f));
        int r105 = r100.getDimensionPixelSize(7, -2);
        float r106 = r100.getDimension(10, dpF(17.0f));
        float r111 = r100.getDimension(6, dpF(14.0f));
        float r112 = r100.getDimension(8, dpF(14.0f));
        int r113 = (int) r100.getDimension(2, dpF(16.0f));
        int r114 = (int) r100.getDimension(3, dpF(16.0f));
        int r115 = (int) r100.getDimension(4, dpF(12.0f));
        r100.recycle();
        UDCheckBox r107 = this.checkBox;
        TextView r116 = null;
        if (r107 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r107 = null;
    L5:
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r109 = (RelativeLayout.LayoutParams) r108;
        r109.height = r101;
        r109.width = r101;
        r109.setMarginStart(r113);
        DecoratedAvatar r117 = this.decoratedAvatarView;
        if (r117 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r117 = null;
    L8:
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r119 = (RelativeLayout.LayoutParams) r118;
        r119.width = r102;
        r119.height = r102;
        r119.setMarginStart(r114);
        r119.setMarginEnd(r115);
        TextView r120 = this.titleView;
        if (r120 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r120 = null;
    L11:
        float r121 = r103;
        r120.getLayoutParams().height = (int) a08.b.a(r121, r120.getContext());
        r120.setTextSize(0, a08.b.a(r106, r120.getContext()));
        EllipsizedEmojiconTextView r122 = this.titleTailView;
        if (r122 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("titleTailView");
        r122 = null;
    L14:
        r122.getLayoutParams().height = (int) a08.b.a(r121, r122.getContext());
        Context r123 = r122.getContext();
        Intrinsics.checkNotNullParameter(r123, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (yz7.a.f569550b == true) goto L17;
    L19:
        boolean r124 = false;
    L20:
        if (r124 == false) goto L61;
        ZoomLevel4 r125 = zz7.b.e();
        ZoomLevel4 r126 = ZoomLevel4.NORMAL;
        if (r125 == r126) goto L61;
        Intrinsics.checkNotNullParameter(r123, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r127 = r123.getResources();
        int r128 = MathKt.roundToInt((r106 / WindowDisplayMetricsOverride.apply(r127, r127.getDisplayMetrics()).density) + 0.5f);
        if (r125 != r126) goto L28;
        float r129 = ZoomLevel6.NORMAL.getMultiplier();
    L60:
        r106 = r106 * r129;
        goto L61
    L28:
        SortedMap<Integer, a08.b.a> r130 = a08.b.f1319a;
        a08.b.a r131 = r130.get(Integer.valueOf(r128));
        if (r131 == null) goto L31;
        int r132 = r131.a(r125);
    L59:
        r129 = r132 / r128;
        goto L60
    L31:
        Iterator<T> r133 = r130.values().iterator();
        Object r134 = null;
    L33:
        if (r133.hasNext() == false) goto L40;
        Object r135 = r133.next();
        if (((a08.b.a) r135).f1321b >= r128) goto L37;
        boolean r136 = true;
    L38:
        if (r136 == false) goto L33;
        r134 = r135;
        goto L33
    L37:
        r136 = false;
        goto L38
    L40:
        a08.b.a r137 = (a08.b.a) r134;
        Iterator<T> r138 = a08.b.f1319a.values().iterator();
    L42:
        if (r138.hasNext() == false) goto L49;
        Object r139 = r138.next();
        if (((a08.b.a) r139).f1321b <= r128) goto L46;
        boolean r140 = true;
    L47:
        if (r140 == false) goto L42;
    L50:
        a08.b.a r141 = (a08.b.a) r139;
        if (r137 == null) goto L54;
        if (r141 == null) goto L54;
        r132 = MathKt.roundToInt((((r137.a(r125) / r137.f1321b) + (r141.a(r125) / r141.f1321b)) / 2.0f) * r128);
    L54:
        if (r137 == null) goto L56;
        r132 = MathKt.roundToInt((r137.a(r125) / r137.f1321b) * r128);
        goto L59
    L56:
        if (r141 == null) goto L58;
        r132 = MathKt.roundToInt((r141.a(r125) / r141.f1321b) * r128);
        goto L59
    L58:
        r132 = r128;
        goto L59
    L46:
        r140 = false;
        goto L47
    L49:
        r139 = null;
    L61:
        r122.setTextSize(0, r106);
        TextView r142 = this.subTitleView;
        if (r142 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
    L65:
        r116.getLayoutParams().height = (int) a08.b.a(r104, r116.getContext());
        r116.setTextSize(0, a08.b.a(r111, r116.getContext()));
        TextView r143 = getSummaryView();
        r143.getLayoutParams().height = (int) a08.b.a(r105, r143.getContext());
        r143.setTextSize(0, a08.b.a(r112, r143.getContext()));
        return this;
    L64:
        r116 = r142;
        goto L65
    L17:
        if (yz7.a.f569549a == false) goto L19;
        r124 = true;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void assignTime(w3c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "time");
        a r101 = this.compositeComponentDelegate;
        Class<?> r102 = getClass();
        TextView r103 = this.assignTimeView;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("assignTimeView");
        r103 = null;
    L5:
        r101.a(r102, r103, r100);
    }

    public final void avatar(AvatarModel r100) {
        Intrinsics.checkNotNullParameter(r100, "avatarModel");
        getAvatarView().j(r100);
    }

    public final void avatarShape(boolean r100) {
        getAvatarView().setOval(r100);
    }

    public final void avatarSizeAdjust(float r100) {
        DecoratedAvatar r101 = this.decoratedAvatarView;
        DecoratedAvatar r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r101 = null;
    L5:
        r101.getLayoutParams().width = dp(r100);
        DecoratedAvatar r103 = this.decoratedAvatarView;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
    L9:
        r102.getLayoutParams().height = dp(r100);
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void avatarStartMargin(int r100) {
        DecoratedAvatar r101 = this.decoratedAvatarView;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r101 = null;
    L5:
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof RelativeLayout.LayoutParams) == false) goto L9;
        ((RelativeLayout.LayoutParams) r102).setMarginStart(dp(r100));
        return;
    }

    public final void avatarTopMargin(int r100) {
        DecoratedAvatar r101 = this.decoratedAvatarView;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r101 = null;
    L5:
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof RelativeLayout.LayoutParams) == false) goto L9;
        int r103 = dp(r100);
        ((RelativeLayout.LayoutParams) r102).topMargin = r103;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void badge(vz7.b r100) {
        Intrinsics.checkNotNullParameter(r100, "badgeModel");
        LarkAvatarView r101 = getAvatarView();
        r101.f284068a.a(r101.getClass(), r101, r100);
    }

    public final void bindAvatarWithResourceID(int r100) {
        UIUtils.setViewVisibility(getAvatarView(), 0);
        DecoratedAvatar r101 = this.decoratedAvatarView;
        FrameLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r101 = null;
    L5:
        UIUtils.setViewVisibility(r101, 0);
        FrameLayout r103 = this.contentLayout;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
    L9:
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r104).setMarginStart(0);
        getAvatarView().setBackgroundResource(r100);
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void checkBoxStartMargin(int r100) {
        UDCheckBox r101 = this.checkBox;
        RelativeLayout.LayoutParams r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r101 = null;
    L6:
        if (r101.getLayoutParams() == null) goto L16;
        UDCheckBox r103 = this.checkBox;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r103 = null;
    L10:
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if ((r104 instanceof RelativeLayout.LayoutParams) == false) goto L13;
        r102 = (RelativeLayout.LayoutParams) r104;
    L13:
        if (r102 == null) goto L17;
        r102.setMarginStart(dp(r100));
        return;
    L17:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void checkState(b r100) {
        Intrinsics.checkNotNullParameter(r100, "checkBoxModel");
        if (r100.f558225c == false) goto L5;
        avatarMarginStart(12);
    L6:
        this.checkBoxModel = r100;
        a r101 = this.compositeComponentDelegate;
        Class<?> r102 = getClass();
        UDCheckBox r103 = this.checkBox;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r103 = null;
    L9:
        r101.a(r102, r103, r100);
        return;
    L5:
        avatarMarginStart(16);
        goto L6
    }

    public final int dp(float r100) {
        return (int) dpF(r100);
    }

    public final float dpF(float r100) {
        return j08.b.a(getContext(), r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void localTime(w3c.d r100) {
        Intrinsics.checkNotNullParameter(r100, "localTime");
        a r101 = this.compositeComponentDelegate;
        Class<?> r102 = getClass();
        TextView r103 = this.localTimeView;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("localTimeView");
        r103 = null;
    L5:
        r101.a(r102, r103, r100);
    }

    public final void medal(AvatarMedal r100) {
        Intrinsics.checkNotNullParameter(r100, "medalModel");
        String r101 = r100.getKey();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        if (r100.getShowSwitch() == false) goto L18;
        DecoratedAvatar r103 = this.decoratedAvatarView;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r103 = null;
    L15:
        r103.b(r100.getKey());
        return;
    L18:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void miniAvatar(AvatarModel r100) {
        Intrinsics.checkNotNullParameter(r100, "avatarModel");
        resetMiniAvatarStyle();
        LarkAvatarView r101 = this.miniAvatarView;
        LarkAvatarView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r101 = null;
    L5:
        r101.setVisibility(0);
        LarkAvatarView r103 = this.miniAvatarView;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
    L9:
        r102.j(r100);
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void miniIcon(wz7.d r100) {
        getAvatarView().l(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void personalStatus(e r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        a r101 = this.compositeComponentDelegate;
        Class<?> r102 = getClass();
        ImageView r103 = this.personalStatusView;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("personalStatusView");
        r103 = null;
    L5:
        r101.a(r102, r103, r100);
    }

    public final void setAvatarView(LarkAvatarView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.avatarView = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        super.setOnClickListener(r100);
        UDCheckBox r101 = this.checkBox;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r101 = null;
    L5:
        r101.setClickable(false);
    }

    public final void setSubTitleLines(int r100) {
        TextView r101 = this.subTitleView;
        RelativeLayout.LayoutParams r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r101 = null;
    L6:
        if ((r101 instanceof EllipsizedEmojiconTextView) == false) goto L41;
        TextView r103 = this.subTitleView;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r103 = null;
    L11:
        if (r103.getMaxLines() == r100) goto L42;
        Log.i(TAG, "set department max line");
        TextView r104 = this.subTitleView;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r104 = null;
    L15:
        r104.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TextView r105 = this.subTitleView;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r105 = null;
    L18:
        ((EllipsizedEmojiconTextView) r105).setShouldEllipsized(false);
        TextView r106 = this.subTitleView;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r106 = null;
    L21:
        r106.setSingleLine(false);
        TextView r107 = this.subTitleView;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r107 = null;
    L24:
        r107.setMaxLines(r100);
        TextView r108 = this.subTitleView;
        if (r108 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r108 = null;
    L27:
        r108.setEllipsize(TextUtils.TruncateAt.END);
        UDCheckBox r109 = this.checkBox;
        if (r109 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r109 = null;
    L31:
        if (r109.getLayoutParams() == null) goto L43;
        UDCheckBox r110 = this.checkBox;
        if (r110 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r110 = null;
    L35:
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if ((r111 instanceof RelativeLayout.LayoutParams) == false) goto L38;
        r102 = (RelativeLayout.LayoutParams) r111;
    L38:
        if (r102 == null) goto L44;
        r102.removeRule(15);
        r102.addRule(6);
        setGravity(0);
        r102.topMargin = adjustCheckboxTopMargin();
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    }

    public final void setSubTitleMaxLines(int r100) {
        TextView r101 = this.subTitleView;
        TextView r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r101 = null;
    L6:
        if ((r101 instanceof EllipsizedEmojiconTextView) == false) goto L11;
        TextView r103 = this.subTitleView;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r103 = null;
    L10:
        ((EllipsizedEmojiconTextView) r103).setShouldEllipsized(false);
    L11:
        TextView r104 = this.subTitleView;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r104 = null;
    L14:
        TextView r105 = this.subTitleView;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
    L18:
        r104.setText(r102.getText());
        r104.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r104.setSingleLine(false);
        r104.setMaxLines(r100);
        r104.setEllipsize(TextUtils.TruncateAt.END);
        r104.post(new AvatarItemView$setSubTitleMaxLines$1$1(this));
        return;
    L17:
        r102 = r105;
        goto L18
    }

    public final void setSubtitleTag(Drawable r100) {
        if (r100 == null) goto L12;
        TextView r101 = this.subTitleView;
        TextView r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r101 = null;
    L6:
        Drawable[] r103 = r101.getCompoundDrawables();
        TextView r104 = this.subTitleView;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
    L10:
        r102.setCompoundDrawables(r103[0], r103[1], r100, r103[3]);
        return;
    L9:
        r102 = r104;
        goto L10
    }

    public final void setSummaryView(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.summaryView = r100;
    }

    public final void setTag(LarkNameTag.c r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        setTag(r100, 2);
    }

    public final void showDivider(boolean r100) {
        View r101 = null;
        if (r100 == false) goto L9;
        View r102 = this.divider;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException(ItemStyle.ITEM_STYLE_DIVIDER);
    L8:
        r101.setVisibility(0);
        return;
    L7:
        r101 = r102;
        goto L8
    L9:
        View r103 = this.divider;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException(ItemStyle.ITEM_STYLE_DIVIDER);
    L13:
        r101.setVisibility(8);
        return;
    L12:
        r101 = r103;
        goto L13
    }

    public final void subTitle(f r100) {
        Intrinsics.checkNotNullParameter(r100, "subtitleModel");
        Float r101 = r100.f558233f;
        TextView r102 = null;
        if (r101 == null) goto L12;
        float r103 = r101.floatValue();
        TextView r104 = this.subTitleView;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r104 = null;
    L7:
        r104.setTextSize(0, a08.b.a(r103, getContext()));
        TextView r105 = this.subTitleView;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r105 = null;
    L10:
        r105.getLayoutParams().height = -2;
    L12:
        if (r100.f558231d == null) goto L20;
        TextView r106 = this.subTitleView;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r106 = null;
    L16:
        r106.setVisibility(0);
        TextView r107 = this.subTitleView;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r107 = null;
    L19:
        r107.setText("");
        setSubtitleTag(r100.f558231d);
    L27:
        TextView r108 = this.subTitleView;
        if (r108 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
    L32:
        if (r102.getVisibility() != 0) goto L34;
        UiState r109 = UiState.SHOW;
    L35:
        this.subTitleState = r109;
        adjustAvatarTopMargin();
        return;
    L34:
        r109 = UiState.HIDE;
        goto L35
    L30:
        r102 = r108;
        goto L32
    L20:
        TextView r110 = this.subTitleView;
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r110 = null;
    L23:
        r110.setCompoundDrawables(null, null, null, null);
        TextView r111 = this.subTitleView;
        if (r111 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r111 = null;
    L26:
        bindTextViewWithModel(r111, r100);
        goto L27
    }

    public final void summary(f r100) {
        Intrinsics.checkNotNullParameter(r100, "summaryModel");
        bindTextViewWithModel(getSummaryView(), r100);
        if (getSummaryView().getVisibility() != 0) goto L5;
        UiState r101 = UiState.SHOW;
    L6:
        this.summaryState = r101;
        adjustAvatarTopMargin();
        return;
    L5:
        r101 = UiState.HIDE;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void title(g r100) {
        Intrinsics.checkNotNullParameter(r100, "titleModel");
        a r101 = this.compositeComponentDelegate;
        Class<?> r102 = getClass();
        TextView r103 = this.titleView;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r103 = null;
    L5:
        r101.a(r102, r103, r100);
    }

    public final void titleBottomMargin(int r100) {
        TextView r101 = this.titleView;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r101 = null;
    L5:
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof RelativeLayout.LayoutParams) == false) goto L9;
        int r103 = dp(r100);
        ((RelativeLayout.LayoutParams) r102).bottomMargin = r103;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void titleTail(h r100) {
        Intrinsics.checkNotNullParameter(r100, "tailModel");
        a r101 = this.compositeComponentDelegate;
        Class<?> r102 = getClass();
        EllipsizedEmojiconTextView r103 = this.titleTailView;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleTailView");
        r103 = null;
    L5:
        r101.a(r102, r103, r100);
    }

    public final void unBindAvatar(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        getAvatarView().m(r100);
    }

    public final void unBindMiniAvatar(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        LarkAvatarView r101 = this.miniAvatarView;
        LarkAvatarView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r101 = null;
    L5:
        r101.setVisibility(8);
        LarkAvatarView r103 = this.miniAvatarView;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
    L9:
        r102.m(r100);
        resetMiniAvatarStyle();
        return;
    L8:
        r102 = r103;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateCheckState(boolean r100) {
        b r101 = this.checkBoxModel;
        b r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBoxModel");
        r101 = null;
    L5:
        r101.f558223a = r100;
        a r103 = this.compositeComponentDelegate;
        Class<?> r104 = getClass();
        UDCheckBox r105 = this.checkBox;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r105 = null;
    L8:
        b r106 = this.checkBoxModel;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("checkBoxModel");
    L12:
        r103.a(r104, r105, r102);
        return;
    L11:
        r102 = r106;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void userStatus(j r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        a r101 = this.compositeComponentDelegate;
        Class<?> r102 = getClass();
        UserStatusLinearLayout r103 = this.userStatus;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("userStatus");
        r103 = null;
    L5:
        r101.a(r102, r103, r100);
    }

    public final int dp(int r100) {
        return d.a(r100);
    }

    private final void bindTextViewWithModel(TextView r100, f r101) {
        if (TextUtils.isEmpty(r101.f558228a) == false) goto L5;
    L18:
        r100.setVisibility(8);
        return;
    L5:
        if (r101.f558229b == false) goto L18;
        r100.setVisibility(0);
        r100.setEllipsize(r101.f558234g);
        if ((r100 instanceof EllipsizedEmojiconTextView) == false) goto L11;
        TextUtils.TruncateAt r102 = r101.f558234g;
        ((EllipsizedEmojiconTextView) r100).f445616j = r102;
    L11:
        if (r101.f558232e == false) goto L13;
        int r103 = getContext().getResources().getColor(R.color.primary_fill_default);
    L14:
        r100.setTextColor(r103);
        if (CollectionUtils.isEmpty(r101.f558230c) == false) goto L17;
        r100.setText(r101.f558228a);
        return;
    L17:
        SpannableStringBuilder r104 = new SpannableStringBuilder(r101.f558228a);
        PickerBaseModuleDependency.getDependency().addSearchHighLightedTag(r104, r100, r101.f558230c, r100.getContext().getResources().getColor(R.color.primary_fill_default));
        return;
    L13:
        r103 = getContext().getResources().getColor(R.color.text_placeholder);
        goto L14
    }

    private final int numOfCharsByHanziOne(TextView r100, int r101) {
        return (int) ((((double) (((((r101 - dp(16.0f)) - dp(48.0f)) - dp(12.0f)) - dp(16.0f)) / r100.getPaint().measureText(r100.getContext().getResources().getText(R.string.measure_unit).toString()))) * 0.9d) * ((double) 2));
    }

    public final void bindAvatarWithUrl(String r110, String r111) {
        boolean r100 = true;
        if (r110 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        FrameLayout r102 = null;
        if (r101 == false) goto L27;
        UIUtils.setViewVisibility(getAvatarView(), 0);
        DecoratedAvatar r103 = this.decoratedAvatarView;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r103 = null;
    L13:
        UIUtils.setViewVisibility(r103, 0);
        FrameLayout r104 = this.contentLayout;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
    L17:
        ViewGroup.LayoutParams r105 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r105).setMarginStart(0);
        Drawable r106 = UIHelper.getDrawable(R.drawable.lark_avatar_placeholder);
        if (r111 == null) goto L24;
        if (StringsKt.isBlank(r111) == true) goto L24;
        r100 = false;
    L24:
        if (r100 == true) goto L26;
        r106 = new BitmapDrawable(getResources(), FakePickerAvatarCreator.createNameAvatarBitmap(dp(48.0f), dp(48.0f), r111, UIHelper.getColor(R.color.ud_N400)));
    L26:
        Drawable r107 = r106;
        PickerBaseModuleDependency.getDependency().loadImage(getContext(), r110, getAvatarView(), r107, r107, dp(48.0f), dp(48.0f));
        return;
    L16:
        r102 = r104;
        goto L17
    L27:
        UIUtils.setViewVisibility(getAvatarView(), 8);
        DecoratedAvatar r112 = this.decoratedAvatarView;
        if (r112 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r112 = null;
    L30:
        UIUtils.setViewVisibility(r112, 8);
        FrameLayout r113 = this.contentLayout;
        if (r113 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
    L34:
        ViewGroup.LayoutParams r114 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r114).setMarginStart(dp(16.0f));
        return;
    L33:
        r102 = r113;
        goto L34
    L5:
        if ((!StringsKt.isBlank(r110)) != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.mOldHeightMeasureSpec = r101;
        this.mOldWidthMeasureSpec = r100;
    }

    public final void setExtraInfoSummary(ExtraInfoSummary r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "extraInfoSummary");
        ExtraInfoView r102 = null;
        if (r100.getExtraInfoList().isEmpty() == false) goto L10;
        ExtraInfoView r103 = this.extraInfoView;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("extraInfoView");
    L8:
        r102.setVisibility(8);
        return;
    L7:
        r102 = r103;
        goto L8
    L10:
        ExtraInfoView r104 = this.extraInfoView;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("extraInfoView");
        r104 = null;
    L13:
        r104.setVisibility(0);
        ExtraInfoView r105 = this.extraInfoView;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("extraInfoView");
    L17:
        r102.setExtraInfoSummary(r100, r101);
        return;
    L16:
        r102 = r105;
        goto L17
    }

    public final void setTag(LarkNameTag.c r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        ImageView r102 = null;
        EllipsizedEmojiconTextView r103 = null;
        if (r101 != 2) goto L9;
        LarkNameTag r104 = r100.f();
        EllipsizedEmojiconTextView r105 = this.titleTailView;
        if (r105 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("titleTailView");
    L8:
        r104.c(r103);
        return;
    L7:
        r103 = r105;
        goto L8
    L9:
        ImageView r106 = this.rightTagWrapper;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("rightTagWrapper");
        r106 = null;
    L12:
        r106.setVisibility(0);
        LarkNameTag r107 = r100.f();
        ImageView r108 = this.rightTagWrapper;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("rightTagWrapper");
    L16:
        r107.getClass();
        Intrinsics.checkNotNullParameter(r102, "view");
        if (LarkNameTag.a(r102.getBackground(), r107.f284334a) == true) goto L21;
        r102.setBackground(r107.b());
        return;
    L21:
        return;
    L15:
        r102 = r108;
        goto L16
    }

    public final void attachRightView(final View r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        FrameLayout r103 = this.rightViewHolder;
        final View r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rightViewHolder");
        r103 = null;
    L5:
        r103.addView(r100);
        ViewGroup r105 = this.rightItemWrapper;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
        r105 = null;
    L8:
        r105.setVisibility(0);
        if (r101 == false) goto L22;
        ViewGroup r106 = this.rightItemWrapper;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
        r106 = null;
    L13:
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof RelativeLayout.LayoutParams) == false) goto L16;
        RelativeLayout.LayoutParams r108 = (RelativeLayout.LayoutParams) r107;
    L17:
        if (r108 == null) goto L22;
        r108.topMargin = 0;
        r108.removeRule(6);
        ViewGroup r109 = this.rightItemWrapper;
        if (r109 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
        r109 = null;
    L21:
        r109.setLayoutParams(r108);
        goto L22
    L16:
        r108 = null;
    L22:
        if (r102 == false) goto L35;
        ViewGroup r110 = this.rightItemWrapper;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
        r110 = null;
    L26:
        r110.setOnClickListener(new AnonymousClass3(r100));
        ViewGroup r111 = this.rightItemWrapper;
        if (r111 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
        r111 = null;
    L29:
        Object r112 = r111.getParent();
        if ((r112 instanceof View) == false) goto L32;
        r104 = (View) r112;
    L32:
        if (r104 == null) goto L36;
        r104.post(new AvatarItemView$attachRightView$4$1(this, r104, r100));
        return;
    L36:
        return;
    }

    public AvatarItemView(Context r100, AttributeSet r101, int r102, a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "compositeComponentDelegate");
        super(r100, r101, r102);
        this.compositeComponentDelegate = r103;
        this.contentView$delegate = LazyKt.lazy(new AvatarItemView$contentView$2(this));
        this.bottomView$delegate = LazyKt.lazy(new AvatarItemView$bottomView$2(this));
        this.mOldWidthMeasureSpec = Integer.MIN_VALUE;
        this.mOldHeightMeasureSpec = Integer.MIN_VALUE;
        this.fgUtils = new SearchCommonFgUtils();
        setBackground(r100.getDrawable(R.drawable.avatar_item_selector_bg));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        addView(getContentView());
        addView(getBottomView());
        if (r101 == null) goto L5;
        applyStyle(r101.getStyleAttribute());
    L5:
        UiState r104 = UiState.NONE;
        this.subTitleState = r104;
        this.summaryState = r104;
    }

    public final void bindAvatarWithUrl(String r100, Drawable r110, Float r111, Float r112) {
        if (r110 != null) goto L4;
        r110 = UIHelper.getDrawable(R.drawable.lark_avatar_placeholder);
    L4:
        Drawable r101 = r110;
        if (r111 == null) goto L11;
        if (r112 == null) goto L11;
        DecoratedAvatar r113 = this.decoratedAvatarView;
        if (r113 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r113 = null;
    L10:
        ViewGroup.LayoutParams r102 = r113.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r103 = (RelativeLayout.LayoutParams) r102;
        r103.width = UIHelper.dp2px(r111.floatValue());
        r103.height = UIHelper.dp2px(r112.floatValue());
        r103.addRule(15);
        r113.setLayoutParams(r103);
    L11:
        float r114 = 48.0f;
        if (r111 == null) goto L14;
        float r115 = r111.floatValue();
    L15:
        if (r112 == null) goto L17;
        r114 = r112.floatValue();
    L17:
        PickerBaseModuleDependency.getDependency().loadImage(getContext(), r100, getAvatarView(), r101, r101, dp(r115), dp(r114));
        return;
    L14:
        r115 = 48.0f;
        goto L15
    }

    public static /* synthetic */ void bindAvatarWithUrl$default(AvatarItemView r100, String r101, String r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.bindAvatarWithUrl(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindAvatarWithUrl");
    }

    public /* synthetic */ AvatarItemView(Context r100, AttributeSet r101, int r102, a r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = new a();
    L11:
        this(r100, r101, r102, r103);
    }

    public static /* synthetic */ void attachRightView$default(AvatarItemView r100, View r101, boolean r102, boolean r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = false;
    L7:
        if ((r104 & 4) == 0) goto L9;
        r103 = true;
    L9:
        r100.attachRightView(r101, r102, r103);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachRightView");
    }

    public static /* synthetic */ void bindAvatarWithUrl$default(AvatarItemView r100, String r101, Drawable r102, Float r103, Float r104, int r105, Object r106) {
        if (r106 != null) goto L12;
        if ((r105 & 4) == 0) goto L7;
        r103 = null;
    L7:
        if ((r105 & 8) == 0) goto L9;
        r104 = null;
    L9:
        r100.bindAvatarWithUrl(r101, r102, r103, r104);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindAvatarWithUrl");
    }
}
