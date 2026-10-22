package com.ss.android.vesdk;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class VEEffectParams {
    public static int EFFECT_TYPE_APPEND_COMPOSER = 6;
    public static int EFFECT_TYPE_APPEND_COMPOSER_WITH_TAG = 2;
    public static int EFFECT_TYPE_RELOAD_COMPOSER = 5;
    public static int EFFECT_TYPE_RELOAD_COMPOSER_WITH_TAG = 1;
    public static int EFFECT_TYPE_REMOVE_COMPOSER = 9;
    public static int EFFECT_TYPE_REPLACE_COMPOSER = 7;
    public static int EFFECT_TYPE_REPLACE_COMPOSER_WITH_TAG = 3;
    public static int EFFECT_TYPE_SET_COMPOSER = 4;
    public static int EFFECT_TYPE_SET_COMPOSER_WITH_TAG = 0;
    public static int EFFECT_TYPE_UPDATE_COMPOSER = 8;
    public int TYPE;
    public ArrayList<Boolean> boolArrayValue;
    public boolean boolValueOne;
    public boolean boolValueThree;
    public boolean boolValueTwo;
    public ArrayList<Float> floatArrayValue;
    public float floatValueOne;
    public float floatValueThree;
    public float floatValueTwo;
    public ArrayList<Integer> intArrayValue;
    public int intValueOne;
    public int intValueThree;
    public int intValueTwo;
    public ArrayList<String> stringArrayOne;
    public ArrayList<String> stringArrayThree;
    public ArrayList<String> stringArrayTwo;
    public String stringValueOne;
    public String stringValueThree;
    public String stringValueTwo;

    public String toString() {
        return "type:" + this.TYPE + " int1: " + this.intValueOne + " int2: " + this.intValueTwo + " int3: " + this.intValueThree + " float1: " + this.floatValueOne + " float2: " + this.floatValueTwo + " float3: " + this.floatValueThree + " bool1: " + this.boolValueOne + " bool2: " + this.boolValueTwo + " bool3: " + this.boolValueThree + " string1: " + this.stringValueOne + " string2: " + this.stringValueTwo + " string3: " + this.stringValueThree + " intA: " + this.intArrayValue.toString() + " floatA: " + this.floatArrayValue.toString() + " boolA: " + this.boolArrayValue.toString() + " stringA1: " + this.stringArrayOne.toString() + " stringA2: " + this.stringArrayTwo.toString() + " stringA3: " + this.stringArrayThree.toString();
    }

    public VEEffectParams() {
        this.TYPE = 0;
        this.intValueOne = 0;
        this.intValueTwo = 0;
        this.intValueThree = 0;
        this.floatValueOne = 0.0f;
        this.floatValueTwo = 0.0f;
        this.floatValueThree = 0.0f;
        this.boolValueOne = false;
        this.boolValueTwo = false;
        this.boolValueThree = false;
        this.stringValueOne = "";
        this.stringValueTwo = "";
        this.stringValueThree = "";
        this.intArrayValue = new ArrayList();
        this.floatArrayValue = new ArrayList();
        this.boolArrayValue = new ArrayList();
        this.stringArrayOne = new ArrayList();
        this.stringArrayTwo = new ArrayList();
        this.stringArrayThree = new ArrayList();
    }
}
