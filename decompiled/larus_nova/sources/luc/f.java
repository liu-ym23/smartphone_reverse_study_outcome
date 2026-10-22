package luc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
public interface f {
    boolean a();

    @ExperimentalSerializationApi
    String b(int r100);

    int d();

    @ExperimentalSerializationApi
    List<Annotation> e(int r100);

    String f();

    @ExperimentalSerializationApi
    int g(String r100);

    List<Annotation> getAnnotations();

    o getKind();

    @ExperimentalSerializationApi
    f h(int r100);

    @ExperimentalSerializationApi
    boolean i(int r100);

    boolean isInline();
}
