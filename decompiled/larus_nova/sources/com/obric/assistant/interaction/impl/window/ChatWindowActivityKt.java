package com.obric.assistant.interaction.impl.window;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002\u001a\"\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002\u001a*\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002\u001a\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a.\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002¨\u0006\u0012"}, d2 = {"findField", "Ljava/lang/reflect/Field;", "clsStart", "Ljava/lang/Class;", "name", "", "setPrivateFieldSafely", "", PickerReporterConstants.KEY.TARGET, "", "fieldName", "value", "setPrivateFieldIfExists", "setPrivateFieldOrLog", "logTag", "findDeclaredField", "owner", "setDeclaredFieldIfExists", "impl_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ChatWindowActivityKt {
    public static final /* synthetic */ Field access$findDeclaredField(Class r100, String r101) {
        return findDeclaredField(r100, r101);
    }

    private static final Field findDeclaredField(Class<?> r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Field r103 = r100.getDeclaredField(r101);     // Catch: Throwable -> L4
        r103.setAccessible(true);     // Catch: Throwable -> L4
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r104) == false) goto L10;
        r104 = null;
    L10:
        return (Field) r104;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Field findField(Class<?> r100, String r101) {
    L2:
        if (r100 == null) goto L6;
        Field r102 = r100.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L5
        r102.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return r102;
    L5:
        r100 = r100.getSuperclass();
        goto L2
    L6:
        return null;
    }

    public static final /* synthetic */ void access$setPrivateFieldIfExists(Object r100, String r101, Object r102) {
        setPrivateFieldIfExists(r100, r101, r102);
    }

    public static final /* synthetic */ void access$setPrivateFieldSafely(Object r100, String r101, Object r102) {
        setPrivateFieldSafely(r100, r101, r102);
    }

    private static final void setPrivateFieldIfExists(Object r100, String r101, Object r102) {
        Field r103 = findField(r100.getClass(), r101);
        if (r103 == null) goto L6;
        r103.set(r100, r102);
        return;
    }

    private static final void setPrivateFieldSafely(Object r100, String r101, Object r102) {
        Field r103 = findField(r100.getClass(), r101);
        if (r103 == null) goto L7;
        r103.set(r100, r102);
        return;
    L7:
        throw new IllegalStateException(("Field " + r101 + " not found in " + r100.getClass()).toString());
    }

    public static final /* synthetic */ void access$setDeclaredFieldIfExists(Object r100, Class r101, String r102, Object r103) {
        setDeclaredFieldIfExists(r100, r101, r102, r103);
    }

    public static final /* synthetic */ void access$setPrivateFieldOrLog(Object r100, String r101, Object r102, String r103) {
        setPrivateFieldOrLog(r100, r101, r102, r103);
    }

    private static final void setDeclaredFieldIfExists(Object r100, Class<?> r101, String r102, Object r103) {
        Field r104 = findDeclaredField(r101, r102);
        if (r104 == null) goto L6;
        r104.set(r100, r103);
        return;
    }

    private static final void setPrivateFieldOrLog(Object r100, String r101, Object r102, String r103) {
        Field r104 = findField(r100.getClass(), r101);
        if (r104 != null) goto L6;
        FLogger.f375446a.w(r103, "Field " + r101 + " not found in " + r100.getClass().getName());
        return;
    L6:
        r104.set(r100, r102);
    }
}
