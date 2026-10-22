package io.github.alexzhirkevich.compottie.internal.effects;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonClassDiscriminator;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class TintEffect$Companion$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0 implements JsonClassDiscriminator {
    private final /* synthetic */ String discriminator;

    public TintEffect$Companion$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "discriminator");
        this.discriminator = r100;
    }

    @Override // java.lang.annotation.Annotation
    public final /* synthetic */ Class annotationType() {
        return JsonClassDiscriminator.class;
    }

    @Override // kotlinx.serialization.json.JsonClassDiscriminator
    public final /* synthetic */ String discriminator() {
        return this.discriminator;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object r100) {
        if ((r100 instanceof JsonClassDiscriminator) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(discriminator(), ((JsonClassDiscriminator) r100).discriminator()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return this.discriminator.hashCode() ^ 707790692;
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@kotlinx.serialization.json.JsonClassDiscriminator(discriminator=" + this.discriminator + ')';
    }
}
