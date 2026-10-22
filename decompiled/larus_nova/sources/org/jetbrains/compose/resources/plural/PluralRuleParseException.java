package org.jetbrains.compose.resources.plural;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lorg/jetbrains/compose/resources/plural/PluralRuleParseException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "description", "", "position", "", "<init>", "(Ljava/lang/String;I)V", "library_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PluralRuleParseException extends Exception {
    public static final int $stable = 8;

    public PluralRuleParseException(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "description");
        super("Invalid syntax at position " + r101 + ": " + r100);
    }
}
