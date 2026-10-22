package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public class CompositeAlgorithmSpec implements AlgorithmParameterSpec {
    private final List<String> algorithmNames;
    private final List<AlgorithmParameterSpec> parameterSpecs;

    public static class Builder {
        private List<String> algorithmNames;
        private List<AlgorithmParameterSpec> parameterSpecs;

        public Builder() {
            this.algorithmNames = new ArrayList();
            this.parameterSpecs = new ArrayList();
        }

        public static /* synthetic */ List access$000(Builder r100) {
            return r100.algorithmNames;
        }

        public static /* synthetic */ List access$100(Builder r100) {
            return r100.parameterSpecs;
        }

        public Builder add(String r100) {
            this.algorithmNames.add(r100);
            this.parameterSpecs.add(null);
            return this;
        }

        public Builder add(String r100, AlgorithmParameterSpec r101) {
            this.algorithmNames.add(r100);
            this.parameterSpecs.add(r101);
            return this;
        }

        public CompositeAlgorithmSpec build() {
            if (this.algorithmNames.isEmpty() == true) goto L7;
            return new CompositeAlgorithmSpec(this);
        L7:
            throw new IllegalStateException("cannot call build with no algorithm names added");
        }
    }

    public CompositeAlgorithmSpec(Builder r100) {
        this.algorithmNames = Collections.unmodifiableList(new ArrayList(Builder.access$000(r100)));
        this.parameterSpecs = Collections.unmodifiableList(new ArrayList(Builder.access$100(r100)));
    }

    public List<String> getAlgorithmNames() {
        return this.algorithmNames;
    }

    public List<AlgorithmParameterSpec> getParameterSpecs() {
        return this.parameterSpecs;
    }
}
