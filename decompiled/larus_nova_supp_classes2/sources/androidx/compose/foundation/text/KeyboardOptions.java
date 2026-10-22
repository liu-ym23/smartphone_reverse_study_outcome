package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 K2\u00020\u0001:\u0001KBU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010BS\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0012B1\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0013B=\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0014J\u0017\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u00020\u0005H\u0000¢\u0006\u0002\b9J[\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b;\u0010<J[\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b;\u0010=JC\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b>\u0010?J7\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b@\u0010AJ\u0013\u0010B\u001a\u00020\u00052\b\u0010C\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0000J\u0017\u0010I\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0000H\u0001¢\u0006\u0002\bJR\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\u0011\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010#\u001a\u0004\b(\u0010%R\u0014\u0010)\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010%R\u0014\u0010+\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0016R\u0014\u0010-\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0016R\u0014\u0010/\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0016R\u0014\u00101\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010%R\u0014\u00103\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u0010!R\u0014\u00105\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u0010%¨\u0006L"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions;", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrectEnabled", "", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "showKeyboardOnFocus", "hintLocales", "Landroidx/compose/ui/text/intl/LocaleList;", "<init>", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "autoCorrect", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCapitalization-IUNYP9k", "()I", "I", "getAutoCorrectEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getKeyboardType-PjHm6EE", "getImeAction-eUduSuo", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "getShowKeyboardOnFocus", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "getAutoCorrect$annotations", "()V", "getAutoCorrect", "()Z", "shouldShowKeyboardOnFocus", "getShouldShowKeyboardOnFocus$annotations", "getShouldShowKeyboardOnFocus", "autoCorrectOrDefault", "getAutoCorrectOrDefault", "capitalizationOrDefault", "getCapitalizationOrDefault-IUNYP9k", "keyboardTypeOrDefault", "getKeyboardTypeOrDefault-PjHm6EE", "imeActionOrDefault", "getImeActionOrDefault-eUduSuo$foundation_release", "showKeyboardOnFocusOrDefault", "getShowKeyboardOnFocusOrDefault$foundation_release", "hintLocalesOrDefault", "getHintLocalesOrDefault", "isCompletelyUnspecified", "toImeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "singleLine", "toImeOptions$foundation_release", "copy", "copy-INvB4aQ", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-ij11fho", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-3m2b7yw", "(IZII)Landroidx/compose/foundation/text/KeyboardOptions;", "equals", "other", "hashCode", "", "toString", "", "merge", "fillUnspecifiedValuesWith", "fillUnspecifiedValuesWith$foundation_release", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KeyboardOptions {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final KeyboardOptions Default = null;
    private static final KeyboardOptions SecureTextField = null;
    private final Boolean autoCorrectEnabled;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final Boolean showKeyboardOnFocus;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/text/KeyboardOptions;", "SecureTextField", "getSecureTextField$foundation_release$annotations", "getSecureTextField$foundation_release", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ void getDefault$annotations() {
        }

        public static /* synthetic */ void getSecureTextField$foundation_release$annotations() {
        }

        public final KeyboardOptions getDefault() {
            return KeyboardOptions.access$getDefault$cp();
        }

        public final KeyboardOptions getSecureTextField$foundation_release() {
            return KeyboardOptions.access$getSecureTextField$cp();
        }
    }

    public /* synthetic */ KeyboardOptions(int r1, Boolean r2, int r3, int r4, PlatformImeOptions r5, Boolean r6, LocaleList r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the new constructor that takes optional autoCorrectEnabled parameter.", replaceWith = @ReplaceWith(expression = "KeyboardOptions(capitalization = capitalization, autoCorrectEnabled = autoCorrect, keyboardType = keyboardType, imeAction = imeAction,platformImeOptions = platformImeOptions, showKeyboardOnFocus = showKeyboardOnFocus,hintLocales = hintLocales)", imports = {}))
    public /* synthetic */ KeyboardOptions(int r1, boolean r2, int r3, int r4, PlatformImeOptions r5, Boolean r6, LocaleList r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    public /* synthetic */ KeyboardOptions(int r1, boolean r2, int r3, int r4, PlatformImeOptions r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional platformImeOptions parameter.")
    public /* synthetic */ KeyboardOptions(int r1, boolean r2, int r3, int r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the autoCorrectEnabled property.")
    public static /* synthetic */ void getAutoCorrect$annotations() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Included for binary compatibility. Use showKeyboardOnFocus.")
    public static /* synthetic */ void getShouldShowKeyboardOnFocus$annotations() {
    }

    static {
        Companion = new Companion(null);
        Default = new KeyboardOptions(0, null, 0, 0, null, null, null, 127, null);
        SecureTextField = new KeyboardOptions(0, Boolean.FALSE, KeyboardType.Companion.getPassword-PjHm6EE(), 0, null, null, null, 121, null);
    }

    private final boolean getAutoCorrectOrDefault() {
        Boolean r0 = this.autoCorrectEnabled;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.booleanValue();
    }

    /* JADX INFO: renamed from: getCapitalizationOrDefault-IUNYP9k, reason: not valid java name */
    private final int m1378getCapitalizationOrDefaultIUNYP9k() {
        KeyboardCapitalization r0 = KeyboardCapitalization.box-impl(this.capitalization);
        int r1 = r0.unbox-impl();
        KeyboardCapitalization.Companion r2 = KeyboardCapitalization.Companion;
        if (KeyboardCapitalization.equals-impl0(r1, r2.getUnspecified-IUNYP9k()) == false) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        return r0.unbox-impl();
    L9:
        return r2.getNone-IUNYP9k();
    }

    private final LocaleList getHintLocalesOrDefault() {
        LocaleList r0 = this.hintLocales;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return LocaleList.Companion.getEmpty();
    }

    /* JADX INFO: renamed from: getKeyboardTypeOrDefault-PjHm6EE, reason: not valid java name */
    private final int m1379getKeyboardTypeOrDefaultPjHm6EE() {
        KeyboardType r0 = KeyboardType.box-impl(this.keyboardType);
        int r1 = r0.unbox-impl();
        KeyboardType.Companion r2 = KeyboardType.Companion;
        if (KeyboardType.equals-impl0(r1, r2.getUnspecified-PjHm6EE()) == false) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        return r0.unbox-impl();
    L9:
        return r2.getText-PjHm6EE();
    }

    private final boolean isCompletelyUnspecified() {
        if (KeyboardCapitalization.equals-impl0(this.capitalization, KeyboardCapitalization.Companion.getUnspecified-IUNYP9k()) == true) goto L5;
    L17:
        return false;
    L5:
        if (this.autoCorrectEnabled != null) goto L17;
        if (KeyboardType.equals-impl0(this.keyboardType, KeyboardType.Companion.getUnspecified-PjHm6EE()) == false) goto L17;
        if (ImeAction.equals-impl0(this.imeAction, ImeAction.Companion.getUnspecified-eUduSuo()) == false) goto L17;
        if (this.platformImeOptions != null) goto L17;
        if (this.showKeyboardOnFocus != null) goto L17;
        if (this.hintLocales != null) goto L17;
        return true;
    }

    /* JADX INFO: renamed from: getImeActionOrDefault-eUduSuo$foundation_release, reason: not valid java name */
    public final int m1386getImeActionOrDefaulteUduSuo$foundation_release() {
        ImeAction r0 = ImeAction.box-impl(this.imeAction);
        int r1 = r0.unbox-impl();
        ImeAction.Companion r2 = ImeAction.Companion;
        if (ImeAction.equals-impl0(r1, r2.getUnspecified-eUduSuo()) == false) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        return r0.unbox-impl();
    L9:
        return r2.getDefault-eUduSuo();
    }

    public final /* synthetic */ boolean getShouldShowKeyboardOnFocus() {
        Boolean r0 = this.showKeyboardOnFocus;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.booleanValue();
    }

    public final boolean getShowKeyboardOnFocusOrDefault$foundation_release() {
        Boolean r0 = this.showKeyboardOnFocus;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.booleanValue();
    }

    public int hashCode() {
        int r0 = KeyboardCapitalization.hashCode-impl(this.capitalization) * 31;
        Boolean r1 = this.autoCorrectEnabled;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (((((r0 + r3) * 31) + KeyboardType.hashCode-impl(this.keyboardType)) * 31) + ImeAction.hashCode-impl(this.imeAction)) * 31;
        PlatformImeOptions r5 = this.platformImeOptions;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        Boolean r8 = this.showKeyboardOnFocus;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        LocaleList r11 = this.hintLocales;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + KeyboardCapitalization.toString-impl(this.capitalization) + ", autoCorrectEnabled=" + this.autoCorrectEnabled + ", keyboardType=" + KeyboardType.toString-impl(this.keyboardType) + ", imeAction=" + ImeAction.toString-impl(this.imeAction) + ", platformImeOptions=" + this.platformImeOptions + "showKeyboardOnFocus=" + this.showKeyboardOnFocus + ", hintLocales=" + this.hintLocales + ')';
    }

    public final boolean getAutoCorrect() {
        return getAutoCorrectOrDefault();
    }

    public static final /* synthetic */ KeyboardOptions access$getDefault$cp() {
        return Default;
    }

    public static final /* synthetic */ KeyboardOptions access$getSecureTextField$cp() {
        return SecureTextField;
    }

    public final Boolean getAutoCorrectEnabled() {
        return this.autoCorrectEnabled;
    }

    /* JADX INFO: renamed from: getCapitalization-IUNYP9k, reason: not valid java name */
    public final int m1384getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    public final LocaleList getHintLocales() {
        return this.hintLocales;
    }

    /* JADX INFO: renamed from: getImeAction-eUduSuo, reason: not valid java name */
    public final int m1385getImeActioneUduSuo() {
        return this.imeAction;
    }

    /* JADX INFO: renamed from: getKeyboardType-PjHm6EE, reason: not valid java name */
    public final int m1387getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final Boolean getShowKeyboardOnFocus() {
        return this.showKeyboardOnFocus;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KeyboardOptions) == true) goto L8;
        return false;
    L8:
        KeyboardOptions r6 = (KeyboardOptions) r5;
        if (KeyboardCapitalization.equals-impl0(this.capitalization, r6.capitalization) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.autoCorrectEnabled, r6.autoCorrectEnabled) == true) goto L15;
        return false;
    L15:
        if (KeyboardType.equals-impl0(this.keyboardType, r6.keyboardType) == true) goto L18;
        return false;
    L18:
        if (ImeAction.equals-impl0(this.imeAction, r6.imeAction) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.platformImeOptions, r6.platformImeOptions) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.showKeyboardOnFocus, r6.showKeyboardOnFocus) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.hintLocales, r6.hintLocales) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final KeyboardOptions fillUnspecifiedValuesWith$foundation_release(KeyboardOptions r13) {
        if (r13 != null) goto L4;
    L46:
        return this;
    L4:
        if (r13.isCompletelyUnspecified() == true) goto L46;
        if (Intrinsics.areEqual(r13, this) == true) goto L46;
        if (isCompletelyUnspecified() == false) goto L11;
        return r13;
    L11:
        KeyboardCapitalization r0 = KeyboardCapitalization.box-impl(this.capitalization);
        ImeAction r2 = null;
        if (KeyboardCapitalization.equals-impl0(r0.unbox-impl(), KeyboardCapitalization.Companion.getUnspecified-IUNYP9k()) == false) goto L15;
        r0 = null;
    L15:
        if (r0 == null) goto L17;
        int r1 = r0.unbox-impl();
    L18:
        int r4 = r1;
        Boolean r3 = this.autoCorrectEnabled;
        if (r3 != null) goto L21;
        r3 = r13.autoCorrectEnabled;
    L21:
        Boolean r5 = r3;
        KeyboardType r6 = KeyboardType.box-impl(this.keyboardType);
        if (KeyboardType.equals-impl0(r6.unbox-impl(), KeyboardType.Companion.getUnspecified-PjHm6EE()) == false) goto L25;
        r6 = null;
    L25:
        if (r6 == null) goto L27;
        int r7 = r6.unbox-impl();
    L28:
        int r8 = r7;
        ImeAction r9 = ImeAction.box-impl(this.imeAction);
        if (ImeAction.equals-impl0(r9.unbox-impl(), ImeAction.Companion.getUnspecified-eUduSuo()) == true) goto L31;
        r2 = r9;
    L31:
        if (r2 == null) goto L33;
        int r10 = r2.unbox-impl();
    L34:
        int r11 = r10;
        PlatformImeOptions r12 = this.platformImeOptions;
        if (r12 != null) goto L37;
        r12 = r13.platformImeOptions;
    L37:
        PlatformImeOptions r14 = r12;
        Boolean r15 = this.showKeyboardOnFocus;
        if (r15 != null) goto L40;
        r15 = r13.showKeyboardOnFocus;
    L40:
        Boolean r16 = r15;
        LocaleList r17 = this.hintLocales;
        if (r17 != null) goto L43;
        LocaleList r18 = r13.hintLocales;
    L45:
        return new KeyboardOptions(r4, r5, r8, r11, r14, r16, r18, null);
    L43:
        r18 = r17;
        goto L45
    L33:
        r10 = r13.imeAction;
        goto L34
    L27:
        r7 = r13.keyboardType;
        goto L28
    L17:
        r1 = r13.capitalization;
        goto L18
    }

    public final KeyboardOptions merge(KeyboardOptions r1) {
        if (r1 == null) goto L6;
        KeyboardOptions r2 = r1.fillUnspecifiedValuesWith$foundation_release(this);
        if (r2 == null) goto L6;
        return r2;
    L6:
        return this;
    }

    public final ImeOptions toImeOptions$foundation_release(boolean r11) {
        return new ImeOptions(r11, m1378getCapitalizationOrDefaultIUNYP9k(), getAutoCorrectOrDefault(), m1379getKeyboardTypeOrDefaultPjHm6EE(), m1386getImeActionOrDefaulteUduSuo$foundation_release(), this.platformImeOptions, getHintLocalesOrDefault(), null);
    }

    private KeyboardOptions(int r11, boolean r12, int r13, int r14) {
        this(r11, Boolean.valueOf(r12), r13, r14, null, null, null, 96, null);
    }

    public static /* synthetic */ ImeOptions toImeOptions$foundation_release$default(KeyboardOptions r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = ImeOptions.Companion.getDefault().getSingleLine();
    L6:
        return r0.toImeOptions$foundation_release(r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional platformImeOptions parameter.")
    /* JADX INFO: renamed from: copy-3m2b7yw, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1380copy3m2b7yw(int r11, boolean r12, int r13, int r14) {
        return new KeyboardOptions(r11, Boolean.valueOf(r12), r13, r14, this.platformImeOptions, this.showKeyboardOnFocus, this.hintLocales, null);
    }

    private KeyboardOptions(int r11, boolean r12, int r13, int r14, PlatformImeOptions r15) {
        this(r11, Boolean.valueOf(r12), r13, r14, r15, Boolean.valueOf(Default.getShowKeyboardOnFocusOrDefault$foundation_release()), null, 64, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: copy-ij11fho, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1383copyij11fho(int r11, boolean r12, int r13, int r14, PlatformImeOptions r15) {
        return new KeyboardOptions(r11, Boolean.valueOf(r12), r13, r14, r15, this.showKeyboardOnFocus, this.hintLocales, null);
    }

    public /* synthetic */ KeyboardOptions(int r7, boolean r8, int r9, int r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r7 = KeyboardCapitalization.Companion.getUnspecified-IUNYP9k();
    L5:
        int r1 = r7;
        if ((r11 & 2) == 0) goto L8;
        r8 = Default.getAutoCorrectOrDefault();
    L8:
        boolean r2 = r8;
        if ((r11 & 4) == 0) goto L11;
        r9 = KeyboardType.Companion.getUnspecified-PjHm6EE();
    L11:
        int r3 = r9;
        if ((r11 & 8) == 0) goto L14;
        r10 = ImeAction.Companion.getDefault-eUduSuo();
    L14:
        this(r1, r2, r3, r10, null);
    }

    public /* synthetic */ KeyboardOptions(int r8, boolean r9, int r10, int r11, PlatformImeOptions r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        r8 = KeyboardCapitalization.Companion.getNone-IUNYP9k();
    L5:
        int r1 = r8;
        if ((r13 & 2) == 0) goto L8;
        r9 = Default.getAutoCorrectOrDefault();
    L8:
        boolean r2 = r9;
        if ((r13 & 4) == 0) goto L11;
        r10 = KeyboardType.Companion.getText-PjHm6EE();
    L11:
        int r3 = r10;
        if ((r13 & 8) == 0) goto L14;
        r11 = ImeAction.Companion.getDefault-eUduSuo();
    L14:
        int r4 = r11;
        if ((r13 & 16) == 0) goto L17;
        r12 = null;
    L17:
        this(r1, r2, r3, r4, r12, null);
    }

    /* JADX INFO: renamed from: copy-3m2b7yw$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1374copy3m2b7yw$default(KeyboardOptions r0, int r1, boolean r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.capitalization;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.getAutoCorrectOrDefault();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.keyboardType;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.imeAction;
    L15:
        return r0.m1380copy3m2b7yw(r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the copy function that takes an autoCorrectEnabled parameter.", replaceWith = @ReplaceWith(expression = "copy(capitalization = capitalization, autoCorrectEnabled = autoCorrect, keyboardType = keyboardType, imeAction = imeAction,platformImeOptions = platformImeOptions, showKeyboardOnFocus = showKeyboardOnFocus ?: true,hintLocales = hintLocales)", imports = {}))
    /* JADX INFO: renamed from: copy-INvB4aQ, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1382copyINvB4aQ(int r11, boolean r12, int r13, int r14, PlatformImeOptions r15, Boolean r16, LocaleList r17) {
        return new KeyboardOptions(r11, Boolean.valueOf(r12), r13, r14, r15, r16, r17, null);
    }

    private KeyboardOptions(int r1, Boolean r2, int r3, int r4, PlatformImeOptions r5, Boolean r6, LocaleList r7) {
        this.capitalization = r1;
        this.autoCorrectEnabled = r2;
        this.keyboardType = r3;
        this.imeAction = r4;
        this.platformImeOptions = r5;
        this.showKeyboardOnFocus = r6;
        this.hintLocales = r7;
    }

    /* JADX INFO: renamed from: copy-INvB4aQ, reason: not valid java name */
    public final KeyboardOptions m1381copyINvB4aQ(int r11, Boolean r12, int r13, int r14, PlatformImeOptions r15, Boolean r16, LocaleList r17) {
        return new KeyboardOptions(r11, r12, r13, r14, r15, r16, r17, null);
    }

    private KeyboardOptions(int r10, boolean r11, int r12, int r13, PlatformImeOptions r14, Boolean r15, LocaleList r16) {
        this(r10, Boolean.valueOf(r11), r12, r13, r14, r15, r16, null);
    }

    /* JADX INFO: renamed from: copy-ij11fho$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1377copyij11fho$default(KeyboardOptions r3, int r4, boolean r5, int r6, int r7, PlatformImeOptions r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.capitalization;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.getAutoCorrectOrDefault();
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.keyboardType;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.imeAction;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.platformImeOptions;
    L17:
        int r12 = r4;
        return r3.m1383copyij11fho(r12, r11, r0, r1, r8);
    }

    public /* synthetic */ KeyboardOptions(int r9, Boolean r10, int r11, int r12, PlatformImeOptions r13, Boolean r14, LocaleList r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 1) == 0) goto L5;
        int r0 = KeyboardCapitalization.Companion.getUnspecified-IUNYP9k();
    L6:
        LocaleList r2 = null;
        if ((r16 & 2) == 0) goto L9;
        Boolean r1 = null;
    L11:
        if ((r16 & 4) == 0) goto L13;
        int r3 = KeyboardType.Companion.getUnspecified-PjHm6EE();
    L15:
        if ((r16 & 8) == 0) goto L17;
        int r4 = ImeAction.Companion.getUnspecified-eUduSuo();
    L19:
        if ((r16 & 16) == 0) goto L21;
        PlatformImeOptions r5 = null;
    L23:
        if ((r16 & 32) == 0) goto L25;
        Boolean r6 = null;
    L27:
        if ((r16 & 64) != 0) goto L30;
        r2 = r15;
    L30:
        this(r0, r1, r3, r4, r5, r6, r2, null);
        return;
    L25:
        r6 = r14;
        goto L27
    L21:
        r5 = r13;
        goto L23
    L17:
        r4 = r12;
        goto L19
    L13:
        r3 = r11;
        goto L15
    L9:
        r1 = r10;
        goto L11
    L5:
        r0 = r9;
        goto L6
    }

    public /* synthetic */ KeyboardOptions(int r11, boolean r12, int r13, int r14, PlatformImeOptions r15, Boolean r16, LocaleList r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        int r2 = KeyboardCapitalization.Companion.getUnspecified-IUNYP9k();
    L7:
        if ((r18 & 4) == 0) goto L9;
        int r4 = KeyboardType.Companion.getUnspecified-PjHm6EE();
    L11:
        if ((r18 & 8) == 0) goto L13;
        int r5 = ImeAction.Companion.getUnspecified-eUduSuo();
    L15:
        if ((r18 & 16) == 0) goto L17;
        PlatformImeOptions r6 = null;
    L19:
        if ((r18 & 32) == 0) goto L21;
        Boolean r7 = null;
    L23:
        if ((r18 & 64) == 0) goto L25;
        LocaleList r8 = null;
    L26:
        this(r2, r12, r4, r5, r6, r7, r8, null);
        return;
    L25:
        r8 = r17;
        goto L26
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    /* JADX INFO: renamed from: copy-INvB4aQ$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1376copyINvB4aQ$default(KeyboardOptions r5, int r6, boolean r7, int r8, int r9, PlatformImeOptions r10, Boolean r11, LocaleList r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.capitalization;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.getAutoCorrectOrDefault();
    L8:
        boolean r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.keyboardType;
    L11:
        int r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.imeAction;
    L14:
        int r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.platformImeOptions;
    L17:
        PlatformImeOptions r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = Boolean.valueOf(r5.getShowKeyboardOnFocusOrDefault$foundation_release());
    L20:
        Boolean r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.hintLocales;
    L23:
        int r16 = r6;
        return r5.m1382copyINvB4aQ(r16, r15, r0, r1, r2, r3, r12);
    }

    /* JADX INFO: renamed from: copy-INvB4aQ$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1375copyINvB4aQ$default(KeyboardOptions r5, int r6, Boolean r7, int r8, int r9, PlatformImeOptions r10, Boolean r11, LocaleList r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.capitalization;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.autoCorrectEnabled;
    L8:
        Boolean r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.keyboardType;
    L11:
        int r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.imeAction;
    L14:
        int r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.platformImeOptions;
    L17:
        PlatformImeOptions r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        Boolean r3 = null;
    L22:
        if ((r13 & 64) == 0) goto L24;
        LocaleList r4 = null;
    L26:
        return r5.m1381copyINvB4aQ(r6, r15, r0, r1, r2, r3, r4);
    L24:
        r4 = r12;
        goto L26
    L20:
        r3 = r11;
        goto L22
    }
}
