package com.ss.android.ml.process.bl;

import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class MLConfigModel {
    public static final String MODEL_TYPE_JPMML = "pmml";
    public static final String MODEL_TYPE_TF = "tf";
    public String bytenn_forward_type;
    public boolean enable_gpu;
    public boolean enable_nn_api;
    public List<String> feature_list;
    public List<PreOPModel> input;
    public List<String> input_names;
    public String input_type;
    public List<PreOPModel> intput;
    public String model_type;
    public int num_threads;
    public AfOPModel output;
    public List<String> output_names;
    public TrainConfig train;

    public MLConfigModel() {
    }

    public String toString() {
        return "MLConfigModel{model_type=" + this.model_type + ", input_type=" + this.input_type + ", input_names=" + this.input_names + ", output_names=" + this.output_names + ", intput=" + this.intput + ", input=" + this.input + ", output=" + this.output + ", feature_list=" + this.feature_list + ", enable_nn_api=" + this.enable_nn_api + ", enable_gpu=" + this.enable_gpu + ", bytenn_forward_type=" + this.bytenn_forward_type + ", num_threads=" + this.num_threads + ", train=" + this.train + '}';
    }
}
