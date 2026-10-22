package com.ss.android.ml.process.bl;

import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class TrainConfig {
    public List<String> input_names;
    public float learning_rate;
    public List<String> output_names;
    public List<String> train_layers;

    public TrainConfig() {
    }

    public String toString() {
        return "TrainInfo{input_names='" + this.input_names + "', output_names='" + this.output_names + "', train_layers=" + this.train_layers + ", learning_rate=" + this.learning_rate + '}';
    }
}
