package dagger.hilt.processor.internal.aggregateddeps;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes41.dex */
@Retention(RetentionPolicy.CLASS)
public @interface AggregatedDeps {
    String[] bindings() default {};

    String[] boundTypes() default {};

    String[] componentEntryPoints() default {};

    String[] components();

    String[] entryPoints() default {};

    String[] modules() default {};

    String[] multibindings() default {};

    String[] replaces() default {};

    String[] serviceContributors() default {};

    String test() default "";
}
