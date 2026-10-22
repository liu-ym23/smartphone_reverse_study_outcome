package com.relax.runtime.gen;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.ugc.effectmanager.common.EffectTypeConstants;
import com.ss.ttm.player.MediaPlayer;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum CSSModifierProperty extends Enum<CSSModifierProperty> {
    public static final CSSModifierProperty AdaptFontSize = null;
    public static final CSSModifierProperty AlignContent = null;
    public static final CSSModifierProperty AlignItems = null;
    public static final CSSModifierProperty AlignSelf = null;
    public static final CSSModifierProperty Alignment = null;
    public static final CSSModifierProperty Animation = null;
    public static final CSSModifierProperty AnimationDelay = null;
    public static final CSSModifierProperty AnimationDirection = null;
    public static final CSSModifierProperty AnimationDuration = null;
    public static final CSSModifierProperty AnimationFillMode = null;
    public static final CSSModifierProperty AnimationIterationCount = null;
    public static final CSSModifierProperty AnimationName = null;
    public static final CSSModifierProperty AnimationPlayState = null;
    public static final CSSModifierProperty AnimationTimingFunction = null;
    public static final CSSModifierProperty AspectRatio = null;
    public static final CSSModifierProperty Background = null;
    public static final CSSModifierProperty BackgroundClip = null;
    public static final CSSModifierProperty BackgroundColor = null;
    public static final CSSModifierProperty BackgroundImage = null;
    public static final CSSModifierProperty BackgroundOrigin = null;
    public static final CSSModifierProperty BackgroundPosition = null;
    public static final CSSModifierProperty BackgroundPositionX = null;
    public static final CSSModifierProperty BackgroundPositionY = null;
    public static final CSSModifierProperty BackgroundRepeat = null;
    public static final CSSModifierProperty BackgroundSize = null;
    public static final CSSModifierProperty BackgroundSizeHeight = null;
    public static final CSSModifierProperty BackgroundSizeWidth = null;
    public static final CSSModifierProperty Border = null;
    public static final CSSModifierProperty BorderBottom = null;
    public static final CSSModifierProperty BorderBottomColor = null;
    public static final CSSModifierProperty BorderBottomLeftRadius = null;
    public static final CSSModifierProperty BorderBottomLeftRadiusHorizontal = null;
    public static final CSSModifierProperty BorderBottomLeftRadiusVertical = null;
    public static final CSSModifierProperty BorderBottomRightRadius = null;
    public static final CSSModifierProperty BorderBottomRightRadiusHorizontal = null;
    public static final CSSModifierProperty BorderBottomRightRadiusVertical = null;
    public static final CSSModifierProperty BorderBottomStyle = null;
    public static final CSSModifierProperty BorderBottomWidth = null;
    public static final CSSModifierProperty BorderColor = null;
    public static final CSSModifierProperty BorderEndEndRadius = null;
    public static final CSSModifierProperty BorderEndStartRadius = null;
    public static final CSSModifierProperty BorderInlineEndColor = null;
    public static final CSSModifierProperty BorderInlineEndStyle = null;
    public static final CSSModifierProperty BorderInlineEndWidth = null;
    public static final CSSModifierProperty BorderInlineStartColor = null;
    public static final CSSModifierProperty BorderInlineStartStyle = null;
    public static final CSSModifierProperty BorderInlineStartWidth = null;
    public static final CSSModifierProperty BorderLeft = null;
    public static final CSSModifierProperty BorderLeftColor = null;
    public static final CSSModifierProperty BorderLeftStyle = null;
    public static final CSSModifierProperty BorderLeftWidth = null;
    public static final CSSModifierProperty BorderRadius = null;
    public static final CSSModifierProperty BorderRight = null;
    public static final CSSModifierProperty BorderRightColor = null;
    public static final CSSModifierProperty BorderRightStyle = null;
    public static final CSSModifierProperty BorderRightWidth = null;
    public static final CSSModifierProperty BorderStartEndRadius = null;
    public static final CSSModifierProperty BorderStartStartRadius = null;
    public static final CSSModifierProperty BorderStyle = null;
    public static final CSSModifierProperty BorderTop = null;
    public static final CSSModifierProperty BorderTopColor = null;
    public static final CSSModifierProperty BorderTopLeftRadius = null;
    public static final CSSModifierProperty BorderTopLeftRadiusHorizontal = null;
    public static final CSSModifierProperty BorderTopLeftRadiusVertical = null;
    public static final CSSModifierProperty BorderTopRightRadius = null;
    public static final CSSModifierProperty BorderTopRightRadiusHorizontal = null;
    public static final CSSModifierProperty BorderTopRightRadiusVertical = null;
    public static final CSSModifierProperty BorderTopStyle = null;
    public static final CSSModifierProperty BorderTopWidth = null;
    public static final CSSModifierProperty BorderWidth = null;
    public static final CSSModifierProperty Bottom = null;
    public static final CSSModifierProperty BoxShadow = null;
    public static final CSSModifierProperty BoxShadowBlurRadius = null;
    public static final CSSModifierProperty BoxShadowColor = null;
    public static final CSSModifierProperty BoxShadowOffsetX = null;
    public static final CSSModifierProperty BoxShadowOffsetY = null;
    public static final CSSModifierProperty BoxShadowSpreadRadius = null;
    public static final CSSModifierProperty BoxSizing = null;
    public static final CSSModifierProperty CaretColor = null;
    public static final CSSModifierProperty ClipPath = null;
    public static final CSSModifierProperty Color = null;
    public static final CSSModifierProperty ColumnGap = null;
    public static final CSSModifierProperty Content = null;
    public static final CSSModifierProperty Cursor = null;
    public static final CSSModifierProperty Direction = null;
    public static final CSSModifierProperty Display = null;
    public static final CSSModifierProperty EnterTransitionName = null;
    public static final CSSModifierProperty ExitTransitionName = null;
    public static final CSSModifierProperty Filter = null;
    public static final CSSModifierProperty FlexBasis = null;
    public static final CSSModifierProperty FlexDirection = null;
    public static final CSSModifierProperty FlexGrow = null;
    public static final CSSModifierProperty FlexShrink = null;
    public static final CSSModifierProperty FlexWrap = null;
    public static final CSSModifierProperty FontFamily = null;
    public static final CSSModifierProperty FontSize = null;
    public static final CSSModifierProperty FontStyle = null;
    public static final CSSModifierProperty FontWeight = null;
    public static final CSSModifierProperty GridAutoColumns = null;
    public static final CSSModifierProperty GridAutoFlow = null;
    public static final CSSModifierProperty GridAutoRows = null;
    public static final CSSModifierProperty GridColumnEnd = null;
    public static final CSSModifierProperty GridColumnGap = null;
    public static final CSSModifierProperty GridColumnSpan = null;
    public static final CSSModifierProperty GridColumnStart = null;
    public static final CSSModifierProperty GridRowEnd = null;
    public static final CSSModifierProperty GridRowGap = null;
    public static final CSSModifierProperty GridRowSpan = null;
    public static final CSSModifierProperty GridRowStart = null;
    public static final CSSModifierProperty GridTemplateColumns = null;
    public static final CSSModifierProperty GridTemplateRows = null;
    public static final CSSModifierProperty Height = null;
    public static final CSSModifierProperty ImageRendering = null;
    public static final CSSModifierProperty ImplicitAnimation = null;
    public static final CSSModifierProperty InsetInlineEnd = null;
    public static final CSSModifierProperty InsetInlineStart = null;
    public static final CSSModifierProperty ItemSizing = null;
    public static final CSSModifierProperty JustifyContent = null;
    public static final CSSModifierProperty JustifyItems = null;
    public static final CSSModifierProperty JustifySelf = null;
    public static final CSSModifierProperty Keyframes = null;
    public static final CSSModifierProperty LayoutAnimationCreateDelay = null;
    public static final CSSModifierProperty LayoutAnimationCreateDuration = null;
    public static final CSSModifierProperty LayoutAnimationCreateProperty = null;
    public static final CSSModifierProperty LayoutAnimationCreateTimingFunction = null;
    public static final CSSModifierProperty LayoutAnimationDeleteDelay = null;
    public static final CSSModifierProperty LayoutAnimationDeleteDuration = null;
    public static final CSSModifierProperty LayoutAnimationDeleteProperty = null;
    public static final CSSModifierProperty LayoutAnimationDeleteTimingFunction = null;
    public static final CSSModifierProperty LayoutAnimationUpdateDelay = null;
    public static final CSSModifierProperty LayoutAnimationUpdateDuration = null;
    public static final CSSModifierProperty LayoutAnimationUpdateTimingFunction = null;
    public static final CSSModifierProperty Left = null;
    public static final CSSModifierProperty LetterSpacing = null;
    public static final CSSModifierProperty LineHeight = null;
    public static final CSSModifierProperty LineSpacing = null;
    public static final CSSModifierProperty LinearCrossGravity = null;
    public static final CSSModifierProperty LinearDirection = null;
    public static final CSSModifierProperty LinearGravity = null;
    public static final CSSModifierProperty LinearLayoutGravity = null;
    public static final CSSModifierProperty LinearOrientation = null;
    public static final CSSModifierProperty LinearWeight = null;
    public static final CSSModifierProperty LinearWeightSum = null;
    public static final CSSModifierProperty ListCrossAxisGap = null;
    public static final CSSModifierProperty ListMainAxisGap = null;
    public static final CSSModifierProperty Margin = null;
    public static final CSSModifierProperty MarginBottom = null;
    public static final CSSModifierProperty MarginInlineEnd = null;
    public static final CSSModifierProperty MarginInlineStart = null;
    public static final CSSModifierProperty MarginLeft = null;
    public static final CSSModifierProperty MarginRight = null;
    public static final CSSModifierProperty MarginTop = null;
    public static final CSSModifierProperty Mask = null;
    public static final CSSModifierProperty MaskClip = null;
    public static final CSSModifierProperty MaskImage = null;
    public static final CSSModifierProperty MaskOrigin = null;
    public static final CSSModifierProperty MaskPosition = null;
    public static final CSSModifierProperty MaskRepeat = null;
    public static final CSSModifierProperty MaskSize = null;
    public static final CSSModifierProperty MaxHeight = null;
    public static final CSSModifierProperty MaxWidth = null;
    public static final CSSModifierProperty MinHeight = null;
    public static final CSSModifierProperty MinWidth = null;
    public static final CSSModifierProperty None = null;
    public static final CSSModifierProperty Opacity = null;
    public static final CSSModifierProperty Order = null;
    public static final CSSModifierProperty Outline = null;
    public static final CSSModifierProperty OutlineColor = null;
    public static final CSSModifierProperty OutlineStyle = null;
    public static final CSSModifierProperty OutlineWidth = null;
    public static final CSSModifierProperty Overflow = null;
    public static final CSSModifierProperty OverflowX = null;
    public static final CSSModifierProperty OverflowY = null;
    public static final CSSModifierProperty Padding = null;
    public static final CSSModifierProperty PaddingBottom = null;
    public static final CSSModifierProperty PaddingInlineEnd = null;
    public static final CSSModifierProperty PaddingInlineStart = null;
    public static final CSSModifierProperty PaddingLeft = null;
    public static final CSSModifierProperty PaddingRight = null;
    public static final CSSModifierProperty PaddingTop = null;
    public static final CSSModifierProperty PauseTransitionName = null;
    public static final CSSModifierProperty Perspective = null;
    public static final CSSModifierProperty Position = null;
    public static final CSSModifierProperty RelativeAlignInlineEnd = null;
    public static final CSSModifierProperty RelativeAlignInlineStart = null;
    public static final CSSModifierProperty RelativeInlineEndOf = null;
    public static final CSSModifierProperty RelativeInlineStartOf = null;
    public static final CSSModifierProperty ResumeTransitionName = null;
    public static final CSSModifierProperty Right = null;
    public static final CSSModifierProperty RowGap = null;
    public static final CSSModifierProperty TextAlign = null;
    public static final CSSModifierProperty TextDecoration = null;
    public static final CSSModifierProperty TextDecorationColor = null;
    public static final CSSModifierProperty TextIndent = null;
    public static final CSSModifierProperty TextOverflow = null;
    public static final CSSModifierProperty TextShadow = null;
    public static final CSSModifierProperty TextShadowBlurRadius = null;
    public static final CSSModifierProperty TextShadowColor = null;
    public static final CSSModifierProperty TextShadowOffsetX = null;
    public static final CSSModifierProperty TextShadowOffsetY = null;
    public static final CSSModifierProperty TextShadowSpreadRadius = null;
    public static final CSSModifierProperty TextStroke = null;
    public static final CSSModifierProperty TextStrokeColor = null;
    public static final CSSModifierProperty TextStrokeWidth = null;
    public static final CSSModifierProperty Top = null;
    public static final CSSModifierProperty Transform = null;
    public static final CSSModifierProperty TransformOrigin = null;
    public static final CSSModifierProperty TransformOriginOffsetX = null;
    public static final CSSModifierProperty TransformOriginOffsetY = null;
    public static final CSSModifierProperty Transition = null;
    public static final CSSModifierProperty TransitionDelay = null;
    public static final CSSModifierProperty TransitionDuration = null;
    public static final CSSModifierProperty TransitionProperty = null;
    public static final CSSModifierProperty TransitionTimingFunction = null;
    public static final CSSModifierProperty VerticalAlign = null;
    public static final CSSModifierProperty Visibility = null;
    public static final CSSModifierProperty WhiteSpace = null;
    public static final CSSModifierProperty Width = null;
    public static final CSSModifierProperty WordBreak = null;
    public static final CSSModifierProperty XAutoFontSize = null;
    public static final CSSModifierProperty XAutoFontSizePresetSizes = null;
    public static final CSSModifierProperty ZIndex = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CSSModifierProperty[] f405690a = null;
    private final int mValue;

    public static String CSSModifierPropertyToString(int r100) {
        switch(r100) {
            case 0: goto L447;
            case 1: goto L445;
            case 2: goto L443;
            case 3: goto L441;
            case 4: goto L439;
            case 5: goto L437;
            case 6: goto L435;
            case 7: goto L433;
            case 8: goto L431;
            case 9: goto L429;
            case 10: goto L427;
            case 11: goto L425;
            case 12: goto L423;
            case 13: goto L421;
            case 14: goto L419;
            case 15: goto L417;
            case 16: goto L415;
            case 17: goto L413;
            case 18: goto L411;
            case 19: goto L409;
            case 20: goto L407;
            case 21: goto L405;
            case 22: goto L403;
            case 23: goto L401;
            case 24: goto L399;
            case 25: goto L397;
            case 26: goto L395;
            case 27: goto L393;
            case 28: goto L391;
            case 29: goto L389;
            case 30: goto L387;
            case 31: goto L385;
            case 32: goto L383;
            case 33: goto L381;
            case 34: goto L379;
            case 35: goto L377;
            case 36: goto L375;
            case 37: goto L373;
            case 38: goto L371;
            case 39: goto L369;
            case 40: goto L367;
            case 41: goto L365;
            case 42: goto L363;
            case 43: goto L361;
            case 44: goto L359;
            case 45: goto L357;
            case 46: goto L355;
            case 47: goto L353;
            case 48: goto L351;
            case 49: goto L349;
            case 50: goto L347;
            case 51: goto L345;
            case 52: goto L343;
            case 53: goto L341;
            case 54: goto L339;
            case 55: goto L337;
            case 56: goto L335;
            case 57: goto L333;
            case 58: goto L331;
            case 59: goto L329;
            case 60: goto L327;
            case 61: goto L325;
            case 62: goto L323;
            case 63: goto L321;
            case 64: goto L319;
            case 65: goto L317;
            case 66: goto L315;
            case 67: goto L313;
            case 68: goto L311;
            case 69: goto L309;
            case 70: goto L307;
            case 71: goto L305;
            case 72: goto L303;
            case 73: goto L301;
            case 74: goto L299;
            case 75: goto L297;
            case 76: goto L295;
            case 77: goto L293;
            case 78: goto L291;
            case 79: goto L289;
            case 80: goto L287;
            case 81: goto L285;
            case 82: goto L283;
            case 83: goto L281;
            case 84: goto L279;
            case 85: goto L277;
            case 86: goto L275;
            case 87: goto L273;
            case 88: goto L271;
            case 89: goto L269;
            case 90: goto L267;
            case 91: goto L265;
            case 92: goto L263;
            case 93: goto L261;
            case 94: goto L259;
            case 95: goto L257;
            case 96: goto L255;
            case 97: goto L253;
            case 98: goto L251;
            case 99: goto L249;
            case 100: goto L247;
            case 101: goto L245;
            case 102: goto L243;
            case 103: goto L241;
            case 104: goto L239;
            case 105: goto L237;
            case 106: goto L235;
            case 107: goto L233;
            case 108: goto L231;
            case 109: goto L229;
            case 110: goto L227;
            case 111: goto L225;
            case 112: goto L223;
            case 113: goto L221;
            case 114: goto L219;
            case 115: goto L217;
            case 116: goto L215;
            case 117: goto L213;
            case 118: goto L211;
            case 119: goto L209;
            case 120: goto L207;
            case 121: goto L205;
            case 122: goto L203;
            case 123: goto L201;
            case 124: goto L199;
            case 125: goto L197;
            case 126: goto L195;
            case 127: goto L193;
            case 128: goto L191;
            case 129: goto L189;
            case 130: goto L187;
            case 131: goto L185;
            case 132: goto L183;
            case 133: goto L181;
            case 134: goto L179;
            case 135: goto L177;
            case 136: goto L175;
            case 137: goto L173;
            case 138: goto L171;
            case 139: goto L169;
            case 140: goto L167;
            case 141: goto L165;
            case 142: goto L163;
            case 143: goto L161;
            case 144: goto L159;
            case 145: goto L157;
            case 146: goto L155;
            case 147: goto L153;
            case 148: goto L151;
            case 149: goto L149;
            case 150: goto L147;
            case 151: goto L145;
            case 152: goto L143;
            case 153: goto L141;
            case 154: goto L139;
            case 155: goto L137;
            case 156: goto L135;
            case 157: goto L133;
            case 158: goto L131;
            case 159: goto L129;
            case 160: goto L127;
            case 161: goto L125;
            case 162: goto L123;
            case 163: goto L121;
            case 164: goto L119;
            case 165: goto L117;
            case 166: goto L115;
            case 167: goto L113;
            case 168: goto L111;
            case 169: goto L109;
            case 170: goto L107;
            case 171: goto L105;
            case 172: goto L103;
            case 173: goto L101;
            case 174: goto L99;
            case 175: goto L97;
            case 176: goto L95;
            case 177: goto L93;
            case 178: goto L91;
            case 179: goto L89;
            case 180: goto L87;
            case 181: goto L85;
            case 182: goto L83;
            case 183: goto L81;
            case 184: goto L79;
            case 185: goto L77;
            case 186: goto L75;
            case 187: goto L73;
            case 188: goto L71;
            case 189: goto L69;
            case 190: goto L67;
            case 191: goto L65;
            case 192: goto L63;
            case 193: goto L61;
            case 194: goto L59;
            case 195: goto L57;
            case 196: goto L55;
            case 197: goto L53;
            case 198: goto L51;
            case 199: goto L49;
            case 200: goto L47;
            case 201: goto L45;
            case 202: goto L43;
            case 203: goto L41;
            case 204: goto L39;
            case 205: goto L37;
            case 206: goto L35;
            case 207: goto L33;
            case 208: goto L31;
            case 209: goto L29;
            case 210: goto L27;
            case 211: goto L25;
            case 212: goto L23;
            case 213: goto L21;
            case 214: goto L19;
            case 215: goto L17;
            case 216: goto L15;
            case 217: goto L13;
            case 218: goto L11;
            case 219: goto L9;
            case 220: goto L7;
            case 221: goto L5;
            default: goto L3;
        };
    L3:
        return "";
    L5:
        return "item-sizing";
    L7:
        return "alignment";
    L9:
        return "display";
    L11:
        return "row-gap";
    L13:
        return "column-gap";
    L15:
        return "grid-auto-flow";
    L17:
        return "justify-items";
    L19:
        return "grid-row-gap";
    L21:
        return "grid-column-gap";
    L23:
        return "grid-auto-rows";
    L25:
        return "grid-auto-columns";
    L27:
        return "grid-template-rows";
    L29:
        return "grid-template-columns";
    L31:
        return "linear-weight-sum";
    L33:
        return "linear-gravity";
    L35:
        return "linear-cross-gravity";
    L37:
        return "linear-orientation";
    L39:
        return GXTemplateKey.FLEXBOX_JUSTIFY_CONTENT;
    L41:
        return GXTemplateKey.FLEXBOX_ALIGN_CONTENT;
    L43:
        return GXTemplateKey.FLEXBOX_ALIGN_ITEMS;
    L45:
        return GXTemplateKey.FLEXBOX_FLEX_WRAP;
    L47:
        return GXTemplateKey.FLEXBOX_FLEX_DIRECTION;
    L49:
        return "keyframes";
    L51:
        return "position";
    L53:
        return GXTemplateKey.FLEXBOX_FLEX_BASIS;
    L55:
        return GXTemplateKey.FLEXBOX_FLEX_SHRINK;
    L57:
        return GXTemplateKey.FLEXBOX_FLEX_GROW;
    L59:
        return "order";
    L61:
        return "linear-layout-gravity";
    L63:
        return "linear-weight";
    L65:
        return "z-index";
    L67:
        return "bottom";
    L69:
        return "right";
    L71:
        return "left";
    L73:
        return "top";
    L75:
        return GXTemplateKey.FLEXBOX_ALIGN_SELF;
    L77:
        return "grid-row-end";
    L79:
        return "grid-row-start";
    L81:
        return "grid-column-end";
    L83:
        return "grid-column-start";
    L85:
        return "grid-row-span";
    L87:
        return "grid-column-span";
    L89:
        return "justify-self";
    L91:
        return "image-rendering";
    L93:
        return "mask-size";
    L95:
        return "mask-origin";
    L97:
        return "mask-clip";
    L99:
        return "mask-position";
    L101:
        return "mask-repeat";
    L103:
        return BuyNowCloseMethod.MASK;
    L105:
        return "-x-auto-font-size-preset-sizes";
    L107:
        return "-x-auto-font-size";
    L109:
        return "text-stroke-color";
    L111:
        return "text-stroke-width";
    L113:
        return "text-stroke";
    L115:
        return "clip-path";
    L117:
        return "text-indent";
    L119:
        return EffectConfiguration.KEY_CURSOR;
    L121:
        return "perspective";
    L123:
        return "linear-direction";
    L125:
        return "list-cross-axis-gap";
    L127:
        return "list-main-axis-gap";
    L129:
        return "filter";
    L131:
        return "mask-image";
    L133:
        return "inset-inline-end";
    L135:
        return "inset-inline-start";
    L137:
        return "relative-inline-end-of";
    L139:
        return "relative-inline-start-of";
    L141:
        return "relative-align-inline-end";
    L143:
        return "relative-align-inline-start";
    L145:
        return "border-end-end-radius";
    L147:
        return "border-start-end-radius";
    L149:
        return "border-end-start-radius";
    L151:
        return "border-start-start-radius";
    L153:
        return "border-inline-end-style";
    L155:
        return "border-inline-start-style";
    L157:
        return "border-inline-end-width";
    L159:
        return "border-inline-start-width";
    L161:
        return "border-inline-end-color";
    L163:
        return "border-inline-start-color";
    L165:
        return "padding-inline-end";
    L167:
        return "padding-inline-start";
    L169:
        return "margin-inline-end";
    L171:
        return "margin-inline-start";
    L173:
        return "text-decoration-color";
    L175:
        return "resume-transition-name";
    L177:
        return "pause-transition-name";
    L179:
        return "exit-transition-name";
    L181:
        return "enter-transition-name";
    L183:
        return "direction";
    L185:
        return "caret-color";
    L187:
        return "vertical-align";
    L189:
        return "outline-width";
    L191:
        return "outline-style";
    L193:
        return "outline-color";
    L195:
        return "outline";
    L197:
        return "background-clip";
    L199:
        return "word-break";
    L201:
        return "overflow-y";
    L203:
        return "overflow-x";
    L205:
        return "implicit-animation";
    L207:
        return "border-bottom-style";
    L209:
        return "border-top-style";
    L211:
        return "border-right-style";
    L213:
        return "border-left-style";
    L215:
        return "content";
    L217:
        return "transition-timing-function";
    L219:
        return "transition-delay";
    L221:
        return "transition-duration";
    L223:
        return "transition-property";
    L225:
        return "transition";
    L227:
        return GXTemplateKey.FLEXBOX_BORDER_BOTTOM;
    L229:
        return GXTemplateKey.FLEXBOX_BORDER_TOP;
    L231:
        return GXTemplateKey.FLEXBOX_BORDER_LEFT;
    L233:
        return GXTemplateKey.FLEXBOX_BORDER_RIGHT;
    L235:
        return RemoteMessageConst.Notification.VISIBILITY;
    L237:
        return "border";
    L239:
        return "background-size-height";
    L241:
        return "background-size-width";
    L243:
        return "background-size";
    L245:
        return "background-repeat";
    L247:
        return "background-origin";
    L249:
        return "background-position-y";
    L251:
        return "background-position-x";
    L253:
        return "background-position";
    L255:
        return GXTemplateKey.STYLE_BACKGROUND_IMAGE;
    L257:
        return "text-shadow-spread-radius";
    L259:
        return "text-shadow-color";
    L261:
        return "text-shadow-blur-radius";
    L263:
        return "text-shadow-offset-y";
    L265:
        return "text-shadow-offset-x";
    L267:
        return "text-shadow";
    L269:
        return GXTemplateKey.STYLE_FONT_TEXT_DECORATION;
    L271:
        return GXTemplateKey.FLEXBOX_ASPECT_RATIO;
    L273:
        return "adapt-font-size";
    L275:
        return "layout-animation-update-delay";
    L277:
        return "layout-animation-update-timing-function";
    L279:
        return "layout-animation-update-duration";
    L281:
        return "layout-animation-delete-property";
    L283:
        return "layout-animation-delete-delay";
    L285:
        return "layout-animation-delete-timing-function";
    L287:
        return "layout-animation-delete-duration";
    L289:
        return "layout-animation-create-property";
    L291:
        return "layout-animation-create-delay";
    L293:
        return "layout-animation-create-timing-function";
    L295:
        return "layout-animation-create-duration";
    L297:
        return "transform-origin-offset-y";
    L299:
        return "transform-origin-offset-x";
    L301:
        return "transform-origin";
    L303:
        return "box-shadow-spread-radius";
    L305:
        return "box-shadow-color";
    L307:
        return "box-shadow-blur-radius";
    L309:
        return "box-shadow-offset-y";
    L311:
        return "box-shadow-offset-x";
    L313:
        return GXTemplateKey.STYLE_BOX_SHADOW;
    L315:
        return "border-style";
    L317:
        return GXTemplateKey.GAIAX_LAYER_LINE_SPACING;
    L319:
        return "animation-play-state";
    L321:
        return "animation-fill-mode";
    L323:
        return "animation-direction";
    L325:
        return "animation-iteration-count";
    L327:
        return "animation-delay";
    L329:
        return "animation-timing-function";
    L331:
        return "animation-duration";
    L333:
        return "animation-name";
    L335:
        return GXTemplateKey.GAIAX_ANIMATION;
    L337:
        return "transform";
    L339:
        return "font-style";
    L341:
        return GXTemplateKey.STYLE_FONT_FAMILY;
    L343:
        return GXTemplateKey.STYLE_BORDER_COLOR;
    L345:
        return "background";
    L347:
        return GXTemplateKey.STYLE_FONT_WEIGHT;
    L349:
        return GXTemplateKey.STYLE_FONT_SIZE;
    L351:
        return GXTemplateKey.STYLE_FONT_TEXT_OVERFLOW;
    L353:
        return GXTemplateKey.STYLE_FONT_LINE_HEIGHT;
    L355:
        return GXTemplateKey.STYLE_FONT_TEXT_ALIGN;
    L357:
        return "letter-spacing";
    L359:
        return "white-space";
    L361:
        return GXTemplateKey.FLEXBOX_MARGIN_BOTTOM;
    L363:
        return GXTemplateKey.FLEXBOX_MARGIN_TOP;
    L365:
        return GXTemplateKey.FLEXBOX_MARGIN_RIGHT;
    L367:
        return GXTemplateKey.FLEXBOX_MARGIN_LEFT;
    L369:
        return GXTemplateKey.FLEXBOX_MARGIN;
    L371:
        return GXTemplateKey.FLEXBOX_PADDING_BOTTOM;
    L373:
        return GXTemplateKey.FLEXBOX_PADDING_TOP;
    L375:
        return GXTemplateKey.FLEXBOX_PADDING_RIGHT;
    L377:
        return GXTemplateKey.FLEXBOX_PADDING_LEFT;
    L379:
        return GXTemplateKey.FLEXBOX_PADDING;
    L381:
        return GXTemplateKey.FLEXBOX_MIN_HEIGHT;
    L383:
        return GXTemplateKey.FLEXBOX_MAX_HEIGHT;
    L385:
        return GXTemplateKey.FLEXBOX_MIN_WIDTH;
    L387:
        return GXTemplateKey.FLEXBOX_MAX_WIDTH;
    L389:
        return "width";
    L391:
        return "height";
    L393:
        return "overflow";
    L395:
        return GXTemplateKey.STYLE_OPACITY;
    L397:
        return "color";
    L399:
        return "border-bottom-width";
    L401:
        return "border-top-width";
    L403:
        return "border-right-width";
    L405:
        return "border-left-width";
    L407:
        return GXTemplateKey.STYLE_BORDER_WIDTH;
    L409:
        return "border-bottom-right-radius-vertical";
    L411:
        return "border-bottom-right-radius-horizontal";
    L413:
        return GXTemplateKey.STYLE_BORDER_BOTTOM_RIGHT_RADIUS;
    L415:
        return "border-top-right-radius-vertical";
    L417:
        return "border-top-right-radius-horizontal";
    L419:
        return GXTemplateKey.STYLE_BORDER_TOP_RIGHT_RADIUS;
    L421:
        return "border-bottom-left-radius-vertical";
    L423:
        return "border-bottom-left-radius-horizontal";
    L425:
        return GXTemplateKey.STYLE_BORDER_BOTTOM_LEFT_RADIUS;
    L427:
        return "border-top-left-radius-vertical";
    L429:
        return "border-top-left-radius-horizontal";
    L431:
        return GXTemplateKey.STYLE_BORDER_TOP_LEFT_RADIUS;
    L433:
        return GXTemplateKey.STYLE_BORDER_RADIUS;
    L435:
        return "border-bottom-color";
    L437:
        return "border-top-color";
    L439:
        return "border-right-color";
    L441:
        return "border-left-color";
    L443:
        return GXTemplateKey.STYLE_BACKGROUND_COLOR;
    L445:
        return "box-sizing";
    L447:
        return "none";
    }

    public static CSSModifierProperty[] values() {
        return (CSSModifierProperty[]) f405690a.clone();
    }

    static {
        CSSModifierProperty r100 = new CSSModifierProperty("None", 0, 0);
        None = r100;
        CSSModifierProperty r101 = new CSSModifierProperty("BoxSizing", 1, 1);
        BoxSizing = r101;
        CSSModifierProperty r102 = new CSSModifierProperty("BackgroundColor", 2, 2);
        BackgroundColor = r102;
        CSSModifierProperty r103 = new CSSModifierProperty("BorderLeftColor", 3, 3);
        BorderLeftColor = r103;
        CSSModifierProperty r104 = new CSSModifierProperty("BorderRightColor", 4, 4);
        BorderRightColor = r104;
        CSSModifierProperty r105 = new CSSModifierProperty("BorderTopColor", 5, 5);
        BorderTopColor = r105;
        CSSModifierProperty r110 = new CSSModifierProperty("BorderBottomColor", 6, 6);
        BorderBottomColor = r110;
        CSSModifierProperty r111 = new CSSModifierProperty("BorderRadius", 7, 7);
        BorderRadius = r111;
        CSSModifierProperty r112 = new CSSModifierProperty("BorderTopLeftRadius", 8, 8);
        BorderTopLeftRadius = r112;
        CSSModifierProperty r113 = new CSSModifierProperty("BorderTopLeftRadiusHorizontal", 9, 9);
        BorderTopLeftRadiusHorizontal = r113;
        CSSModifierProperty r114 = new CSSModifierProperty("BorderTopLeftRadiusVertical", 10, 10);
        BorderTopLeftRadiusVertical = r114;
        CSSModifierProperty r115 = new CSSModifierProperty("BorderBottomLeftRadius", 11, 11);
        BorderBottomLeftRadius = r115;
        CSSModifierProperty r106 = new CSSModifierProperty("BorderBottomLeftRadiusHorizontal", 12, 12);
        BorderBottomLeftRadiusHorizontal = r106;
        CSSModifierProperty r107 = new CSSModifierProperty("BorderBottomLeftRadiusVertical", 13, 13);
        BorderBottomLeftRadiusVertical = r107;
        CSSModifierProperty r108 = new CSSModifierProperty("BorderTopRightRadius", 14, 14);
        BorderTopRightRadius = r108;
        CSSModifierProperty r109 = new CSSModifierProperty("BorderTopRightRadiusHorizontal", 15, 15);
        BorderTopRightRadiusHorizontal = r109;
        CSSModifierProperty r116 = new CSSModifierProperty("BorderTopRightRadiusVertical", 16, 16);
        BorderTopRightRadiusVertical = r116;
        CSSModifierProperty r117 = new CSSModifierProperty("BorderBottomRightRadius", 17, 17);
        BorderBottomRightRadius = r117;
        CSSModifierProperty r118 = new CSSModifierProperty("BorderBottomRightRadiusHorizontal", 18, 18);
        BorderBottomRightRadiusHorizontal = r118;
        CSSModifierProperty r119 = new CSSModifierProperty("BorderBottomRightRadiusVertical", 19, 19);
        BorderBottomRightRadiusVertical = r119;
        CSSModifierProperty r120 = new CSSModifierProperty("BorderWidth", 20, 20);
        BorderWidth = r120;
        CSSModifierProperty r121 = new CSSModifierProperty("BorderLeftWidth", 21, 21);
        BorderLeftWidth = r121;
        CSSModifierProperty r122 = new CSSModifierProperty("BorderRightWidth", 22, 22);
        BorderRightWidth = r122;
        CSSModifierProperty r123 = new CSSModifierProperty("BorderTopWidth", 23, 23);
        BorderTopWidth = r123;
        CSSModifierProperty r124 = new CSSModifierProperty("BorderBottomWidth", 24, 24);
        BorderBottomWidth = r124;
        CSSModifierProperty r125 = new CSSModifierProperty("Color", 25, 25);
        Color = r125;
        CSSModifierProperty r126 = new CSSModifierProperty("Opacity", 26, 26);
        Opacity = r126;
        CSSModifierProperty r127 = new CSSModifierProperty("Overflow", 27, 27);
        Overflow = r127;
        CSSModifierProperty r128 = new CSSModifierProperty("Height", 28, 28);
        Height = r128;
        CSSModifierProperty r129 = new CSSModifierProperty("Width", 29, 29);
        Width = r129;
        CSSModifierProperty r130 = new CSSModifierProperty("MaxWidth", 30, 30);
        MaxWidth = r130;
        CSSModifierProperty r131 = new CSSModifierProperty("MinWidth", 31, 31);
        MinWidth = r131;
        CSSModifierProperty r132 = new CSSModifierProperty("MaxHeight", 32, 32);
        MaxHeight = r132;
        CSSModifierProperty r133 = new CSSModifierProperty("MinHeight", 33, 33);
        MinHeight = r133;
        CSSModifierProperty r134 = new CSSModifierProperty("Padding", 34, 34);
        Padding = r134;
        CSSModifierProperty r135 = new CSSModifierProperty("PaddingLeft", 35, 35);
        PaddingLeft = r135;
        CSSModifierProperty r136 = new CSSModifierProperty("PaddingRight", 36, 36);
        PaddingRight = r136;
        CSSModifierProperty r137 = new CSSModifierProperty("PaddingTop", 37, 37);
        PaddingTop = r137;
        CSSModifierProperty r138 = new CSSModifierProperty("PaddingBottom", 38, 38);
        PaddingBottom = r138;
        CSSModifierProperty r139 = new CSSModifierProperty("Margin", 39, 39);
        Margin = r139;
        CSSModifierProperty r140 = new CSSModifierProperty("MarginLeft", 40, 40);
        MarginLeft = r140;
        CSSModifierProperty r141 = new CSSModifierProperty("MarginRight", 41, 41);
        MarginRight = r141;
        CSSModifierProperty r142 = new CSSModifierProperty("MarginTop", 42, 42);
        MarginTop = r142;
        CSSModifierProperty r143 = new CSSModifierProperty("MarginBottom", 43, 43);
        MarginBottom = r143;
        CSSModifierProperty r144 = new CSSModifierProperty("WhiteSpace", 44, 44);
        WhiteSpace = r144;
        CSSModifierProperty r145 = new CSSModifierProperty("LetterSpacing", 45, 45);
        LetterSpacing = r145;
        CSSModifierProperty r146 = new CSSModifierProperty("TextAlign", 46, 46);
        TextAlign = r146;
        CSSModifierProperty r147 = new CSSModifierProperty("LineHeight", 47, 47);
        LineHeight = r147;
        CSSModifierProperty r148 = new CSSModifierProperty("TextOverflow", 48, 48);
        TextOverflow = r148;
        CSSModifierProperty r149 = new CSSModifierProperty("FontSize", 49, 49);
        FontSize = r149;
        CSSModifierProperty r150 = new CSSModifierProperty("FontWeight", 50, 50);
        FontWeight = r150;
        CSSModifierProperty r151 = new CSSModifierProperty("Background", 51, 51);
        Background = r151;
        CSSModifierProperty r152 = new CSSModifierProperty("BorderColor", 52, 52);
        BorderColor = r152;
        CSSModifierProperty r153 = new CSSModifierProperty("FontFamily", 53, 53);
        FontFamily = r153;
        CSSModifierProperty r154 = new CSSModifierProperty("FontStyle", 54, 54);
        FontStyle = r154;
        CSSModifierProperty r155 = new CSSModifierProperty("Transform", 55, 55);
        Transform = r155;
        CSSModifierProperty r156 = new CSSModifierProperty("Animation", 56, 56);
        Animation = r156;
        CSSModifierProperty r157 = new CSSModifierProperty("AnimationName", 57, 57);
        AnimationName = r157;
        CSSModifierProperty r158 = new CSSModifierProperty("AnimationDuration", 58, 58);
        AnimationDuration = r158;
        CSSModifierProperty r159 = new CSSModifierProperty("AnimationTimingFunction", 59, 59);
        AnimationTimingFunction = r159;
        CSSModifierProperty r160 = new CSSModifierProperty("AnimationDelay", 60, 60);
        AnimationDelay = r160;
        CSSModifierProperty r161 = new CSSModifierProperty("AnimationIterationCount", 61, 61);
        AnimationIterationCount = r161;
        CSSModifierProperty r162 = new CSSModifierProperty("AnimationDirection", 62, 62);
        AnimationDirection = r162;
        CSSModifierProperty r163 = new CSSModifierProperty("AnimationFillMode", 63, 63);
        AnimationFillMode = r163;
        CSSModifierProperty r164 = new CSSModifierProperty("AnimationPlayState", 64, 64);
        AnimationPlayState = r164;
        CSSModifierProperty r165 = new CSSModifierProperty("LineSpacing", 65, 65);
        LineSpacing = r165;
        CSSModifierProperty r166 = new CSSModifierProperty("BorderStyle", 66, 66);
        BorderStyle = r166;
        CSSModifierProperty r167 = new CSSModifierProperty("BoxShadow", 67, 67);
        BoxShadow = r167;
        CSSModifierProperty r168 = new CSSModifierProperty("BoxShadowOffsetX", 68, 68);
        BoxShadowOffsetX = r168;
        CSSModifierProperty r169 = new CSSModifierProperty("BoxShadowOffsetY", 69, 69);
        BoxShadowOffsetY = r169;
        CSSModifierProperty r170 = new CSSModifierProperty("BoxShadowBlurRadius", 70, 70);
        BoxShadowBlurRadius = r170;
        CSSModifierProperty r171 = new CSSModifierProperty("BoxShadowColor", 71, 71);
        BoxShadowColor = r171;
        CSSModifierProperty r172 = new CSSModifierProperty("BoxShadowSpreadRadius", 72, 72);
        BoxShadowSpreadRadius = r172;
        CSSModifierProperty r173 = new CSSModifierProperty("TransformOrigin", 73, 73);
        TransformOrigin = r173;
        CSSModifierProperty r174 = new CSSModifierProperty("TransformOriginOffsetX", 74, 74);
        TransformOriginOffsetX = r174;
        CSSModifierProperty r175 = new CSSModifierProperty("TransformOriginOffsetY", 75, 75);
        TransformOriginOffsetY = r175;
        CSSModifierProperty r176 = new CSSModifierProperty("LayoutAnimationCreateDuration", 76, 76);
        LayoutAnimationCreateDuration = r176;
        CSSModifierProperty r177 = new CSSModifierProperty("LayoutAnimationCreateTimingFunction", 77, 77);
        LayoutAnimationCreateTimingFunction = r177;
        CSSModifierProperty r178 = new CSSModifierProperty("LayoutAnimationCreateDelay", 78, 78);
        LayoutAnimationCreateDelay = r178;
        CSSModifierProperty r179 = new CSSModifierProperty("LayoutAnimationCreateProperty", 79, 79);
        LayoutAnimationCreateProperty = r179;
        CSSModifierProperty r180 = new CSSModifierProperty("LayoutAnimationDeleteDuration", 80, 80);
        LayoutAnimationDeleteDuration = r180;
        CSSModifierProperty r181 = new CSSModifierProperty("LayoutAnimationDeleteTimingFunction", 81, 81);
        LayoutAnimationDeleteTimingFunction = r181;
        CSSModifierProperty r182 = new CSSModifierProperty("LayoutAnimationDeleteDelay", 82, 82);
        LayoutAnimationDeleteDelay = r182;
        CSSModifierProperty r183 = new CSSModifierProperty("LayoutAnimationDeleteProperty", 83, 83);
        LayoutAnimationDeleteProperty = r183;
        CSSModifierProperty r184 = new CSSModifierProperty("LayoutAnimationUpdateDuration", 84, 84);
        LayoutAnimationUpdateDuration = r184;
        CSSModifierProperty r185 = new CSSModifierProperty("LayoutAnimationUpdateTimingFunction", 85, 85);
        LayoutAnimationUpdateTimingFunction = r185;
        CSSModifierProperty r186 = new CSSModifierProperty("LayoutAnimationUpdateDelay", 86, 86);
        LayoutAnimationUpdateDelay = r186;
        CSSModifierProperty r187 = new CSSModifierProperty("AdaptFontSize", 87, 87);
        AdaptFontSize = r187;
        CSSModifierProperty r188 = new CSSModifierProperty("AspectRatio", 88, 88);
        AspectRatio = r188;
        CSSModifierProperty r189 = new CSSModifierProperty("TextDecoration", 89, 89);
        TextDecoration = r189;
        CSSModifierProperty r190 = new CSSModifierProperty("TextShadow", 90, 90);
        TextShadow = r190;
        CSSModifierProperty r191 = new CSSModifierProperty("TextShadowOffsetX", 91, 91);
        TextShadowOffsetX = r191;
        CSSModifierProperty r192 = new CSSModifierProperty("TextShadowOffsetY", 92, 92);
        TextShadowOffsetY = r192;
        CSSModifierProperty r193 = new CSSModifierProperty("TextShadowBlurRadius", 93, 93);
        TextShadowBlurRadius = r193;
        CSSModifierProperty r194 = new CSSModifierProperty("TextShadowColor", 94, 94);
        TextShadowColor = r194;
        CSSModifierProperty r195 = new CSSModifierProperty("TextShadowSpreadRadius", 95, 95);
        TextShadowSpreadRadius = r195;
        CSSModifierProperty r196 = new CSSModifierProperty("BackgroundImage", 96, 96);
        BackgroundImage = r196;
        CSSModifierProperty r197 = new CSSModifierProperty("BackgroundPosition", 97, 97);
        BackgroundPosition = r197;
        CSSModifierProperty r198 = new CSSModifierProperty("BackgroundPositionX", 98, 98);
        BackgroundPositionX = r198;
        CSSModifierProperty r199 = new CSSModifierProperty("BackgroundPositionY", 99, 99);
        BackgroundPositionY = r199;
        CSSModifierProperty r200 = new CSSModifierProperty("BackgroundOrigin", 100, 100);
        BackgroundOrigin = r200;
        CSSModifierProperty r201 = new CSSModifierProperty("BackgroundRepeat", 101, 101);
        BackgroundRepeat = r201;
        CSSModifierProperty r202 = new CSSModifierProperty("BackgroundSize", 102, 102);
        BackgroundSize = r202;
        CSSModifierProperty r203 = new CSSModifierProperty("BackgroundSizeWidth", 103, 103);
        BackgroundSizeWidth = r203;
        CSSModifierProperty r204 = new CSSModifierProperty("BackgroundSizeHeight", 104, 104);
        BackgroundSizeHeight = r204;
        CSSModifierProperty r205 = new CSSModifierProperty("Border", 105, 105);
        Border = r205;
        CSSModifierProperty r206 = new CSSModifierProperty("Visibility", 106, 106);
        Visibility = r206;
        CSSModifierProperty r207 = new CSSModifierProperty("BorderRight", 107, 107);
        BorderRight = r207;
        CSSModifierProperty r208 = new CSSModifierProperty("BorderLeft", 108, 108);
        BorderLeft = r208;
        CSSModifierProperty r209 = new CSSModifierProperty("BorderTop", 109, 109);
        BorderTop = r209;
        CSSModifierProperty r210 = new CSSModifierProperty("BorderBottom", 110, 110);
        BorderBottom = r210;
        CSSModifierProperty r211 = new CSSModifierProperty("Transition", 111, 111);
        Transition = r211;
        CSSModifierProperty r212 = new CSSModifierProperty("TransitionProperty", 112, 112);
        TransitionProperty = r212;
        CSSModifierProperty r213 = new CSSModifierProperty("TransitionDuration", 113, 113);
        TransitionDuration = r213;
        CSSModifierProperty r214 = new CSSModifierProperty("TransitionDelay", 114, 114);
        TransitionDelay = r214;
        CSSModifierProperty r215 = new CSSModifierProperty("TransitionTimingFunction", 115, 115);
        TransitionTimingFunction = r215;
        CSSModifierProperty r216 = new CSSModifierProperty("Content", 116, 116);
        Content = r216;
        CSSModifierProperty r217 = new CSSModifierProperty("BorderLeftStyle", 117, 117);
        BorderLeftStyle = r217;
        CSSModifierProperty r218 = new CSSModifierProperty("BorderRightStyle", 118, 118);
        BorderRightStyle = r218;
        CSSModifierProperty r219 = new CSSModifierProperty("BorderTopStyle", 119, 119);
        BorderTopStyle = r219;
        CSSModifierProperty r220 = new CSSModifierProperty("BorderBottomStyle", 120, 120);
        BorderBottomStyle = r220;
        CSSModifierProperty r221 = new CSSModifierProperty("ImplicitAnimation", 121, 121);
        ImplicitAnimation = r221;
        CSSModifierProperty r222 = new CSSModifierProperty("OverflowX", 122, 122);
        OverflowX = r222;
        CSSModifierProperty r223 = new CSSModifierProperty("OverflowY", 123, 123);
        OverflowY = r223;
        CSSModifierProperty r224 = new CSSModifierProperty("WordBreak", 124, 124);
        WordBreak = r224;
        CSSModifierProperty r225 = new CSSModifierProperty("BackgroundClip", 125, 125);
        BackgroundClip = r225;
        CSSModifierProperty r226 = new CSSModifierProperty("Outline", 126, 126);
        Outline = r226;
        CSSModifierProperty r227 = new CSSModifierProperty("OutlineColor", 127, 127);
        OutlineColor = r227;
        CSSModifierProperty r228 = new CSSModifierProperty("OutlineStyle", 128, 128);
        OutlineStyle = r228;
        CSSModifierProperty r229 = new CSSModifierProperty("OutlineWidth", 129, 129);
        OutlineWidth = r229;
        CSSModifierProperty r230 = new CSSModifierProperty("VerticalAlign", 130, 130);
        VerticalAlign = r230;
        CSSModifierProperty r231 = new CSSModifierProperty("CaretColor", 131, 131);
        CaretColor = r231;
        CSSModifierProperty r232 = new CSSModifierProperty("Direction", 132, 132);
        Direction = r232;
        CSSModifierProperty r233 = new CSSModifierProperty("EnterTransitionName", 133, 133);
        EnterTransitionName = r233;
        CSSModifierProperty r234 = new CSSModifierProperty("ExitTransitionName", 134, 134);
        ExitTransitionName = r234;
        CSSModifierProperty r235 = new CSSModifierProperty("PauseTransitionName", 135, 135);
        PauseTransitionName = r235;
        CSSModifierProperty r236 = new CSSModifierProperty("ResumeTransitionName", 136, 136);
        ResumeTransitionName = r236;
        CSSModifierProperty r237 = new CSSModifierProperty("TextDecorationColor", 137, 137);
        TextDecorationColor = r237;
        CSSModifierProperty r238 = new CSSModifierProperty("MarginInlineStart", 138, 138);
        MarginInlineStart = r238;
        CSSModifierProperty r239 = new CSSModifierProperty("MarginInlineEnd", 139, 139);
        MarginInlineEnd = r239;
        CSSModifierProperty r240 = new CSSModifierProperty("PaddingInlineStart", 140, 140);
        PaddingInlineStart = r240;
        CSSModifierProperty r241 = new CSSModifierProperty("PaddingInlineEnd", 141, 141);
        PaddingInlineEnd = r241;
        CSSModifierProperty r242 = new CSSModifierProperty("BorderInlineStartColor", 142, 142);
        BorderInlineStartColor = r242;
        CSSModifierProperty r243 = new CSSModifierProperty("BorderInlineEndColor", 143, 143);
        BorderInlineEndColor = r243;
        CSSModifierProperty r244 = new CSSModifierProperty("BorderInlineStartWidth", 144, 144);
        BorderInlineStartWidth = r244;
        CSSModifierProperty r245 = new CSSModifierProperty("BorderInlineEndWidth", 145, 145);
        BorderInlineEndWidth = r245;
        CSSModifierProperty r246 = new CSSModifierProperty("BorderInlineStartStyle", 146, 146);
        BorderInlineStartStyle = r246;
        CSSModifierProperty r247 = new CSSModifierProperty("BorderInlineEndStyle", 147, 147);
        BorderInlineEndStyle = r247;
        CSSModifierProperty r248 = new CSSModifierProperty("BorderStartStartRadius", 148, 148);
        BorderStartStartRadius = r248;
        CSSModifierProperty r249 = new CSSModifierProperty("BorderEndStartRadius", 149, 149);
        BorderEndStartRadius = r249;
        CSSModifierProperty r250 = new CSSModifierProperty("BorderStartEndRadius", 150, 150);
        BorderStartEndRadius = r250;
        CSSModifierProperty r251 = new CSSModifierProperty("BorderEndEndRadius", 151, 151);
        BorderEndEndRadius = r251;
        CSSModifierProperty r252 = new CSSModifierProperty("RelativeAlignInlineStart", 152, 152);
        RelativeAlignInlineStart = r252;
        CSSModifierProperty r253 = new CSSModifierProperty("RelativeAlignInlineEnd", 153, 153);
        RelativeAlignInlineEnd = r253;
        CSSModifierProperty r254 = new CSSModifierProperty("RelativeInlineStartOf", 154, 154);
        RelativeInlineStartOf = r254;
        CSSModifierProperty r255 = new CSSModifierProperty("RelativeInlineEndOf", 155, 155);
        RelativeInlineEndOf = r255;
        CSSModifierProperty r256 = new CSSModifierProperty("InsetInlineStart", 156, 156);
        InsetInlineStart = r256;
        CSSModifierProperty r257 = new CSSModifierProperty("InsetInlineEnd", 157, 157);
        InsetInlineEnd = r257;
        CSSModifierProperty r258 = new CSSModifierProperty("MaskImage", 158, 158);
        MaskImage = r258;
        CSSModifierProperty r259 = new CSSModifierProperty(EffectTypeConstants.TYPE_FILTER, 159, 159);
        Filter = r259;
        CSSModifierProperty r260 = new CSSModifierProperty("ListMainAxisGap", 160, 160);
        ListMainAxisGap = r260;
        CSSModifierProperty r261 = new CSSModifierProperty("ListCrossAxisGap", 161, 161);
        ListCrossAxisGap = r261;
        CSSModifierProperty r262 = new CSSModifierProperty("LinearDirection", 162, 162);
        LinearDirection = r262;
        CSSModifierProperty r263 = new CSSModifierProperty("Perspective", 163, 163);
        Perspective = r263;
        CSSModifierProperty r264 = new CSSModifierProperty("Cursor", 164, 164);
        Cursor = r264;
        CSSModifierProperty r265 = new CSSModifierProperty("TextIndent", 165, 165);
        TextIndent = r265;
        CSSModifierProperty r266 = new CSSModifierProperty("ClipPath", 166, 166);
        ClipPath = r266;
        CSSModifierProperty r267 = new CSSModifierProperty("TextStroke", 167, 167);
        TextStroke = r267;
        CSSModifierProperty r268 = new CSSModifierProperty("TextStrokeWidth", 168, 168);
        TextStrokeWidth = r268;
        CSSModifierProperty r269 = new CSSModifierProperty("TextStrokeColor", 169, 169);
        TextStrokeColor = r269;
        CSSModifierProperty r270 = new CSSModifierProperty("XAutoFontSize", 170, 170);
        XAutoFontSize = r270;
        CSSModifierProperty r271 = new CSSModifierProperty("XAutoFontSizePresetSizes", 171, 171);
        XAutoFontSizePresetSizes = r271;
        CSSModifierProperty r272 = new CSSModifierProperty("Mask", 172, 172);
        Mask = r272;
        CSSModifierProperty r273 = new CSSModifierProperty("MaskRepeat", 173, 173);
        MaskRepeat = r273;
        CSSModifierProperty r274 = new CSSModifierProperty("MaskPosition", 174, 174);
        MaskPosition = r274;
        CSSModifierProperty r275 = new CSSModifierProperty("MaskClip", 175, 175);
        MaskClip = r275;
        CSSModifierProperty r276 = new CSSModifierProperty("MaskOrigin", 176, 176);
        MaskOrigin = r276;
        CSSModifierProperty r277 = new CSSModifierProperty("MaskSize", 177, 177);
        MaskSize = r277;
        CSSModifierProperty r278 = new CSSModifierProperty("ImageRendering", 178, 178);
        ImageRendering = r278;
        CSSModifierProperty r279 = new CSSModifierProperty("JustifySelf", 179, 179);
        JustifySelf = r279;
        CSSModifierProperty r280 = new CSSModifierProperty("GridColumnSpan", 180, 180);
        GridColumnSpan = r280;
        CSSModifierProperty r281 = new CSSModifierProperty("GridRowSpan", 181, 181);
        GridRowSpan = r281;
        CSSModifierProperty r282 = new CSSModifierProperty("GridColumnStart", 182, 182);
        GridColumnStart = r282;
        CSSModifierProperty r283 = new CSSModifierProperty("GridColumnEnd", 183, 183);
        GridColumnEnd = r283;
        CSSModifierProperty r284 = new CSSModifierProperty("GridRowStart", 184, 184);
        GridRowStart = r284;
        CSSModifierProperty r285 = new CSSModifierProperty("GridRowEnd", 185, 185);
        GridRowEnd = r285;
        CSSModifierProperty r286 = new CSSModifierProperty("AlignSelf", 186, 186);
        AlignSelf = r286;
        CSSModifierProperty r287 = new CSSModifierProperty("Top", 187, 187);
        Top = r287;
        CSSModifierProperty r288 = new CSSModifierProperty("Left", 188, 188);
        Left = r288;
        CSSModifierProperty r289 = new CSSModifierProperty("Right", 189, 189);
        Right = r289;
        CSSModifierProperty r290 = new CSSModifierProperty("Bottom", 190, 190);
        Bottom = r290;
        CSSModifierProperty r291 = new CSSModifierProperty("ZIndex", 191, 191);
        ZIndex = r291;
        CSSModifierProperty r292 = new CSSModifierProperty("LinearWeight", 192, 192);
        LinearWeight = r292;
        CSSModifierProperty r293 = new CSSModifierProperty("LinearLayoutGravity", 193, 193);
        LinearLayoutGravity = r293;
        CSSModifierProperty r294 = new CSSModifierProperty("Order", MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY);
        Order = r294;
        CSSModifierProperty r295 = new CSSModifierProperty("FlexGrow", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO);
        FlexGrow = r295;
        CSSModifierProperty r296 = new CSSModifierProperty("FlexShrink", MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE);
        FlexShrink = r296;
        CSSModifierProperty r297 = new CSSModifierProperty("FlexBasis", MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY);
        FlexBasis = r297;
        CSSModifierProperty r298 = new CSSModifierProperty("Position", 198, 198);
        Position = r298;
        CSSModifierProperty r299 = new CSSModifierProperty("Keyframes", 199, 199);
        Keyframes = r299;
        CSSModifierProperty r300 = new CSSModifierProperty("FlexDirection", 200, 200);
        FlexDirection = r300;
        CSSModifierProperty r301 = new CSSModifierProperty("FlexWrap", 201, 201);
        FlexWrap = r301;
        CSSModifierProperty r302 = new CSSModifierProperty("AlignItems", 202, 202);
        AlignItems = r302;
        CSSModifierProperty r303 = new CSSModifierProperty("AlignContent", 203, 203);
        AlignContent = r303;
        CSSModifierProperty r304 = new CSSModifierProperty("JustifyContent", 204, 204);
        JustifyContent = r304;
        CSSModifierProperty r305 = new CSSModifierProperty("LinearOrientation", 205, 205);
        LinearOrientation = r305;
        CSSModifierProperty r306 = new CSSModifierProperty("LinearCrossGravity", 206, 206);
        LinearCrossGravity = r306;
        CSSModifierProperty r307 = new CSSModifierProperty("LinearGravity", 207, 207);
        LinearGravity = r307;
        CSSModifierProperty r308 = new CSSModifierProperty("LinearWeightSum", 208, 208);
        LinearWeightSum = r308;
        CSSModifierProperty r309 = new CSSModifierProperty("GridTemplateColumns", 209, 209);
        GridTemplateColumns = r309;
        CSSModifierProperty r310 = new CSSModifierProperty("GridTemplateRows", 210, 210);
        GridTemplateRows = r310;
        CSSModifierProperty r311 = new CSSModifierProperty("GridAutoColumns", 211, 211);
        GridAutoColumns = r311;
        CSSModifierProperty r312 = new CSSModifierProperty("GridAutoRows", 212, 212);
        GridAutoRows = r312;
        CSSModifierProperty r313 = new CSSModifierProperty("GridColumnGap", 213, 213);
        GridColumnGap = r313;
        CSSModifierProperty r314 = new CSSModifierProperty("GridRowGap", 214, 214);
        GridRowGap = r314;
        CSSModifierProperty r315 = new CSSModifierProperty("JustifyItems", 215, 215);
        JustifyItems = r315;
        CSSModifierProperty r316 = new CSSModifierProperty("GridAutoFlow", 216, 216);
        GridAutoFlow = r316;
        CSSModifierProperty r317 = new CSSModifierProperty("ColumnGap", 217, 217);
        ColumnGap = r317;
        CSSModifierProperty r318 = new CSSModifierProperty("RowGap", 218, 218);
        RowGap = r318;
        CSSModifierProperty r319 = new CSSModifierProperty("Display", 219, 219);
        Display = r319;
        CSSModifierProperty r320 = new CSSModifierProperty("Alignment", 220, 220);
        Alignment = r320;
        CSSModifierProperty r321 = new CSSModifierProperty("ItemSizing", 221, 221);
        ItemSizing = r321;
        f405690a = new CSSModifierProperty[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239, r240, r241, r242, r243, r244, r245, r246, r247, r248, r249, r250, r251, r252, r253, r254, r255, r256, r257, r258, r259, r260, r261, r262, r263, r264, r265, r266, r267, r268, r269, r270, r271, r272, r273, r274, r275, r276, r277, r278, r279, r280, r281, r282, r283, r284, r285, r286, r287, r288, r289, r290, r291, r292, r293, r294, r295, r296, r297, r298, r299, r300, r301, r302, r303, r304, r305, r306, r307, r308, r309, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r320, r321};
    }

    public int getValue() {
        return this.mValue;
    }

    public static CSSModifierProperty valueOf(String r100) {
        return (CSSModifierProperty) a.a(CSSModifierProperty.class, r100);
    }

    public CSSModifierProperty(String r100, int r101, int r102) {
        super(r100, r101);
        this.mValue = r102;
    }
}
