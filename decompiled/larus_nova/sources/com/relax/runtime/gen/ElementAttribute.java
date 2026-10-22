package com.relax.runtime.gen;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.hybrid.xelement.ecomimage.ECLynxImage;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.bytedance.sdk.open.aweme.CommonConstants;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.texturerender.VideoSurface;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import com.ttnetuploader.uploader.api.UploadCode;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum ElementAttribute extends Enum<ElementAttribute> {
    public static final ElementAttribute A11yId = null;
    public static final ElementAttribute AccessibilityActions = null;
    public static final ElementAttribute AccessibilityElement = null;
    public static final ElementAttribute AccessibilityElements = null;
    public static final ElementAttribute AccessibilityElementsA11y = null;
    public static final ElementAttribute AccessibilityElementsHidden = null;
    public static final ElementAttribute AccessibilityEnableTap = null;
    public static final ElementAttribute AccessibilityExclusiveFocus = null;
    public static final ElementAttribute AccessibilityHeading = null;
    public static final ElementAttribute AccessibilityLabel = null;
    public static final ElementAttribute AccessibilityRoleDescription = null;
    public static final ElementAttribute AccessibilityStatus = null;
    public static final ElementAttribute AccessibilityTraits = null;
    public static final ElementAttribute AccessibilityValue = null;
    public static final ElementAttribute AdjustMode = null;
    public static final ElementAttribute AlignContent = null;
    public static final ElementAttribute AlignFocus = null;
    public static final ElementAttribute AlignItems = null;
    public static final ElementAttribute Alignment = null;
    public static final ElementAttribute AllowEscape = null;
    public static final ElementAttribute AllowHorizontalGesture = null;
    public static final ElementAttribute AndroidAccessibilityKeepFocused = null;
    public static final ElementAttribute AndroidConsumeHoverEvent = null;
    public static final ElementAttribute AnimationType = null;
    public static final ElementAttribute AnimationVelocity = null;
    public static final ElementAttribute Annotation = null;
    public static final ElementAttribute AsyncDisplay = null;
    public static final ElementAttribute AutoFix = null;
    public static final ElementAttribute AutoFontSize = null;
    public static final ElementAttribute AutoFontSizePresetSizes = null;
    public static final ElementAttribute AutoLifecycle = null;
    public static final ElementAttribute AutoReverse = null;
    public static final ElementAttribute AutoSaveLastChild = null;
    public static final ElementAttribute AutoSize = null;
    public static final ElementAttribute Autoplay = null;
    public static final ElementAttribute AutoplayInterval = null;
    public static final ElementAttribute BackgroundColor = null;
    public static final ElementAttribute BlockNativeEvent = null;
    public static final ElementAttribute BlockNativeEventAreas = null;
    public static final ElementAttribute Blur = null;
    public static final ElementAttribute BlurRadius = null;
    public static final ElementAttribute BorderColor = null;
    public static final ElementAttribute BorderHeight = null;
    public static final ElementAttribute BorderTop = null;
    public static final ElementAttribute BorderWidth = null;
    public static final ElementAttribute BottomInset = null;
    public static final ElementAttribute Bounce = null;
    public static final ElementAttribute Bounces = null;
    public static final ElementAttribute Bound = null;
    public static final ElementAttribute Cache = null;
    public static final ElementAttribute CapInsets = null;
    public static final ElementAttribute CapInsetsScale = null;
    public static final ElementAttribute CaretColor = null;
    public static final ElementAttribute Center = null;
    public static final ElementAttribute Circular = null;
    public static final ElementAttribute CollisionPercent = null;
    public static final ElementAttribute Color = null;
    public static final ElementAttribute ColumnCount = null;
    public static final ElementAttribute ColumnGap = null;
    public static final ElementAttribute ConfirmType = null;
    public static final ElementAttribute ConsumeSlideEvent = null;
    public static final ElementAttribute Content = null;
    public static final ElementAttribute ContentComplete = null;
    public static final ElementAttribute ContentId = null;
    public static final ElementAttribute ContentRange = null;
    public static final ElementAttribute Control = null;
    public static final ElementAttribute Controls = null;
    public static final ElementAttribute Current = null;
    public static final ElementAttribute CurrentItemId = null;
    public static final ElementAttribute DefaultIndex = null;
    public static final ElementAttribute DefaultValue = null;
    public static final ElementAttribute DeferSrcInvalidation = null;
    public static final ElementAttribute DeviceChangeAware = null;
    public static final ElementAttribute Direction = null;
    public static final ElementAttribute DisableAttachEvent = null;
    public static final ElementAttribute Disabled = null;
    public static final ElementAttribute DisplayMultipleItems = null;
    public static final ElementAttribute DropShadow = null;
    public static final ElementAttribute Duration = null;
    public static final ElementAttribute DynamicResource = null;
    public static final ElementAttribute EditOnFocus = null;
    public static final ElementAttribute EnableCollision = null;
    public static final ElementAttribute EnableDrag = null;
    public static final ElementAttribute EnableExposureUiMargin = null;
    public static final ElementAttribute EnableFadeInAnimation = null;
    public static final ElementAttribute EnableFontScaling = null;
    public static final ElementAttribute EnableLoadmore = null;
    public static final ElementAttribute EnableNestedScroll = null;
    public static final ElementAttribute EnableNewAnimator = null;
    public static final ElementAttribute EnableRefresh = null;
    public static final ElementAttribute EnableResourceHint = null;
    public static final ElementAttribute EnableRotateGestures = null;
    public static final ElementAttribute EnableScroll = null;
    public static final ElementAttribute EnableScrollGestures = null;
    public static final ElementAttribute EnableScrollbar = null;
    public static final ElementAttribute EnableTiltGestures = null;
    public static final ElementAttribute EnableZoomGesture = null;
    public static final ElementAttribute EnableZoomGestures = null;
    public static final ElementAttribute EndFrame = null;
    public static final ElementAttribute EstimatedMainAxisSizePx = null;
    public static final ElementAttribute EventThrough = null;
    public static final ElementAttribute EventsPassThrough = null;
    public static final ElementAttribute ExperimentalMaxFlingDistanceRatio = null;
    public static final ElementAttribute ExperimentalSyncLoad = null;
    public static final ElementAttribute ExposureArea = null;
    public static final ElementAttribute ExposureId = null;
    public static final ElementAttribute ExposureScene = null;
    public static final ElementAttribute ExposureScreenMarginBottom = null;
    public static final ElementAttribute ExposureScreenMarginLeft = null;
    public static final ElementAttribute ExposureScreenMarginRight = null;
    public static final ElementAttribute ExposureScreenMarginTop = null;
    public static final ElementAttribute ExposureUiMarginBottom = null;
    public static final ElementAttribute ExposureUiMarginLeft = null;
    public static final ElementAttribute ExposureUiMarginRight = null;
    public static final ElementAttribute ExposureUiMarginTop = null;
    public static final ElementAttribute Facing = null;
    public static final ElementAttribute Flash = null;
    public static final ElementAttribute FlexDirection = null;
    public static final ElementAttribute FlexWrap = null;
    public static final ElementAttribute Focus = null;
    public static final ElementAttribute FocusIndex = null;
    public static final ElementAttribute FocusSmoothScroll = null;
    public static final ElementAttribute Focusable = null;
    public static final ElementAttribute FontFamily = null;
    public static final ElementAttribute FontSize = null;
    public static final ElementAttribute FontStyle = null;
    public static final ElementAttribute FontWeight = null;
    public static final ElementAttribute ForceCanScroll = null;
    public static final ElementAttribute FpsEventInterval = null;
    public static final ElementAttribute FullScreen = null;
    public static final ElementAttribute FullScreenMode = null;
    public static final ElementAttribute FullSpan = null;
    public static final ElementAttribute Granularity = null;
    public static final ElementAttribute GridAutoColumns = null;
    public static final ElementAttribute GridAutoFlow = null;
    public static final ElementAttribute GridAutoRows = null;
    public static final ElementAttribute GridColumnGap = null;
    public static final ElementAttribute GridRowGap = null;
    public static final ElementAttribute GridTemplateColumns = null;
    public static final ElementAttribute GridTemplateRows = null;
    public static final ElementAttribute HeaderOverSlot = null;
    public static final ElementAttribute HideBorder = null;
    public static final ElementAttribute HideIndicator = null;
    public static final ElementAttribute IdSelector = null;
    public static final ElementAttribute IgnoreAttachStatus = null;
    public static final ElementAttribute IgnoreFocus = null;
    public static final ElementAttribute ImageTransitionStyle = null;
    public static final ElementAttribute Indicator = null;
    public static final ElementAttribute IndicatorActiveColor = null;
    public static final ElementAttribute IndicatorColor = null;
    public static final ElementAttribute IndicatorCursor = null;
    public static final ElementAttribute IndicatorDots = null;
    public static final ElementAttribute IndicatorRadius = null;
    public static final ElementAttribute InitTime = null;
    public static final ElementAttribute InitialAnimationStep = null;
    public static final ElementAttribute InitialScrollIndex = null;
    public static final ElementAttribute InitialScrollOffset = null;
    public static final ElementAttribute InitialSelectIndex = null;
    public static final ElementAttribute InitialZoom = null;
    public static final ElementAttribute InputFilter = null;
    public static final ElementAttribute IntersectionObservers = null;
    public static final ElementAttribute Interval = null;
    public static final ElementAttribute IntrinsicHeight = null;
    public static final ElementAttribute IntrinsicWidth = null;
    public static final ElementAttribute IosGestureOffset = null;
    public static final ElementAttribute ItemKey = null;
    public static final ElementAttribute ItemSizing = null;
    public static final ElementAttribute ItemSnap = null;
    public static final ElementAttribute Json = null;
    public static final ElementAttribute JustifyContent = null;
    public static final ElementAttribute JustifyItems = null;
    public static final ElementAttribute KeepItemView = null;
    public static final ElementAttribute KeepLastFrame = null;
    public static final ElementAttribute KeyboardType = null;
    public static final ElementAttribute LastFrame = null;
    public static final ElementAttribute LayoutId = null;
    public static final ElementAttribute LetterSpacing = null;
    public static final ElementAttribute Line = null;
    public static final ElementAttribute LineHeight = null;
    public static final ElementAttribute LineSpacing = null;
    public static final ElementAttribute LinearCrossGravity = null;
    public static final ElementAttribute LinearGravity = null;
    public static final ElementAttribute LinearOrientation = null;
    public static final ElementAttribute LinearWeightSum = null;
    public static final ElementAttribute ListContainerInfo = null;
    public static final ElementAttribute ListCrossAxisGap = null;
    public static final ElementAttribute ListMainAxisGap = null;
    public static final ElementAttribute ListType = null;
    public static final ElementAttribute Loop = null;
    public static final ElementAttribute LoopCount = null;
    public static final ElementAttribute LowQuality = null;
    public static final ElementAttribute LowerThreshold = null;
    public static final ElementAttribute LowerThresholdItemCount = null;
    public static final ElementAttribute MapStyle = null;
    public static final ElementAttribute MarkdownEffect = null;
    public static final ElementAttribute MarkdownStyle = null;
    public static final ElementAttribute MaxFrameRate = null;
    public static final ElementAttribute MaxLength = null;
    public static final ElementAttribute MaxLines = null;
    public static final ElementAttribute MaxXScale = null;
    public static final ElementAttribute MaxYScale = null;
    public static final ElementAttribute MinXScale = null;
    public static final ElementAttribute MinYScale = null;
    public static final ElementAttribute Mode = null;
    public static final ElementAttribute Moveable = null;
    public static final ElementAttribute Muted = null;
    public static final ElementAttribute Name = null;
    public static final ElementAttribute NativeInteractionEnabled = null;
    public static final ElementAttribute NeedLayoutCompleteInfo = null;
    public static final ElementAttribute NeedUserLocationHeading = null;
    public static final ElementAttribute NeedVisibleItemInfo = null;
    public static final ElementAttribute NeedsVisibleCells = null;
    public static final ElementAttribute NextFocusDown = null;
    public static final ElementAttribute NextFocusFallback = null;
    public static final ElementAttribute NextFocusLeft = null;
    public static final ElementAttribute NextFocusRight = null;
    public static final ElementAttribute NextFocusUp = null;
    public static final ElementAttribute NextMargin = null;
    public static final ElementAttribute NormTranslationFactor = null;
    public static final ElementAttribute ObjectFit = null;
    public static final ElementAttribute Orientation = null;
    public static final ElementAttribute OverlayId = null;
    public static final ElementAttribute PageChangeAnimation = null;
    public static final ElementAttribute PageMargin = null;
    public static final ElementAttribute Placeholder = null;
    public static final ElementAttribute PlaceholderColor = null;
    public static final ElementAttribute PlaceholderFontSize = null;
    public static final ElementAttribute PlaceholderFontWeight = null;
    public static final ElementAttribute PlayStatus = null;
    public static final ElementAttribute PlayerType = null;
    public static final ElementAttribute Poster = null;
    public static final ElementAttribute PreferredFocusChild = null;
    public static final ElementAttribute Preload = null;
    public static final ElementAttribute PreloadBufferCount = null;
    public static final ElementAttribute PreloadKey = null;
    public static final ElementAttribute PreventLoadingOnListScroll = null;
    public static final ElementAttribute PreviousMargin = null;
    public static final ElementAttribute Progress = null;
    public static final ElementAttribute Rate = null;
    public static final ElementAttribute Readonly = null;
    public static final ElementAttribute RefreshMode = null;
    public static final ElementAttribute RelaxTestTag = null;
    public static final ElementAttribute RenderMode = null;
    public static final ElementAttribute Repeat = null;
    public static final ElementAttribute Resolution = null;
    public static final ElementAttribute ReuseEngine = null;
    public static final ElementAttribute ReuseIdentifier = null;
    public static final ElementAttribute Reverse = null;
    public static final ElementAttribute RichType = null;
    public static final ElementAttribute RowGap = null;
    public static final ElementAttribute ScrollDirection = null;
    public static final ElementAttribute ScrollEnable = null;
    public static final ElementAttribute ScrollEventThrottle = null;
    public static final ElementAttribute ScrollFling = null;
    public static final ElementAttribute ScrollLeft = null;
    public static final ElementAttribute ScrollOffset = null;
    public static final ElementAttribute ScrollOrientation = null;
    public static final ElementAttribute ScrollToId = null;
    public static final ElementAttribute ScrollToIndex = null;
    public static final ElementAttribute ScrollTop = null;
    public static final ElementAttribute ScrollWithoutFocus = null;
    public static final ElementAttribute ScrollX = null;
    public static final ElementAttribute ScrollXReverse = null;
    public static final ElementAttribute ScrollY = null;
    public static final ElementAttribute ScrollYReverse = null;
    public static final ElementAttribute ScrollbarAutoHide = null;
    public static final ElementAttribute ScrollbarAutoHideDelay = null;
    public static final ElementAttribute ScrollbarEnable = null;
    public static final ElementAttribute ScrollbarThumbActiveColor = null;
    public static final ElementAttribute ScrollbarThumbColor = null;
    public static final ElementAttribute ScrollbarThumbMinLength = null;
    public static final ElementAttribute ScrollbarThumbRadius = null;
    public static final ElementAttribute ScrollbarThumbWidth = null;
    public static final ElementAttribute ScrollbarTrackColor = null;
    public static final ElementAttribute ScrollbarWidth = null;
    public static final ElementAttribute Select = null;
    public static final ElementAttribute SelectIndex = null;
    public static final ElementAttribute SelectedTextColor = null;
    public static final ElementAttribute SelectedTextSize = null;
    public static final ElementAttribute ShowSoftInputOnFocus = null;
    public static final ElementAttribute SingleLineVerticalAlign = null;
    public static final ElementAttribute SkipRedirection = null;
    public static final ElementAttribute SmartScroll = null;
    public static final ElementAttribute SmoothScroll = null;
    public static final ElementAttribute SpanCount = null;
    public static final ElementAttribute Speed = null;
    public static final ElementAttribute Src = null;
    public static final ElementAttribute SrcFormat = null;
    public static final ElementAttribute SrcPolyfill = null;
    public static final ElementAttribute StackAnimation = null;
    public static final ElementAttribute StartFrame = null;
    public static final ElementAttribute Sticky = null;
    public static final ElementAttribute StickyBottom = null;
    public static final ElementAttribute StickyOffset = null;
    public static final ElementAttribute StickyTop = null;
    public static final ElementAttribute TabHeight = null;
    public static final ElementAttribute TabIndicatorColor = null;
    public static final ElementAttribute TabIndicatorHeight = null;
    public static final ElementAttribute TabIndicatorRadius = null;
    public static final ElementAttribute TabIndicatorTop = null;
    public static final ElementAttribute TabIndicatorWidth = null;
    public static final ElementAttribute TabInterSpace = null;
    public static final ElementAttribute TabLayoutGravity = null;
    public static final ElementAttribute TabPaddingLeft = null;
    public static final ElementAttribute TabPaddingRight = null;
    public static final ElementAttribute TabbarBackground = null;
    public static final ElementAttribute Tag = null;
    public static final ElementAttribute Text = null;
    public static final ElementAttribute TextAlign = null;
    public static final ElementAttribute TextBoldMode = null;
    public static final ElementAttribute TextDecoration = null;
    public static final ElementAttribute TextGradient = null;
    public static final ElementAttribute TextIndent = null;
    public static final ElementAttribute TextMaxlength = null;
    public static final ElementAttribute TextMaxline = null;
    public static final ElementAttribute TextOverflow = null;
    public static final ElementAttribute TextSelect = null;
    public static final ElementAttribute TextShadow = null;
    public static final ElementAttribute TextStrokeColor = null;
    public static final ElementAttribute TextStrokeWidth = null;
    public static final ElementAttribute Touchable = null;
    public static final ElementAttribute TypewriterDynamicHeight = null;
    public static final ElementAttribute UnselectedTextColor = null;
    public static final ElementAttribute UnselectedTextSize = null;
    public static final ElementAttribute UpdateAnimation = null;
    public static final ElementAttribute UpdateAnimationFadeInDuration = null;
    public static final ElementAttribute UpdateListInfo = null;
    public static final ElementAttribute UpperThreshold = null;
    public static final ElementAttribute UpperThresholdItemCount = null;
    public static final ElementAttribute UseSoftKeyboard = null;
    public static final ElementAttribute UserInteractionEnabled = null;
    public static final ElementAttribute UserLocationAnnotation = null;
    public static final ElementAttribute Value = null;
    public static final ElementAttribute Vertical = null;
    public static final ElementAttribute VerticalAlign = null;
    public static final ElementAttribute VerticalOrientation = null;
    public static final ElementAttribute VideoHeight = null;
    public static final ElementAttribute VideoWidth = null;
    public static final ElementAttribute Visible = null;
    public static final ElementAttribute Volume = null;
    public static final ElementAttribute WhiteSpace = null;
    public static final ElementAttribute WordBreak = null;
    public static final ElementAttribute Zoom = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ElementAttribute[] f405691a = null;
    private final int mValue;

    public static String ElementAttributeToString(int r100) {
        switch(r100) {
            case 20000: goto L686;
            case 20001: goto L684;
            case 20002: goto L682;
            case 20003: goto L680;
            case 20004: goto L678;
            case 20005: goto L676;
            case 20006: goto L674;
            case 20007: goto L672;
            case 20008: goto L670;
            case 20009: goto L668;
            case 20010: goto L666;
            case 20011: goto L664;
            case 20012: goto L662;
            case 20013: goto L660;
            case 20014: goto L658;
            case 20015: goto L656;
            case 20016: goto L654;
            case 20017: goto L652;
            case 20018: goto L650;
            case 20019: goto L648;
            case 20020: goto L646;
            case 20021: goto L644;
            case 20022: goto L642;
            case 20023: goto L640;
            case 20024: goto L638;
            case 20025: goto L636;
            case 20026: goto L4;
            case 20027: goto L634;
            case 20028: goto L632;
            case 20029: goto L630;
            case 20030: goto L628;
            case 20031: goto L626;
            case 20032: goto L624;
            case 20033: goto L622;
            case 20034: goto L620;
            case 20035: goto L618;
            case 20036: goto L616;
            case 20037: goto L614;
            case 20038: goto L613;
            case 20039: goto L611;
            case 20040: goto L609;
            case 20041: goto L607;
            case 20042: goto L605;
            case 20043: goto L603;
            case 20044: goto L601;
            case 20045: goto L599;
            case 20046: goto L598;
            case 20047: goto L596;
            case 20048: goto L594;
            case 20049: goto L592;
            case 20050: goto L590;
            case 20051: goto L588;
            case 20052: goto L586;
            case 20053: goto L584;
            case 20054: goto L582;
            case 20055: goto L580;
            case 20056: goto L578;
            case 20057: goto L576;
            case 20058: goto L574;
            case 20059: goto L572;
            case 20060: goto L570;
            case 20061: goto L568;
            case 20062: goto L566;
            case 20063: goto L564;
            case 20064: goto L562;
            case 20065: goto L560;
            case 20066: goto L558;
            case 20067: goto L556;
            case 20068: goto L554;
            case 20069: goto L552;
            case 20070: goto L550;
            case 20071: goto L548;
            case 20072: goto L546;
            case 20073: goto L544;
            case 20074: goto L542;
            case 20075: goto L540;
            case 20076: goto L538;
            case 20077: goto L536;
            case 20078: goto L534;
            case 20079: goto L532;
            case 20080: goto L530;
            case 20081: goto L528;
            case 20082: goto L526;
            case 20083: goto L524;
            case 20084: goto L522;
            case 20085: goto L520;
            case 20086: goto L518;
            case 20087: goto L516;
            case 20088: goto L514;
            case 20089: goto L512;
            case 20090: goto L510;
            case 20091: goto L508;
            case 20092: goto L506;
            case 20093: goto L504;
            case 20094: goto L502;
            case 20095: goto L500;
            case 20096: goto L498;
            case 20097: goto L496;
            case 20098: goto L494;
            case 20099: goto L492;
            case 20100: goto L490;
            case 20101: goto L488;
            case 20102: goto L486;
            case 20103: goto L484;
            case 20104: goto L482;
            case 20105: goto L480;
            case 20106: goto L478;
            case 20107: goto L476;
            case 20108: goto L474;
            case 20109: goto L472;
            case 20110: goto L470;
            case 20111: goto L468;
            case 20112: goto L466;
            case 20113: goto L464;
            case 20114: goto L462;
            case 20115: goto L460;
            case 20116: goto L458;
            case 20117: goto L456;
            case 20118: goto L454;
            case 20119: goto L452;
            case 20120: goto L450;
            case 20121: goto L448;
            case 20122: goto L446;
            case 20123: goto L444;
            case 20124: goto L442;
            case 20125: goto L4;
            case 20126: goto L440;
            case 20127: goto L4;
            case 20128: goto L438;
            case 20129: goto L436;
            case 20130: goto L434;
            case 20131: goto L432;
            case 20132: goto L430;
            case 20133: goto L428;
            case 20134: goto L426;
            case 20135: goto L4;
            case 20136: goto L4;
            case 20137: goto L424;
            case 20138: goto L422;
            case 20139: goto L420;
            case 20140: goto L418;
            case 20141: goto L416;
            case 20142: goto L414;
            case 20143: goto L412;
            case 20144: goto L410;
            case 20145: goto L408;
            case 20146: goto L406;
            case 20147: goto L404;
            case 20148: goto L402;
            case 20149: goto L400;
            case 20150: goto L398;
            case 20151: goto L396;
            case 20152: goto L394;
            case 20153: goto L392;
            case 20154: goto L390;
            case 20155: goto L388;
            case 20156: goto L386;
            case 20157: goto L384;
            case 20158: goto L382;
            case 20159: goto L380;
            case 20160: goto L378;
            case 20161: goto L376;
            case 20162: goto L374;
            case 20163: goto L372;
            case 20164: goto L370;
            case 20165: goto L368;
            case 20166: goto L366;
            case 20167: goto L364;
            case 20168: goto L362;
            case 20169: goto L360;
            case 20170: goto L358;
            case 20171: goto L356;
            case 20172: goto L354;
            case 20173: goto L352;
            case 20174: goto L350;
            case 20175: goto L348;
            case 20176: goto L346;
            case 20177: goto L344;
            case 20178: goto L342;
            case 20179: goto L340;
            case 20180: goto L338;
            case 20181: goto L336;
            case 20182: goto L334;
            case 20183: goto L332;
            case 20184: goto L330;
            case 20185: goto L328;
            case 20186: goto L326;
            case 20187: goto L324;
            case 20188: goto L322;
            case 20189: goto L320;
            case 20190: goto L318;
            case 20191: goto L316;
            case 20192: goto L314;
            case 20193: goto L312;
            case 20194: goto L310;
            case 20195: goto L308;
            case 20196: goto L306;
            case 20197: goto L304;
            case 20198: goto L302;
            case 20199: goto L300;
            case 20200: goto L298;
            case 20201: goto L296;
            case 20202: goto L294;
            case 20203: goto L292;
            case 20204: goto L290;
            case 20205: goto L288;
            case 20206: goto L286;
            case 20207: goto L284;
            case 20208: goto L282;
            case 20209: goto L280;
            case 20210: goto L278;
            case 20211: goto L276;
            case 20212: goto L274;
            case 20213: goto L272;
            case 20214: goto L270;
            case 20215: goto L268;
            case 20216: goto L266;
            case 20217: goto L264;
            case 20218: goto L262;
            case 20219: goto L260;
            case 20220: goto L258;
            case 20221: goto L256;
            case 20222: goto L254;
            case 20223: goto L252;
            case 20224: goto L250;
            case 20225: goto L248;
            case 20226: goto L246;
            case 20227: goto L4;
            case 20228: goto L244;
            case 20229: goto L242;
            case 20230: goto L240;
            case 20231: goto L238;
            case 20232: goto L236;
            case 20233: goto L234;
            case 20234: goto L232;
            case 20235: goto L230;
            case 20236: goto L228;
            case 20237: goto L226;
            case 20238: goto L224;
            case 20239: goto L222;
            case 20240: goto L220;
            case 20241: goto L218;
            case 20242: goto L216;
            case 20243: goto L4;
            case 20244: goto L4;
            case 20245: goto L214;
            case 20246: goto L212;
            case 20247: goto L210;
            case 20248: goto L208;
            case 20249: goto L206;
            case 20250: goto L204;
            case 20251: goto L202;
            case 20252: goto L200;
            case 20253: goto L198;
            case 20254: goto L196;
            case 20255: goto L194;
            case 20256: goto L192;
            case 20257: goto L190;
            case 20258: goto L188;
            case 20259: goto L186;
            case 20260: goto L184;
            case 20261: goto L182;
            case 20262: goto L180;
            case 20263: goto L178;
            case 20264: goto L176;
            case 20265: goto L174;
            case 20266: goto L172;
            case 20267: goto L170;
            case 20268: goto L168;
            case 20269: goto L166;
            case 20270: goto L164;
            case 20271: goto L162;
            case 20272: goto L160;
            case 20273: goto L158;
            case 20274: goto L156;
            case 20275: goto L154;
            case 20276: goto L152;
            case 20277: goto L150;
            case 20278: goto L148;
            case 20279: goto L146;
            case 20280: goto L144;
            case 20281: goto L142;
            case 20282: goto L140;
            case 20283: goto L138;
            case 20284: goto L136;
            case 20285: goto L134;
            case 20286: goto L132;
            case 20287: goto L130;
            case 20288: goto L128;
            case 20289: goto L126;
            case 20290: goto L124;
            case 20291: goto L122;
            case 20292: goto L120;
            case 20293: goto L118;
            case 20294: goto L116;
            case 20295: goto L114;
            case 20296: goto L112;
            case 20297: goto L110;
            case 20298: goto L108;
            case 20299: goto L106;
            case 20300: goto L104;
            case 20301: goto L102;
            case 20302: goto L100;
            case 20303: goto L98;
            case 20304: goto L96;
            case 20305: goto L94;
            case 20306: goto L92;
            case 20307: goto L90;
            case 20308: goto L88;
            case 20309: goto L86;
            case 20310: goto L84;
            case 20311: goto L82;
            case 20312: goto L80;
            case 20313: goto L78;
            case 20314: goto L76;
            case 20315: goto L74;
            case 20316: goto L72;
            case 20317: goto L70;
            case 20318: goto L68;
            case 20319: goto L66;
            case 20320: goto L64;
            case 20321: goto L62;
            case 20322: goto L60;
            case 20323: goto L58;
            case 20324: goto L56;
            case 20325: goto L54;
            case 20326: goto L52;
            case 20327: goto L50;
            case 20328: goto L48;
            case 20329: goto L46;
            case 20330: goto L44;
            case 20331: goto L42;
            case 20332: goto L40;
            case 20333: goto L38;
            case 20334: goto L36;
            case 20335: goto L34;
            case 20336: goto L32;
            case 20337: goto L30;
            case 20338: goto L28;
            case 20339: goto L26;
            case 20340: goto L24;
            case 20341: goto L22;
            case 20342: goto L21;
            case 20343: goto L19;
            case 20344: goto L18;
            case 20345: goto L16;
            case 20346: goto L14;
            case 20347: goto L12;
            case 20348: goto L10;
            case 20349: goto L8;
            case 20350: goto L6;
            default: goto L4;
        };
    L4:
        return "";
    L6:
        return "mapstyle";
    L8:
        return "force-can-scroll";
    L10:
        return "initial-scroll-offset";
    L12:
        return "consume-slide-event";
    L14:
        return "block-native-event-areas";
    L16:
        return "native-interaction-enabled";
    L18:
        return "indicator-dots";
    L19:
        return "default-index";
    L21:
        return VideoThumbInfo.KEY_INTERVAL;
    L22:
        return "orientation";
    L24:
        return "bounces";
    L26:
        return "estimated-main-axis-size-px";
    L28:
        return "full-span";
    L30:
        return "sticky-bottom";
    L32:
        return "sticky-top";
    L34:
        return "reuse-identifier";
    L36:
        return "list-container-info";
    L38:
        return "experimental-max-fling-distance-ratio";
    L40:
        return "preload-buffer-count";
    L42:
        return "update-animation-fade-in-duration";
    L44:
        return "enable-fade-in-animation";
    L46:
        return "item-snap";
    L48:
        return "layout-id";
    L50:
        return "need-layout-complete-info";
    L52:
        return "need-visible-item-info";
    L54:
        return "initial-scroll-index";
    L56:
        return "sticky-offset";
    L58:
        return "scroll-orientation";
    L60:
        return "span-count";
    L62:
        return "initial-select-index";
    L64:
        return "default-value";
    L66:
        return "ignore-focus";
    L68:
        return "text-single-line-vertical-align";
    L70:
        return "ios-gesture-offset";
    L72:
        return "refresh-mode";
    L74:
        return "event-through";
    L76:
        return "dynamic-resource";
    L78:
        return "ignore-attach-status";
    L80:
        return "max-frame-rate";
    L82:
        return "fps-event-interval";
    L84:
        return "content-id";
    L86:
        return "markdown-effect";
    L88:
        return "content-range";
    L90:
        return "typewriter-dynamic-height";
    L92:
        return "content-complete";
    L94:
        return "initial-animation-step";
    L96:
        return "enable-resource-hint";
    L98:
        return "async-display";
    L100:
        return "android-accessibility-keep-focused";
    L102:
        return "accessibility-role-description";
    L104:
        return "accessibility-heading";
    L106:
        return "accessibility-status";
    L108:
        return "accessibility-value";
    L110:
        return "accessibility-traits";
    L112:
        return "android-consume-hover-event";
    L114:
        return "accessibility-actions";
    L116:
        return "accessibility-elements-hidden";
    L118:
        return "accessibility-exclusive-focus";
    L120:
        return "accessibility-elements-a11y";
    L122:
        return "a11y-id";
    L124:
        return "accessibility-elements";
    L126:
        return "accessibility-enable-tap";
    L128:
        return "accessibility-element";
    L130:
        return "accessibility-label";
    L132:
        return "experimental-sync-load";
    L134:
        return "flash";
    L136:
        return "enable-zoom-gesture";
    L138:
        return "resolution";
    L140:
        return "initial-zoom";
    L142:
        return TECameraSettings.Features.CAMERA_FACING;
    L144:
        return "input-filter";
    L146:
        return "animation-velocity";
    L148:
        return "animation-type";
    L150:
        return "markdown-style";
    L152:
        return "enable-loadmore";
    L154:
        return "enable-refresh";
    L156:
        return "auto-reverse";
    L158:
        return "end-frame";
    L160:
        return "start-frame";
    L162:
        return "json";
    L164:
        return "src-polyfill";
    L166:
        return "src-format";
    L168:
        return "progress";
    L170:
        return "playstatus";
    L172:
        return "block-native-event";
    L174:
        return "collisionPercent";
    L176:
        return "enableCollision";
    L178:
        return "enableTiltGestures";
    L180:
        return "enableRotateGestures";
    L182:
        return "enableScrollGestures";
    L184:
        return "enableZoomGestures";
    L186:
        return "userLocationAnnotation";
    L188:
        return "needUserLocationHeading";
    L190:
        return "item-sizing";
    L192:
        return "alignment";
    L194:
        return "reverse";
    L196:
        return "row-gap";
    L198:
        return "column-gap";
    L200:
        return "grid-auto-flow";
    L202:
        return "justify-items";
    L204:
        return "grid-row-gap";
    L206:
        return "grid-column-gap";
    L208:
        return "grid-auto-rows";
    L210:
        return "grid-auto-columns";
    L212:
        return "grid-template-rows";
    L214:
        return "grid-template-columns";
    L216:
        return "linear-weight-sum";
    L218:
        return "linear-gravity";
    L220:
        return "linear-cross-gravity";
    L222:
        return "linear-orientation";
    L224:
        return GXTemplateKey.FLEXBOX_JUSTIFY_CONTENT;
    L226:
        return GXTemplateKey.FLEXBOX_ALIGN_CONTENT;
    L228:
        return GXTemplateKey.FLEXBOX_ALIGN_ITEMS;
    L230:
        return GXTemplateKey.FLEXBOX_FLEX_WRAP;
    L232:
        return GXTemplateKey.FLEXBOX_FLEX_DIRECTION;
    L234:
        return "line";
    L236:
        return "annotation";
    L238:
        return "bound";
    L240:
        return GestureAction.zoom;
    L242:
        return "center";
    L244:
        return "enable-scroll-bar";
    L246:
        return "scroll-offset";
    L248:
        return "scroll-fling";
    L250:
        return "stackAnimation";
    L252:
        return "exposure-screen-margin-bottom";
    L254:
        return "exposure-screen-margin-top";
    L256:
        return "exposure-screen-margin-right";
    L258:
        return "exposure-screen-margin-left";
    L260:
        return "exposure-ui-margin-bottom";
    L262:
        return "exposure-ui-margin-top";
    L264:
        return "exposure-ui-margin-right";
    L266:
        return "exposure-ui-margin-left";
    L268:
        return "enable-exposure-ui-margin";
    L270:
        return "exposure-area";
    L272:
        return "exposure-id";
    L274:
        return "exposure-scene";
    L276:
        return "tag";
    L278:
        return "select";
    L280:
        return "text-bold-mode";
    L282:
        return "unselected-text-color";
    L284:
        return "unselected-text-size";
    L286:
        return "selected-text-color";
    L288:
        return "selected-text-size";
    L290:
        return "disable-attach-event";
    L292:
        return "tabbar-background";
    L294:
        return "tab-padding-right";
    L296:
        return "tab-padding-left";
    L298:
        return "hide-border";
    L300:
        return GXTemplateKey.STYLE_BORDER_COLOR;
    L302:
        return GXTemplateKey.FLEXBOX_BORDER_TOP;
    L304:
        return GXTemplateKey.STYLE_BORDER_WIDTH;
    L306:
        return "border-height";
    L308:
        return "hide-indicator";
    L310:
        return "tab-indicator-top";
    L312:
        return "tab-indicator-radius";
    L314:
        return "tab-indicator-height";
    L316:
        return "tab-indicator-width";
    L318:
        return "tab-indicator-color";
    L320:
        return "tab-inter-space";
    L322:
        return "tab-height";
    L324:
        return "tab-layout-gravity";
    L326:
        return "user-interaction-enabled";
    L328:
        return "keep-item-view";
    L330:
        return "page-change-animation";
    L332:
        return "allow-horizontal-gesture";
    L334:
        return "select-index";
    L336:
        return "low-quality";
    L338:
        return "moveable";
    L340:
        return "player-type";
    L342:
        return "render-mode";
    L344:
        return "reuse-engine";
    L346:
        return "last-frame";
    L348:
        return "keep-last-frame";
    L350:
        return "controls";
    L352:
        return "__control";
    L354:
        return "preload-key";
    L356:
        return "cache";
    L358:
        return "intrinsic-height";
    L360:
        return "intrinsic-width";
    L362:
        return "videoheight";
    L364:
        return "videowidth";
    L366:
        return "devicechangeaware";
    L368:
        return "objectfit";
    L370:
        return "poster";
    L372:
        return "autolifecycle";
    L374:
        return "rate";
    L376:
        return ITTVideoEngineEventSource.KEY_VOLUME;
    L378:
        return "speed";
    L380:
        return "muted";
    L382:
        return "loop-count";
    L384:
        return "loop";
    L386:
        return "inittime";
    L388:
        return "preload";
    L390:
        return "readonly";
    L392:
        return "auto-size";
    L394:
        return "preferred-focus-child";
    L396:
        return "auto-save-last-child";
    L398:
        return "allow-escape";
    L400:
        return "next-focus-fallback";
    L402:
        return "next-focus-right";
    L404:
        return "next-focus-left";
    L406:
        return "next-focus-down";
    L408:
        return "next-focus-up";
    L410:
        return "focusable";
    L412:
        return "bottom-inset";
    L414:
        return "auto-fix";
    L416:
        return "adjust-mode";
    L418:
        return "smart-scroll";
    L420:
        return "fullscreen-mode";
    L422:
        return "richtype";
    L424:
        return "caret-color";
    L426:
        return "edit-on-focus";
    L428:
        return ButtonColorBean.StateFocus;
    L430:
        return "maxlength";
    L432:
        return "disabled";
    L434:
        return "placeholder-color";
    L436:
        return "placeholder-font-weight";
    L438:
        return "placeholder-font-size";
    L440:
        return "confirm-type";
    L442:
        return "value";
    L444:
        return "keyboard-type";
    L446:
        return "use-soft-keyboard";
    L448:
        return "show-soft-input-on-focus";
    L450:
        return ECLynxImage.DEFER_SRC_INVALIDATION;
    L452:
        return "cap-insets-scale";
    L454:
        return "cap-insets";
    L456:
        return "image-transition-style";
    L458:
        return "name";
    L460:
        return "align-focus";
    L462:
        return "focus-index";
    L464:
        return "intersection-observers";
    L466:
        return "full-screen";
    L468:
        return "overlay-id";
    L470:
        return LynxUIOverlay.PROP_EVENTS_PASS_THROUGH;
    L472:
        return "visible";
    L474:
        return "skip-redirection";
    L476:
        return "content";
    L478:
        return "item-key";
    L480:
        return "needs-visible-cells";
    L482:
        return "idSelector";
    L484:
        return "vertical-orientation";
    L486:
        return "scroll-direction";
    L488:
        return "scroll-without-focus";
    L490:
        return "focus-smooth-scroll";
    L492:
        return "sticky";
    L494:
        return "column-count";
    L496:
        return "update-list-info";
    L498:
        return "update-animation";
    L500:
        return "list-main-axis-gap";
    L502:
        return "list-cross-axis-gap";
    L504:
        return "list-type";
    L506:
        return "scroll-event-throttle";
    L508:
        return "upper-threshold-item-count";
    L510:
        return "lower-threshold-item-count";
    L512:
        return "upper-threshold";
    L514:
        return "lower-threshold";
    L516:
        return "direction";
    L518:
        return "scroll-to-id";
    L520:
        return "scroll-to-index";
    L522:
        return "scroll-left";
    L524:
        return "scroll-top";
    L526:
        return "scroll-bar-auto-hide-delay";
    L528:
        return "scroll-bar-auto-hide";
    L530:
        return "scroll-bar-track-color";
    L532:
        return "scroll-bar-thumb-active-color";
    L534:
        return "scroll-bar-thumb-color";
    L536:
        return "scroll-bar-thumb-radius";
    L538:
        return "scroll-bar-thumb-min-length";
    L540:
        return "scroll-bar-thumb-width";
    L542:
        return "scroll-bar-width";
    L544:
        return "enable-drag";
    L546:
        return "header-over-slot";
    L548:
        return GXTemplateKey.GAIAX_LAYER_SCROLL_ENABLE;
    L550:
        return "granularity";
    L552:
        return "scroll-bar-enable";
    L554:
        return "enable-new-animator";
    L556:
        return "enable-nested-scroll";
    L558:
        return "enable-scroll";
    L560:
        return "bounce";
    L562:
        return "scroll-y-reverse";
    L564:
        return "scroll-x-reverse";
    L566:
        return "scroll-y";
    L568:
        return "scroll-x";
    L570:
        return "max-y-scale";
    L572:
        return "min-y-scale";
    L574:
        return "max-x-scale";
    L576:
        return "min-x-scale";
    L578:
        return "norm-translation-factor";
    L580:
        return "next-margin";
    L582:
        return "previous-margin";
    L584:
        return "page-margin";
    L586:
        return "smooth-scroll";
    L588:
        return "touchable";
    L590:
        return "vertical";
    L592:
        return "circular";
    L594:
        return "duration";
    L596:
        return "display-multiple-items";
    L598:
        return VideoThumbInfo.KEY_INTERVAL;
    L599:
        return "current-item-id";
    L601:
        return "current";
    L603:
        return "autoplay";
    L605:
        return "indicator-radius";
    L607:
        return "indicator-active-color";
    L609:
        return "indicator-cursor";
    L611:
        return "indicator-color";
    L613:
        return "indicator-dots";
    L614:
        return "-x-auto-font-size-preset-sizes";
    L616:
        return "-x-auto-font-size";
    L618:
        return "enable-font-scaling";
    L620:
        return "vertical-align";
    L622:
        return "word-break";
    L624:
        return "text-indent";
    L626:
        return "text-stroke-width";
    L628:
        return "text-stroke-color";
    L630:
        return "text-selection";
    L632:
        return "text-shadow";
    L634:
        return GXTemplateKey.STYLE_FONT_TEXT_DECORATION;
    L636:
        return GXTemplateKey.STYLE_FONT_TEXT_ALIGN;
    L638:
        return GXTemplateKey.STYLE_FONT_FAMILY;
    L640:
        return "letter-spacing";
    L642:
        return "text-maxlength";
    L644:
        return "maxlines";
    L646:
        return "text-maxline";
    L648:
        return "white-space";
    L650:
        return GXTemplateKey.GAIAX_LAYER_LINE_SPACING;
    L652:
        return GXTemplateKey.STYLE_FONT_LINE_HEIGHT;
    L654:
        return "font-style";
    L656:
        return GXTemplateKey.STYLE_FONT_WEIGHT;
    L658:
        return GXTemplateKey.STYLE_FONT_TEXT_OVERFLOW;
    L660:
        return "text-gradient";
    L662:
        return "color";
    L664:
        return GXTemplateKey.STYLE_BACKGROUND_COLOR;
    L666:
        return GXTemplateKey.STYLE_FONT_SIZE;
    L668:
        return "drop-shadow";
    L670:
        return "blur-radius";
    L672:
        return "blur";
    L674:
        return GXTemplateKey.GAIAX_PLACEHOLDER;
    L676:
        return SalesInfoStruct.REPEAT;
    L678:
        return "mode";
    L680:
        return "prevent-loading-on-list-scroll";
    L682:
        return "src";
    L684:
        return "text";
    L686:
        return "test-tag";
    }

    public static ElementAttribute[] values() {
        return (ElementAttribute[]) f405691a.clone();
    }

    static {
        ElementAttribute r100 = new ElementAttribute("RelaxTestTag", 0, 20000);
        RelaxTestTag = r100;
        ElementAttribute r101 = new ElementAttribute("Text", 1, 20001);
        Text = r101;
        ElementAttribute r102 = new ElementAttribute("Src", 2, 20002);
        Src = r102;
        ElementAttribute r103 = new ElementAttribute("PreventLoadingOnListScroll", 3, 20003);
        PreventLoadingOnListScroll = r103;
        ElementAttribute r104 = new ElementAttribute("Mode", 4, 20004);
        Mode = r104;
        ElementAttribute r105 = new ElementAttribute("Repeat", 5, 20005);
        Repeat = r105;
        ElementAttribute r110 = new ElementAttribute("Placeholder", 6, 20006);
        Placeholder = r110;
        ElementAttribute r111 = new ElementAttribute("Blur", 7, 20007);
        Blur = r111;
        ElementAttribute r112 = new ElementAttribute("BlurRadius", 8, 20008);
        BlurRadius = r112;
        ElementAttribute r113 = new ElementAttribute("DropShadow", 9, 20009);
        DropShadow = r113;
        ElementAttribute r114 = new ElementAttribute("FontSize", 10, 20010);
        FontSize = r114;
        ElementAttribute r106 = new ElementAttribute("BackgroundColor", 11, 20011);
        BackgroundColor = r106;
        ElementAttribute r107 = new ElementAttribute("Color", 12, 20012);
        Color = r107;
        ElementAttribute r108 = new ElementAttribute("TextGradient", 13, CommonConstants.ShareErrorCode.CANCEL_PUBLISH);
        TextGradient = r108;
        ElementAttribute r109 = new ElementAttribute("TextOverflow", 14, 20014);
        TextOverflow = r109;
        ElementAttribute r115 = new ElementAttribute("FontWeight", 15, CommonConstants.ShareErrorCode.SAVE_TO_DRAFT);
        FontWeight = r115;
        ElementAttribute r116 = new ElementAttribute("FontStyle", 16, CommonConstants.ShareErrorCode.PUBLISH_FAIL_UNKNOWN);
        FontStyle = r116;
        ElementAttribute r117 = new ElementAttribute("LineHeight", 17, 20017);
        LineHeight = r117;
        ElementAttribute r118 = new ElementAttribute("LineSpacing", 18, 20018);
        LineSpacing = r118;
        ElementAttribute r119 = new ElementAttribute("WhiteSpace", 19, 20019);
        WhiteSpace = r119;
        ElementAttribute r120 = new ElementAttribute("TextMaxline", 20, 20020);
        TextMaxline = r120;
        ElementAttribute r121 = new ElementAttribute("MaxLines", 21, 20021);
        MaxLines = r121;
        ElementAttribute r122 = new ElementAttribute("TextMaxlength", 22, 20022);
        TextMaxlength = r122;
        ElementAttribute r123 = new ElementAttribute("LetterSpacing", 23, 20023);
        LetterSpacing = r123;
        ElementAttribute r124 = new ElementAttribute("FontFamily", 24, 20024);
        FontFamily = r124;
        ElementAttribute r125 = new ElementAttribute("TextAlign", 25, 20025);
        TextAlign = r125;
        ElementAttribute r126 = new ElementAttribute("TextDecoration", 26, 20027);
        TextDecoration = r126;
        ElementAttribute r127 = new ElementAttribute("TextShadow", 27, 20028);
        TextShadow = r127;
        ElementAttribute r128 = new ElementAttribute("TextSelect", 28, 20029);
        TextSelect = r128;
        ElementAttribute r129 = new ElementAttribute("TextStrokeColor", 29, 20030);
        TextStrokeColor = r129;
        ElementAttribute r130 = new ElementAttribute("TextStrokeWidth", 30, 20031);
        TextStrokeWidth = r130;
        ElementAttribute r131 = new ElementAttribute("TextIndent", 31, 20032);
        TextIndent = r131;
        ElementAttribute r132 = new ElementAttribute("WordBreak", 32, 20033);
        WordBreak = r132;
        ElementAttribute r133 = new ElementAttribute("VerticalAlign", 33, 20034);
        VerticalAlign = r133;
        ElementAttribute r134 = new ElementAttribute("EnableFontScaling", 34, 20035);
        EnableFontScaling = r134;
        ElementAttribute r135 = new ElementAttribute("AutoFontSize", 35, 20036);
        AutoFontSize = r135;
        ElementAttribute r136 = new ElementAttribute("AutoFontSizePresetSizes", 36, 20037);
        AutoFontSizePresetSizes = r136;
        ElementAttribute r137 = new ElementAttribute("IndicatorDots", 37, 20038);
        IndicatorDots = r137;
        ElementAttribute r138 = new ElementAttribute("IndicatorColor", 38, 20039);
        IndicatorColor = r138;
        ElementAttribute r139 = new ElementAttribute("IndicatorCursor", 39, 20040);
        IndicatorCursor = r139;
        ElementAttribute r140 = new ElementAttribute("IndicatorActiveColor", 40, 20041);
        IndicatorActiveColor = r140;
        ElementAttribute r141 = new ElementAttribute("IndicatorRadius", 41, 20042);
        IndicatorRadius = r141;
        ElementAttribute r142 = new ElementAttribute("Autoplay", 42, 20043);
        Autoplay = r142;
        ElementAttribute r143 = new ElementAttribute("Current", 43, 20044);
        Current = r143;
        ElementAttribute r144 = new ElementAttribute("CurrentItemId", 44, 20045);
        CurrentItemId = r144;
        ElementAttribute r145 = new ElementAttribute("Interval", 45, 20046);
        Interval = r145;
        ElementAttribute r146 = new ElementAttribute("DisplayMultipleItems", 46, 20047);
        DisplayMultipleItems = r146;
        ElementAttribute r147 = new ElementAttribute("Duration", 47, 20048);
        Duration = r147;
        ElementAttribute r148 = new ElementAttribute("Circular", 48, 20049);
        Circular = r148;
        ElementAttribute r149 = new ElementAttribute("Vertical", 49, 20050);
        Vertical = r149;
        ElementAttribute r150 = new ElementAttribute("Touchable", 50, 20051);
        Touchable = r150;
        ElementAttribute r151 = new ElementAttribute("SmoothScroll", 51, 20052);
        SmoothScroll = r151;
        ElementAttribute r152 = new ElementAttribute("PageMargin", 52, 20053);
        PageMargin = r152;
        ElementAttribute r153 = new ElementAttribute("PreviousMargin", 53, 20054);
        PreviousMargin = r153;
        ElementAttribute r154 = new ElementAttribute("NextMargin", 54, 20055);
        NextMargin = r154;
        ElementAttribute r155 = new ElementAttribute("NormTranslationFactor", 55, 20056);
        NormTranslationFactor = r155;
        ElementAttribute r156 = new ElementAttribute("MinXScale", 56, 20057);
        MinXScale = r156;
        ElementAttribute r157 = new ElementAttribute("MaxXScale", 57, 20058);
        MaxXScale = r157;
        ElementAttribute r158 = new ElementAttribute("MinYScale", 58, 20059);
        MinYScale = r158;
        ElementAttribute r159 = new ElementAttribute("MaxYScale", 59, 20060);
        MaxYScale = r159;
        ElementAttribute r160 = new ElementAttribute("ScrollX", 60, 20061);
        ScrollX = r160;
        ElementAttribute r161 = new ElementAttribute("ScrollY", 61, 20062);
        ScrollY = r161;
        ElementAttribute r162 = new ElementAttribute("ScrollXReverse", 62, 20063);
        ScrollXReverse = r162;
        ElementAttribute r163 = new ElementAttribute("ScrollYReverse", 63, 20064);
        ScrollYReverse = r163;
        ElementAttribute r164 = new ElementAttribute("Bounce", 64, 20065);
        Bounce = r164;
        ElementAttribute r165 = new ElementAttribute("EnableScroll", 65, 20066);
        EnableScroll = r165;
        ElementAttribute r166 = new ElementAttribute("EnableNestedScroll", 66, 20067);
        EnableNestedScroll = r166;
        ElementAttribute r167 = new ElementAttribute("EnableNewAnimator", 67, 20068);
        EnableNewAnimator = r167;
        ElementAttribute r168 = new ElementAttribute("ScrollbarEnable", 68, 20069);
        ScrollbarEnable = r168;
        ElementAttribute r169 = new ElementAttribute("Granularity", 69, 20070);
        Granularity = r169;
        ElementAttribute r170 = new ElementAttribute("ScrollEnable", 70, 20071);
        ScrollEnable = r170;
        ElementAttribute r171 = new ElementAttribute("HeaderOverSlot", 71, 20072);
        HeaderOverSlot = r171;
        ElementAttribute r172 = new ElementAttribute("EnableDrag", 72, 20073);
        EnableDrag = r172;
        ElementAttribute r173 = new ElementAttribute("ScrollbarWidth", 73, 20074);
        ScrollbarWidth = r173;
        ElementAttribute r174 = new ElementAttribute("ScrollbarThumbWidth", 74, 20075);
        ScrollbarThumbWidth = r174;
        ElementAttribute r175 = new ElementAttribute("ScrollbarThumbMinLength", 75, 20076);
        ScrollbarThumbMinLength = r175;
        ElementAttribute r176 = new ElementAttribute("ScrollbarThumbRadius", 76, 20077);
        ScrollbarThumbRadius = r176;
        ElementAttribute r177 = new ElementAttribute("ScrollbarThumbColor", 77, 20078);
        ScrollbarThumbColor = r177;
        ElementAttribute r178 = new ElementAttribute("ScrollbarThumbActiveColor", 78, 20079);
        ScrollbarThumbActiveColor = r178;
        ElementAttribute r179 = new ElementAttribute("ScrollbarTrackColor", 79, 20080);
        ScrollbarTrackColor = r179;
        ElementAttribute r180 = new ElementAttribute("ScrollbarAutoHide", 80, 20081);
        ScrollbarAutoHide = r180;
        ElementAttribute r181 = new ElementAttribute("ScrollbarAutoHideDelay", 81, 20082);
        ScrollbarAutoHideDelay = r181;
        ElementAttribute r182 = new ElementAttribute("ScrollTop", 82, 20083);
        ScrollTop = r182;
        ElementAttribute r183 = new ElementAttribute("ScrollLeft", 83, 20084);
        ScrollLeft = r183;
        ElementAttribute r184 = new ElementAttribute("ScrollToIndex", 84, 20085);
        ScrollToIndex = r184;
        ElementAttribute r185 = new ElementAttribute("ScrollToId", 85, 20086);
        ScrollToId = r185;
        ElementAttribute r186 = new ElementAttribute("Direction", 86, 20087);
        Direction = r186;
        ElementAttribute r187 = new ElementAttribute("LowerThreshold", 87, 20088);
        LowerThreshold = r187;
        ElementAttribute r188 = new ElementAttribute("UpperThreshold", 88, 20089);
        UpperThreshold = r188;
        ElementAttribute r189 = new ElementAttribute("LowerThresholdItemCount", 89, 20090);
        LowerThresholdItemCount = r189;
        ElementAttribute r190 = new ElementAttribute("UpperThresholdItemCount", 90, 20091);
        UpperThresholdItemCount = r190;
        ElementAttribute r191 = new ElementAttribute("ScrollEventThrottle", 91, 20092);
        ScrollEventThrottle = r191;
        ElementAttribute r192 = new ElementAttribute("ListType", 92, 20093);
        ListType = r192;
        ElementAttribute r193 = new ElementAttribute("ListCrossAxisGap", 93, 20094);
        ListCrossAxisGap = r193;
        ElementAttribute r194 = new ElementAttribute("ListMainAxisGap", 94, 20095);
        ListMainAxisGap = r194;
        ElementAttribute r195 = new ElementAttribute("UpdateAnimation", 95, 20096);
        UpdateAnimation = r195;
        ElementAttribute r196 = new ElementAttribute("UpdateListInfo", 96, 20097);
        UpdateListInfo = r196;
        ElementAttribute r197 = new ElementAttribute("ColumnCount", 97, 20098);
        ColumnCount = r197;
        ElementAttribute r198 = new ElementAttribute("Sticky", 98, 20099);
        Sticky = r198;
        ElementAttribute r199 = new ElementAttribute("FocusSmoothScroll", 99, 20100);
        FocusSmoothScroll = r199;
        ElementAttribute r200 = new ElementAttribute("ScrollWithoutFocus", 100, 20101);
        ScrollWithoutFocus = r200;
        ElementAttribute r201 = new ElementAttribute("ScrollDirection", 101, 20102);
        ScrollDirection = r201;
        ElementAttribute r202 = new ElementAttribute("VerticalOrientation", 102, 20103);
        VerticalOrientation = r202;
        ElementAttribute r203 = new ElementAttribute("IdSelector", 103, UploadCode.TT_UPLOAD_SERVER_NOT_LOGIN);
        IdSelector = r203;
        ElementAttribute r204 = new ElementAttribute("NeedsVisibleCells", 104, 20105);
        NeedsVisibleCells = r204;
        ElementAttribute r205 = new ElementAttribute("ItemKey", 105, 20106);
        ItemKey = r205;
        ElementAttribute r206 = new ElementAttribute("Content", 106, 20107);
        Content = r206;
        ElementAttribute r207 = new ElementAttribute("SkipRedirection", 107, 20108);
        SkipRedirection = r207;
        ElementAttribute r208 = new ElementAttribute("Visible", 108, 20109);
        Visible = r208;
        ElementAttribute r209 = new ElementAttribute("EventsPassThrough", 109, 20110);
        EventsPassThrough = r209;
        ElementAttribute r210 = new ElementAttribute("OverlayId", 110, 20111);
        OverlayId = r210;
        ElementAttribute r211 = new ElementAttribute("FullScreen", 111, 20112);
        FullScreen = r211;
        ElementAttribute r212 = new ElementAttribute("IntersectionObservers", 112, UploadCode.TT_UPLOAD_SERVER_DISK_NOT_ENOUGH);
        IntersectionObservers = r212;
        ElementAttribute r213 = new ElementAttribute("FocusIndex", 113, 20114);
        FocusIndex = r213;
        ElementAttribute r214 = new ElementAttribute("AlignFocus", 114, 20115);
        AlignFocus = r214;
        ElementAttribute r215 = new ElementAttribute("Name", 115, 20116);
        Name = r215;
        ElementAttribute r216 = new ElementAttribute("ImageTransitionStyle", 116, 20117);
        ImageTransitionStyle = r216;
        ElementAttribute r217 = new ElementAttribute("CapInsets", 117, 20118);
        CapInsets = r217;
        ElementAttribute r218 = new ElementAttribute("CapInsetsScale", 118, 20119);
        CapInsetsScale = r218;
        ElementAttribute r219 = new ElementAttribute("DeferSrcInvalidation", 119, 20120);
        DeferSrcInvalidation = r219;
        ElementAttribute r220 = new ElementAttribute("ShowSoftInputOnFocus", 120, 20121);
        ShowSoftInputOnFocus = r220;
        ElementAttribute r221 = new ElementAttribute("UseSoftKeyboard", 121, 20122);
        UseSoftKeyboard = r221;
        ElementAttribute r222 = new ElementAttribute("KeyboardType", 122, 20123);
        KeyboardType = r222;
        ElementAttribute r223 = new ElementAttribute("Value", 123, 20124);
        Value = r223;
        ElementAttribute r224 = new ElementAttribute("ConfirmType", 124, 20126);
        ConfirmType = r224;
        ElementAttribute r225 = new ElementAttribute("PlaceholderFontSize", 125, 20128);
        PlaceholderFontSize = r225;
        ElementAttribute r226 = new ElementAttribute("PlaceholderFontWeight", 126, 20129);
        PlaceholderFontWeight = r226;
        ElementAttribute r227 = new ElementAttribute("PlaceholderColor", 127, 20130);
        PlaceholderColor = r227;
        ElementAttribute r228 = new ElementAttribute("Disabled", 128, 20131);
        Disabled = r228;
        ElementAttribute r229 = new ElementAttribute("MaxLength", 129, 20132);
        MaxLength = r229;
        ElementAttribute r230 = new ElementAttribute("Focus", 130, 20133);
        Focus = r230;
        ElementAttribute r231 = new ElementAttribute("EditOnFocus", 131, 20134);
        EditOnFocus = r231;
        ElementAttribute r232 = new ElementAttribute("CaretColor", 132, 20137);
        CaretColor = r232;
        ElementAttribute r233 = new ElementAttribute("RichType", 133, 20138);
        RichType = r233;
        ElementAttribute r234 = new ElementAttribute("FullScreenMode", 134, 20139);
        FullScreenMode = r234;
        ElementAttribute r235 = new ElementAttribute("SmartScroll", 135, 20140);
        SmartScroll = r235;
        ElementAttribute r236 = new ElementAttribute("AdjustMode", 136, 20141);
        AdjustMode = r236;
        ElementAttribute r237 = new ElementAttribute("AutoFix", 137, 20142);
        AutoFix = r237;
        ElementAttribute r238 = new ElementAttribute("BottomInset", 138, 20143);
        BottomInset = r238;
        ElementAttribute r239 = new ElementAttribute("Focusable", 139, 20144);
        Focusable = r239;
        ElementAttribute r240 = new ElementAttribute("NextFocusUp", 140, 20145);
        NextFocusUp = r240;
        ElementAttribute r241 = new ElementAttribute("NextFocusDown", 141, 20146);
        NextFocusDown = r241;
        ElementAttribute r242 = new ElementAttribute("NextFocusLeft", 142, 20147);
        NextFocusLeft = r242;
        ElementAttribute r243 = new ElementAttribute("NextFocusRight", 143, 20148);
        NextFocusRight = r243;
        ElementAttribute r244 = new ElementAttribute("NextFocusFallback", 144, 20149);
        NextFocusFallback = r244;
        ElementAttribute r245 = new ElementAttribute("AllowEscape", 145, 20150);
        AllowEscape = r245;
        ElementAttribute r246 = new ElementAttribute("AutoSaveLastChild", 146, 20151);
        AutoSaveLastChild = r246;
        ElementAttribute r247 = new ElementAttribute("PreferredFocusChild", 147, 20152);
        PreferredFocusChild = r247;
        ElementAttribute r248 = new ElementAttribute("AutoSize", 148, 20153);
        AutoSize = r248;
        ElementAttribute r249 = new ElementAttribute("Readonly", 149, 20154);
        Readonly = r249;
        ElementAttribute r250 = new ElementAttribute("Preload", 150, 20155);
        Preload = r250;
        ElementAttribute r251 = new ElementAttribute("InitTime", 151, 20156);
        InitTime = r251;
        ElementAttribute r252 = new ElementAttribute("Loop", 152, 20157);
        Loop = r252;
        ElementAttribute r253 = new ElementAttribute("LoopCount", 153, 20158);
        LoopCount = r253;
        ElementAttribute r254 = new ElementAttribute("Muted", 154, 20159);
        Muted = r254;
        ElementAttribute r255 = new ElementAttribute("Speed", 155, 20160);
        Speed = r255;
        ElementAttribute r256 = new ElementAttribute("Volume", 156, 20161);
        Volume = r256;
        ElementAttribute r257 = new ElementAttribute("Rate", 157, 20162);
        Rate = r257;
        ElementAttribute r258 = new ElementAttribute("AutoLifecycle", 158, 20163);
        AutoLifecycle = r258;
        ElementAttribute r259 = new ElementAttribute("Poster", 159, 20164);
        Poster = r259;
        ElementAttribute r260 = new ElementAttribute("ObjectFit", 160, 20165);
        ObjectFit = r260;
        ElementAttribute r261 = new ElementAttribute("DeviceChangeAware", 161, 20166);
        DeviceChangeAware = r261;
        ElementAttribute r262 = new ElementAttribute("VideoWidth", 162, 20167);
        VideoWidth = r262;
        ElementAttribute r263 = new ElementAttribute("VideoHeight", 163, 20168);
        VideoHeight = r263;
        ElementAttribute r264 = new ElementAttribute("IntrinsicWidth", 164, 20169);
        IntrinsicWidth = r264;
        ElementAttribute r265 = new ElementAttribute("IntrinsicHeight", 165, 20170);
        IntrinsicHeight = r265;
        ElementAttribute r266 = new ElementAttribute("Cache", 166, 20171);
        Cache = r266;
        ElementAttribute r267 = new ElementAttribute("PreloadKey", 167, 20172);
        PreloadKey = r267;
        ElementAttribute r268 = new ElementAttribute("Control", 168, 20173);
        Control = r268;
        ElementAttribute r269 = new ElementAttribute("Controls", 169, 20174);
        Controls = r269;
        ElementAttribute r270 = new ElementAttribute("KeepLastFrame", 170, 20175);
        KeepLastFrame = r270;
        ElementAttribute r271 = new ElementAttribute("LastFrame", 171, 20176);
        LastFrame = r271;
        ElementAttribute r272 = new ElementAttribute("ReuseEngine", 172, 20177);
        ReuseEngine = r272;
        ElementAttribute r273 = new ElementAttribute("RenderMode", 173, 20178);
        RenderMode = r273;
        ElementAttribute r274 = new ElementAttribute("PlayerType", 174, 20179);
        PlayerType = r274;
        ElementAttribute r275 = new ElementAttribute("Moveable", 175, 20180);
        Moveable = r275;
        ElementAttribute r276 = new ElementAttribute("LowQuality", 176, 20181);
        LowQuality = r276;
        ElementAttribute r277 = new ElementAttribute("SelectIndex", 177, 20182);
        SelectIndex = r277;
        ElementAttribute r278 = new ElementAttribute("AllowHorizontalGesture", 178, 20183);
        AllowHorizontalGesture = r278;
        ElementAttribute r279 = new ElementAttribute("PageChangeAnimation", 179, 20184);
        PageChangeAnimation = r279;
        ElementAttribute r280 = new ElementAttribute("KeepItemView", 180, 20185);
        KeepItemView = r280;
        ElementAttribute r281 = new ElementAttribute("UserInteractionEnabled", 181, 20186);
        UserInteractionEnabled = r281;
        ElementAttribute r282 = new ElementAttribute("TabLayoutGravity", 182, 20187);
        TabLayoutGravity = r282;
        ElementAttribute r283 = new ElementAttribute("TabHeight", 183, 20188);
        TabHeight = r283;
        ElementAttribute r284 = new ElementAttribute("TabInterSpace", 184, 20189);
        TabInterSpace = r284;
        ElementAttribute r285 = new ElementAttribute("TabIndicatorColor", 185, 20190);
        TabIndicatorColor = r285;
        ElementAttribute r286 = new ElementAttribute("TabIndicatorWidth", 186, 20191);
        TabIndicatorWidth = r286;
        ElementAttribute r287 = new ElementAttribute("TabIndicatorHeight", 187, 20192);
        TabIndicatorHeight = r287;
        ElementAttribute r288 = new ElementAttribute("TabIndicatorRadius", 188, 20193);
        TabIndicatorRadius = r288;
        ElementAttribute r289 = new ElementAttribute("TabIndicatorTop", 189, 20194);
        TabIndicatorTop = r289;
        ElementAttribute r290 = new ElementAttribute("HideIndicator", 190, 20195);
        HideIndicator = r290;
        ElementAttribute r291 = new ElementAttribute("BorderHeight", 191, 20196);
        BorderHeight = r291;
        ElementAttribute r292 = new ElementAttribute("BorderWidth", 192, 20197);
        BorderWidth = r292;
        ElementAttribute r293 = new ElementAttribute("BorderTop", 193, 20198);
        BorderTop = r293;
        ElementAttribute r294 = new ElementAttribute("BorderColor", MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 20199);
        BorderColor = r294;
        ElementAttribute r295 = new ElementAttribute("HideBorder", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 20200);
        HideBorder = r295;
        ElementAttribute r296 = new ElementAttribute("TabPaddingLeft", MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, VideoSurface.SUPER_RES_STAT_BMF_PACKAGE_SR_LL_V2_1);
        TabPaddingLeft = r296;
        ElementAttribute r297 = new ElementAttribute("TabPaddingRight", MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, UploadCode.TT_UPLOAD_SERVER_HAD_UPLOAD_DONE);
        TabPaddingRight = r297;
        ElementAttribute r298 = new ElementAttribute("TabbarBackground", 198, 20203);
        TabbarBackground = r298;
        ElementAttribute r299 = new ElementAttribute("DisableAttachEvent", 199, VideoSurface.SUPER_RES_STAT_BMF_PACKAGE_SR_LL_V2_4);
        DisableAttachEvent = r299;
        ElementAttribute r300 = new ElementAttribute("SelectedTextSize", 200, 20205);
        SelectedTextSize = r300;
        ElementAttribute r301 = new ElementAttribute("SelectedTextColor", 201, 20206);
        SelectedTextColor = r301;
        ElementAttribute r302 = new ElementAttribute("UnselectedTextSize", 202, 20207);
        UnselectedTextSize = r302;
        ElementAttribute r303 = new ElementAttribute("UnselectedTextColor", 203, 20208);
        UnselectedTextColor = r303;
        ElementAttribute r304 = new ElementAttribute("TextBoldMode", 204, UploadCode.TT_UPLOAD_SERVER_FILE_CONTENT_ERROR);
        TextBoldMode = r304;
        ElementAttribute r305 = new ElementAttribute("Select", 205, 20210);
        Select = r305;
        ElementAttribute r306 = new ElementAttribute("Tag", 206, 20211);
        Tag = r306;
        ElementAttribute r307 = new ElementAttribute("ExposureScene", 207, UploadCode.TT_UPLOAD_SERVER_TASK_DUPLICATE);
        ExposureScene = r307;
        ElementAttribute r308 = new ElementAttribute("ExposureId", 208, 20213);
        ExposureId = r308;
        ElementAttribute r309 = new ElementAttribute("ExposureArea", 209, 20214);
        ExposureArea = r309;
        ElementAttribute r310 = new ElementAttribute("EnableExposureUiMargin", 210, 20215);
        EnableExposureUiMargin = r310;
        ElementAttribute r311 = new ElementAttribute("ExposureUiMarginLeft", 211, 20216);
        ExposureUiMarginLeft = r311;
        ElementAttribute r312 = new ElementAttribute("ExposureUiMarginRight", 212, 20217);
        ExposureUiMarginRight = r312;
        ElementAttribute r313 = new ElementAttribute("ExposureUiMarginTop", 213, 20218);
        ExposureUiMarginTop = r313;
        ElementAttribute r314 = new ElementAttribute("ExposureUiMarginBottom", 214, 20219);
        ExposureUiMarginBottom = r314;
        ElementAttribute r315 = new ElementAttribute("ExposureScreenMarginLeft", 215, 20220);
        ExposureScreenMarginLeft = r315;
        ElementAttribute r316 = new ElementAttribute("ExposureScreenMarginRight", 216, 20221);
        ExposureScreenMarginRight = r316;
        ElementAttribute r317 = new ElementAttribute("ExposureScreenMarginTop", 217, 20222);
        ExposureScreenMarginTop = r317;
        ElementAttribute r318 = new ElementAttribute("ExposureScreenMarginBottom", 218, UploadCode.TT_UPLOAD_SERVER_FILE_CHECK_FAILED);
        ExposureScreenMarginBottom = r318;
        ElementAttribute r319 = new ElementAttribute("StackAnimation", 219, 20224);
        StackAnimation = r319;
        ElementAttribute r320 = new ElementAttribute("ScrollFling", 220, UploadCode.TT_UPLOAD_SERVER_FILE_DEFECT);
        ScrollFling = r320;
        ElementAttribute r321 = new ElementAttribute("ScrollOffset", 221, 20226);
        ScrollOffset = r321;
        ElementAttribute r322 = new ElementAttribute("EnableScrollbar", 222, 20228);
        EnableScrollbar = r322;
        ElementAttribute r323 = new ElementAttribute("Center", 223, 20229);
        Center = r323;
        ElementAttribute r324 = new ElementAttribute("Zoom", 224, 20230);
        Zoom = r324;
        ElementAttribute r325 = new ElementAttribute("Bound", 225, 20231);
        Bound = r325;
        ElementAttribute r326 = new ElementAttribute("Annotation", 226, 20232);
        Annotation = r326;
        ElementAttribute r327 = new ElementAttribute("Line", VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL, 20233);
        Line = r327;
        ElementAttribute r328 = new ElementAttribute("FlexDirection", VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2, 20234);
        FlexDirection = r328;
        ElementAttribute r329 = new ElementAttribute("FlexWrap", 229, 20235);
        FlexWrap = r329;
        ElementAttribute r330 = new ElementAttribute("AlignItems", 230, 20236);
        AlignItems = r330;
        ElementAttribute r331 = new ElementAttribute("AlignContent", 231, 20237);
        AlignContent = r331;
        ElementAttribute r332 = new ElementAttribute("JustifyContent", VideoRef.VALUE_VIDEO_REF_CATEGORY, 20238);
        JustifyContent = r332;
        ElementAttribute r333 = new ElementAttribute("LinearOrientation", 233, 20239);
        LinearOrientation = r333;
        ElementAttribute r334 = new ElementAttribute("LinearCrossGravity", 234, 20240);
        LinearCrossGravity = r334;
        ElementAttribute r335 = new ElementAttribute("LinearGravity", VideoRef.VALUE_VIDEO_REF_AI_BARRAGE_URL, 20241);
        LinearGravity = r335;
        ElementAttribute r336 = new ElementAttribute("LinearWeightSum", VideoRef.VALUE_VIDEO_REF_CONST_DEPTH, 20242);
        LinearWeightSum = r336;
        ElementAttribute r337 = new ElementAttribute("GridTemplateColumns", VideoRef.VALUE_VIDEO_REF_PALLAS_VID_LABELS, 20245);
        GridTemplateColumns = r337;
        ElementAttribute r338 = new ElementAttribute("GridTemplateRows", 238, 20246);
        GridTemplateRows = r338;
        ElementAttribute r339 = new ElementAttribute("GridAutoColumns", VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X, 20247);
        GridAutoColumns = r339;
        ElementAttribute r340 = new ElementAttribute("GridAutoRows", 240, 20248);
        GridAutoRows = r340;
        ElementAttribute r341 = new ElementAttribute("GridColumnGap", 241, 20249);
        GridColumnGap = r341;
        ElementAttribute r342 = new ElementAttribute("GridRowGap", 242, 20250);
        GridRowGap = r342;
        ElementAttribute r343 = new ElementAttribute("JustifyItems", 243, 20251);
        JustifyItems = r343;
        ElementAttribute r344 = new ElementAttribute("GridAutoFlow", 244, 20252);
        GridAutoFlow = r344;
        ElementAttribute r345 = new ElementAttribute("ColumnGap", 245, 20253);
        ColumnGap = r345;
        ElementAttribute r346 = new ElementAttribute("RowGap", 246, 20254);
        RowGap = r346;
        ElementAttribute r347 = new ElementAttribute("Reverse", 247, 20255);
        Reverse = r347;
        ElementAttribute r348 = new ElementAttribute("Alignment", 248, 20256);
        Alignment = r348;
        ElementAttribute r349 = new ElementAttribute("ItemSizing", 249, 20257);
        ItemSizing = r349;
        ElementAttribute r350 = new ElementAttribute("NeedUserLocationHeading", 250, 20258);
        NeedUserLocationHeading = r350;
        ElementAttribute r351 = new ElementAttribute("UserLocationAnnotation", 251, 20259);
        UserLocationAnnotation = r351;
        ElementAttribute r352 = new ElementAttribute("EnableZoomGestures", 252, 20260);
        EnableZoomGestures = r352;
        ElementAttribute r353 = new ElementAttribute("EnableScrollGestures", 253, 20261);
        EnableScrollGestures = r353;
        ElementAttribute r354 = new ElementAttribute("EnableRotateGestures", 254, 20262);
        EnableRotateGestures = r354;
        ElementAttribute r355 = new ElementAttribute("EnableTiltGestures", 255, 20263);
        EnableTiltGestures = r355;
        ElementAttribute r356 = new ElementAttribute("EnableCollision", 256, 20264);
        EnableCollision = r356;
        ElementAttribute r357 = new ElementAttribute("CollisionPercent", 257, 20265);
        CollisionPercent = r357;
        ElementAttribute r358 = new ElementAttribute("BlockNativeEvent", 258, 20266);
        BlockNativeEvent = r358;
        ElementAttribute r359 = new ElementAttribute("PlayStatus", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 20267);
        PlayStatus = r359;
        ElementAttribute r360 = new ElementAttribute("Progress", 260, 20268);
        Progress = r360;
        ElementAttribute r361 = new ElementAttribute("SrcFormat", 261, 20269);
        SrcFormat = r361;
        ElementAttribute r362 = new ElementAttribute("SrcPolyfill", 262, 20270);
        SrcPolyfill = r362;
        ElementAttribute r363 = new ElementAttribute("Json", MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE, 20271);
        Json = r363;
        ElementAttribute r364 = new ElementAttribute("StartFrame", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME, 20272);
        StartFrame = r364;
        ElementAttribute r365 = new ElementAttribute("EndFrame", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 20273);
        EndFrame = r365;
        ElementAttribute r366 = new ElementAttribute("AutoReverse", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, 20274);
        AutoReverse = r366;
        ElementAttribute r367 = new ElementAttribute("EnableRefresh", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, 20275);
        EnableRefresh = r367;
        ElementAttribute r368 = new ElementAttribute("EnableLoadmore", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, 20276);
        EnableLoadmore = r368;
        ElementAttribute r369 = new ElementAttribute("MarkdownStyle", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 20277);
        MarkdownStyle = r369;
        ElementAttribute r370 = new ElementAttribute("AnimationType", 270, 20278);
        AnimationType = r370;
        ElementAttribute r371 = new ElementAttribute("AnimationVelocity", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 20279);
        AnimationVelocity = r371;
        ElementAttribute r372 = new ElementAttribute("InputFilter", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 20280);
        InputFilter = r372;
        ElementAttribute r373 = new ElementAttribute("Facing", 273, 20281);
        Facing = r373;
        ElementAttribute r374 = new ElementAttribute("InitialZoom", 274, 20282);
        InitialZoom = r374;
        ElementAttribute r375 = new ElementAttribute("Resolution", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 20283);
        Resolution = r375;
        ElementAttribute r376 = new ElementAttribute("EnableZoomGesture", MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE, 20284);
        EnableZoomGesture = r376;
        ElementAttribute r377 = new ElementAttribute(ExifInterface.TAG_FLASH, MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, 20285);
        Flash = r377;
        ElementAttribute r378 = new ElementAttribute("ExperimentalSyncLoad", MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 20286);
        ExperimentalSyncLoad = r378;
        ElementAttribute r379 = new ElementAttribute("AccessibilityLabel", MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, 20287);
        AccessibilityLabel = r379;
        ElementAttribute r380 = new ElementAttribute("AccessibilityElement", 280, 20288);
        AccessibilityElement = r380;
        ElementAttribute r381 = new ElementAttribute("AccessibilityEnableTap", MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, 20289);
        AccessibilityEnableTap = r381;
        ElementAttribute r382 = new ElementAttribute("AccessibilityElements", MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 20290);
        AccessibilityElements = r382;
        ElementAttribute r383 = new ElementAttribute("A11yId", MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 20291);
        A11yId = r383;
        ElementAttribute r384 = new ElementAttribute("AccessibilityElementsA11y", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, 20292);
        AccessibilityElementsA11y = r384;
        ElementAttribute r385 = new ElementAttribute("AccessibilityExclusiveFocus", MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL, 20293);
        AccessibilityExclusiveFocus = r385;
        ElementAttribute r386 = new ElementAttribute("AccessibilityElementsHidden", MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS, 20294);
        AccessibilityElementsHidden = r386;
        ElementAttribute r387 = new ElementAttribute("AccessibilityActions", MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 20295);
        AccessibilityActions = r387;
        ElementAttribute r388 = new ElementAttribute("AndroidConsumeHoverEvent", 288, 20296);
        AndroidConsumeHoverEvent = r388;
        ElementAttribute r389 = new ElementAttribute("AccessibilityTraits", MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 20297);
        AccessibilityTraits = r389;
        ElementAttribute r390 = new ElementAttribute("AccessibilityValue", 290, 20298);
        AccessibilityValue = r390;
        ElementAttribute r391 = new ElementAttribute("AccessibilityStatus", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT, 20299);
        AccessibilityStatus = r391;
        ElementAttribute r392 = new ElementAttribute("AccessibilityHeading", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP, 20300);
        AccessibilityHeading = r392;
        ElementAttribute r393 = new ElementAttribute("AccessibilityRoleDescription", MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 20301);
        AccessibilityRoleDescription = r393;
        ElementAttribute r394 = new ElementAttribute("AndroidAccessibilityKeepFocused", MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, 20302);
        AndroidAccessibilityKeepFocused = r394;
        ElementAttribute r395 = new ElementAttribute("AsyncDisplay", MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD, 20303);
        AsyncDisplay = r395;
        ElementAttribute r396 = new ElementAttribute("EnableResourceHint", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 20304);
        EnableResourceHint = r396;
        ElementAttribute r397 = new ElementAttribute("InitialAnimationStep", MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, 20305);
        InitialAnimationStep = r397;
        ElementAttribute r398 = new ElementAttribute("ContentComplete", MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, 20306);
        ContentComplete = r398;
        ElementAttribute r399 = new ElementAttribute("TypewriterDynamicHeight", 299, 20307);
        TypewriterDynamicHeight = r399;
        ElementAttribute r400 = new ElementAttribute("ContentRange", 300, 20308);
        ContentRange = r400;
        ElementAttribute r401 = new ElementAttribute("MarkdownEffect", 301, 20309);
        MarkdownEffect = r401;
        ElementAttribute r402 = new ElementAttribute("ContentId", 302, 20310);
        ContentId = r402;
        ElementAttribute r403 = new ElementAttribute("FpsEventInterval", 303, 20311);
        FpsEventInterval = r403;
        ElementAttribute r404 = new ElementAttribute("MaxFrameRate", 304, 20312);
        MaxFrameRate = r404;
        ElementAttribute r405 = new ElementAttribute("IgnoreAttachStatus", 305, 20313);
        IgnoreAttachStatus = r405;
        ElementAttribute r406 = new ElementAttribute("DynamicResource", 306, 20314);
        DynamicResource = r406;
        ElementAttribute r407 = new ElementAttribute("EventThrough", 307, 20315);
        EventThrough = r407;
        ElementAttribute r408 = new ElementAttribute("RefreshMode", 308, 20316);
        RefreshMode = r408;
        ElementAttribute r409 = new ElementAttribute("IosGestureOffset", 309, 20317);
        IosGestureOffset = r409;
        ElementAttribute r410 = new ElementAttribute("SingleLineVerticalAlign", 310, 20318);
        SingleLineVerticalAlign = r410;
        ElementAttribute r411 = new ElementAttribute("IgnoreFocus", 311, 20319);
        IgnoreFocus = r411;
        ElementAttribute r412 = new ElementAttribute("DefaultValue", 312, 20320);
        DefaultValue = r412;
        ElementAttribute r413 = new ElementAttribute("InitialSelectIndex", 313, 20321);
        InitialSelectIndex = r413;
        ElementAttribute r414 = new ElementAttribute("SpanCount", 314, 20322);
        SpanCount = r414;
        ElementAttribute r415 = new ElementAttribute("ScrollOrientation", 315, 20323);
        ScrollOrientation = r415;
        ElementAttribute r416 = new ElementAttribute("StickyOffset", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, 20324);
        StickyOffset = r416;
        ElementAttribute r417 = new ElementAttribute("InitialScrollIndex", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT, 20325);
        InitialScrollIndex = r417;
        ElementAttribute r418 = new ElementAttribute("NeedVisibleItemInfo", MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, 20326);
        NeedVisibleItemInfo = r418;
        ElementAttribute r419 = new ElementAttribute("NeedLayoutCompleteInfo", MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, 20327);
        NeedLayoutCompleteInfo = r419;
        ElementAttribute r420 = new ElementAttribute("LayoutId", 320, 20328);
        LayoutId = r420;
        ElementAttribute r421 = new ElementAttribute("ItemSnap", 321, 20329);
        ItemSnap = r421;
        ElementAttribute r422 = new ElementAttribute("EnableFadeInAnimation", 322, 20330);
        EnableFadeInAnimation = r422;
        ElementAttribute r423 = new ElementAttribute("UpdateAnimationFadeInDuration", 323, 20331);
        UpdateAnimationFadeInDuration = r423;
        ElementAttribute r424 = new ElementAttribute("PreloadBufferCount", 324, 20332);
        PreloadBufferCount = r424;
        ElementAttribute r425 = new ElementAttribute("ExperimentalMaxFlingDistanceRatio", 325, 20333);
        ExperimentalMaxFlingDistanceRatio = r425;
        ElementAttribute r426 = new ElementAttribute("ListContainerInfo", 326, 20334);
        ListContainerInfo = r426;
        ElementAttribute r427 = new ElementAttribute("ReuseIdentifier", 327, 20335);
        ReuseIdentifier = r427;
        ElementAttribute r428 = new ElementAttribute("StickyTop", 328, 20336);
        StickyTop = r428;
        ElementAttribute r429 = new ElementAttribute("StickyBottom", 329, 20337);
        StickyBottom = r429;
        ElementAttribute r430 = new ElementAttribute("FullSpan", 330, 20338);
        FullSpan = r430;
        ElementAttribute r431 = new ElementAttribute("EstimatedMainAxisSizePx", 331, 20339);
        EstimatedMainAxisSizePx = r431;
        ElementAttribute r432 = new ElementAttribute("Bounces", 332, 20340);
        Bounces = r432;
        ElementAttribute r433 = new ElementAttribute(ExifInterface.TAG_ORIENTATION, 333, 20341);
        Orientation = r433;
        ElementAttribute r434 = new ElementAttribute("AutoplayInterval", 334, 20342);
        AutoplayInterval = r434;
        ElementAttribute r435 = new ElementAttribute("DefaultIndex", 335, 20343);
        DefaultIndex = r435;
        ElementAttribute r436 = new ElementAttribute("Indicator", 336, 20344);
        Indicator = r436;
        ElementAttribute r437 = new ElementAttribute("NativeInteractionEnabled", 337, 20345);
        NativeInteractionEnabled = r437;
        ElementAttribute r438 = new ElementAttribute("BlockNativeEventAreas", 338, 20346);
        BlockNativeEventAreas = r438;
        ElementAttribute r439 = new ElementAttribute("ConsumeSlideEvent", 339, 20347);
        ConsumeSlideEvent = r439;
        ElementAttribute r440 = new ElementAttribute("InitialScrollOffset", 340, 20348);
        InitialScrollOffset = r440;
        ElementAttribute r441 = new ElementAttribute("ForceCanScroll", 341, 20349);
        ForceCanScroll = r441;
        ElementAttribute r442 = new ElementAttribute("MapStyle", 342, 20350);
        MapStyle = r442;
        f405691a = new ElementAttribute[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239, r240, r241, r242, r243, r244, r245, r246, r247, r248, r249, r250, r251, r252, r253, r254, r255, r256, r257, r258, r259, r260, r261, r262, r263, r264, r265, r266, r267, r268, r269, r270, r271, r272, r273, r274, r275, r276, r277, r278, r279, r280, r281, r282, r283, r284, r285, r286, r287, r288, r289, r290, r291, r292, r293, r294, r295, r296, r297, r298, r299, r300, r301, r302, r303, r304, r305, r306, r307, r308, r309, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r320, r321, r322, r323, r324, r325, r326, r327, r328, r329, r330, r331, r332, r333, r334, r335, r336, r337, r338, r339, r340, r341, r342, r343, r344, r345, r346, r347, r348, r349, r350, r351, r352, r353, r354, r355, r356, r357, r358, r359, r360, r361, r362, r363, r364, r365, r366, r367, r368, r369, r370, r371, r372, r373, r374, r375, r376, r377, r378, r379, r380, r381, r382, r383, r384, r385, r386, r387, r388, r389, r390, r391, r392, r393, r394, r395, r396, r397, r398, r399, r400, r401, r402, r403, r404, r405, r406, r407, r408, r409, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r430, r431, r432, r433, r434, r435, r436, r437, r438, r439, r440, r441, r442};
    }

    public int getValue() {
        return this.mValue;
    }

    public static ElementAttribute valueOf(String r100) {
        return (ElementAttribute) a.a(ElementAttribute.class, r100);
    }

    public ElementAttribute(String r100, int r101, int r102) {
        super(r100, r101);
        this.mValue = r102;
    }
}
