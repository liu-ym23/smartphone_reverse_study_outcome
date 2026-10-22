package androidx.compose.foundation;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ=\u0010\f\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\tJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÂ\u0003J9\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/compose/foundation/BorderCache;", "", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "borderPath", "Landroidx/compose/ui/graphics/Path;", "<init>", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;Landroidx/compose/ui/graphics/Path;)V", "drawBorderCache", "Landroidx/compose/ui/draw/CacheDrawScope;", "borderSize", "Landroidx/compose/ui/unit/IntSize;", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawBorderCache-EMwLDEs", "(Landroidx/compose/ui/draw/CacheDrawScope;JILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/ImageBitmap;", "obtainPath", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BorderCache {
    private Path borderPath;
    private Canvas canvas;
    private CanvasDrawScope canvasDrawScope;
    private ImageBitmap imageBitmap;

    public BorderCache() {
        this(null, null, null, null, 15, null);
    }

    private final ImageBitmap component1() {
        return this.imageBitmap;
    }

    private final Canvas component2() {
        return this.canvas;
    }

    private final CanvasDrawScope component3() {
        return this.canvasDrawScope;
    }

    private final Path component4() {
        return this.borderPath;
    }

    public static /* synthetic */ BorderCache copy$default(BorderCache r0, ImageBitmap r1, Canvas r2, CanvasDrawScope r3, Path r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.imageBitmap;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.canvas;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.canvasDrawScope;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.borderPath;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final BorderCache copy(ImageBitmap r2, Canvas r3, CanvasDrawScope r4, Path r5) {
        return new BorderCache(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BorderCache) == true) goto L8;
        return false;
    L8:
        BorderCache r6 = (BorderCache) r5;
        if (Intrinsics.areEqual(this.imageBitmap, r6.imageBitmap) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.canvas, r6.canvas) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.canvasDrawScope, r6.canvasDrawScope) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.borderPath, r6.borderPath) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        ImageBitmap r0 = this.imageBitmap;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Canvas r4 = this.canvas;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        CanvasDrawScope r7 = this.canvasDrawScope;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Path r10 = this.borderPath;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BorderCache(imageBitmap=" + this.imageBitmap + ", canvas=" + this.canvas + ", canvasDrawScope=" + this.canvasDrawScope + ", borderPath=" + this.borderPath + ')';
    }

    public final Path obtainPath() {
        Path r0 = this.borderPath;
        if (r0 != null) goto L6;
        Path r1 = AndroidPath_androidKt.Path();
        this.borderPath = r1;
        return r1;
    L6:
        return r0;
    }

    public static final /* synthetic */ Canvas access$getCanvas$p(BorderCache r0) {
        return r0.canvas;
    }

    public static final /* synthetic */ CanvasDrawScope access$getCanvasDrawScope$p(BorderCache r0) {
        return r0.canvasDrawScope;
    }

    public static final /* synthetic */ ImageBitmap access$getImageBitmap$p(BorderCache r0) {
        return r0.imageBitmap;
    }

    public static final /* synthetic */ void access$setCanvas$p(BorderCache r0, Canvas r1) {
        r0.canvas = r1;
    }

    public static final /* synthetic */ void access$setCanvasDrawScope$p(BorderCache r0, CanvasDrawScope r1) {
        r0.canvasDrawScope = r1;
    }

    public static final /* synthetic */ void access$setImageBitmap$p(BorderCache r0, ImageBitmap r1) {
        r0.imageBitmap = r1;
    }

    public BorderCache(ImageBitmap r1, Canvas r2, CanvasDrawScope r3, Path r4) {
        this.imageBitmap = r1;
        this.canvas = r2;
        this.canvasDrawScope = r3;
        this.borderPath = r4;
    }

    /* JADX INFO: renamed from: drawBorderCache-EMwLDEs, reason: not valid java name */
    public final ImageBitmap m350drawBorderCacheEMwLDEs(CacheDrawScope r28, long r29, int r31, Function1<? super DrawScope, Unit> r32) {
        ImageBitmap r1 = access$getImageBitmap$p(this);
        Canvas r2 = access$getCanvas$p(this);
        ImageBitmapConfig r3 = null;
        if (r1 == null) goto L5;
        ImageBitmapConfig r4 = ImageBitmapConfig.box-impl(r1.getConfig-_sVssgQ());
    L6:
        int r5 = ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
        boolean r6 = false;
        if (r4 != null) goto L9;
        boolean r7 = false;
    L10:
        if (r7 == true) goto L17;
        if (r1 == null) goto L14;
        r3 = ImageBitmapConfig.box-impl(r1.getConfig-_sVssgQ());
    L14:
        if (ImageBitmapConfig.equals-impl(r31, r3) == true) goto L17;
    L19:
        if (r1 == null) goto L26;
        if (r2 == null) goto L26;
        if (Float.intBitsToFloat((int) (r28.getSize-NH-jbRc() >> 32)) > r1.getWidth()) goto L26;
        if (Float.intBitsToFloat((int) (r28.getSize-NH-jbRc() & 4294967295L)) > r1.getHeight()) goto L26;
        if (r6 == false) goto L26;
    L27:
        CanvasDrawScope r8 = access$getCanvasDrawScope$p(this);
        if (r8 != null) goto L30;
        r8 = new CanvasDrawScope();
        access$setCanvasDrawScope$p(this, r8);
    L30:
        long r9 = IntSizeKt.toSize-ozmzZPI(r29);
        LayoutDirection r10 = r28.getLayoutDirection();
        CanvasDrawScope.DrawParams r11 = r8.getDrawParams();
        Density r15 = r11.component1();
        LayoutDirection r14 = r11.component2();
        Canvas r13 = r11.component3();
        long r12 = r11.component4-NH-jbRc();
        CanvasDrawScope.DrawParams r16 = r8.getDrawParams();
        r16.setDensity(r28);
        r16.setLayoutDirection(r10);
        r16.setCanvas(r2);
        r16.setSize-uvyYCjk(r9);
        r2.save();
        DrawScope.-CC.drawRect-n-J9OG0$default(r8, Color.Companion.getBlack-0d7_KjU(), 0, r9, MenuKt.ClosedAlphaTarget, null, null, BlendMode.Companion.getClear-0nO6VwU(), 58, null);
        r32.invoke(r8);
        r2.restore();
        CanvasDrawScope.DrawParams r17 = r8.getDrawParams();
        r17.setDensity(r15);
        r17.setLayoutDirection(r14);
        r17.setCanvas(r13);
        r17.setSize-uvyYCjk(r12);
        r1.prepareToDraw();
        return r1;
    L26:
        r1 = ImageBitmapKt.ImageBitmap-x__-hDU$default((int) (r29 >> 32), (int) (r29 & 4294967295L), r31, false, null, 24, null);
        access$setImageBitmap$p(this, r1);
        r2 = androidx.compose.ui.graphics.CanvasKt.Canvas(r1);
        access$setCanvas$p(this, r2);
    L17:
        r6 = true;
        goto L19
    L9:
        r7 = ImageBitmapConfig.equals-impl0(r4.unbox-impl(), r5);
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public /* synthetic */ BorderCache(ImageBitmap r2, Canvas r3, CanvasDrawScope r4, Path r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
